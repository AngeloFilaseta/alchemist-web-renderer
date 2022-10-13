package it.unibo.alchemist.launch

import it.unibo.alchemist.AlchemistExecutionOptions
import it.unibo.alchemist.boundary.interfaces.OutputMonitor
import it.unibo.alchemist.core.interfaces.Simulation
import it.unibo.alchemist.loader.Loader
import it.unibo.alchemist.model.interfaces.ILsaMolecule
import it.unibo.alchemist.model.surrogate.Position2DSurrogate
import it.unibo.alchemist.model.surrogate.concentrations.sapere.ILsaMoleculeSurrogate
import it.unibo.alchemist.server.Server
import it.unibo.alchemist.server.monitor.EnvironmentMonitor
import it.unibo.alchemist.server.serializers.utility.ToConcentrationSurrogate.toSapereConcentrationSurrogate
import it.unibo.alchemist.server.state.ServerStore.store
import it.unibo.alchemist.server.state.actions.SetSimulation
import it.unibo.alchemist.state.actions.SetIncarnation
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.awt.GraphicsEnvironment

/**
 * A launcher that starts a REST server to allow the visualization of the simulation on a Browser.
 */
object ServerLauncher : SimulationLauncher() {
    override val name: String = "REST Server Launcher"

    override fun additionalValidation(currentOptions: AlchemistExecutionOptions): Validation =
        with(currentOptions) {
            when {
                distributed != null -> incompatibleWith("distributed execution")
                graphics != null -> incompatibleWith("graphics")
                headless || GraphicsEnvironment.isHeadless() -> Validation.OK()
                else -> Validation.OK()
            }
        }

    /**
     *  Prepares the simulation to be run, execute it in a coroutine and start the REST server.
     */
    @OptIn(DelicateCoroutinesApi::class)
    override fun launch(loader: Loader, parameters: AlchemistExecutionOptions) {
        val simulation: Simulation<Any, Nothing> = prepareSimulation(loader, parameters, emptyMap<String, Any>())
        initialize(simulation)
        GlobalScope.launch {
            simulation.run()
        }
        Server.start()
    }

    private fun initialize(simulation: Simulation<Any, Nothing>) {
        store.dispatch(SetSimulation(simulation))
        store.dispatch(SetIncarnation("sapere"))
        if (store.state.incarnation == "sapere") {
            @Suppress("UNCHECKED_CAST")
            val environmentMonitor: OutputMonitor<Any, Nothing> =
                EnvironmentMonitor<
                    List<ILsaMolecule>, Nothing, List<ILsaMoleculeSurrogate>, Position2DSurrogate
                    >(toSapereConcentrationSurrogate) as OutputMonitor<Any, Nothing>
            simulation.addOutputMonitor(environmentMonitor)
        }
    }
}
