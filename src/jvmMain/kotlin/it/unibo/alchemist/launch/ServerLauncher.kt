package it.unibo.alchemist.launch

import it.unibo.alchemist.AlchemistExecutionOptions
import it.unibo.alchemist.loader.Loader
import java.awt.GraphicsEnvironment

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

    override fun launch(loader: Loader, parameters: AlchemistExecutionOptions) {
        TODO("Not yet implemented")
    }
}
