package it.unibo.alchemist.server.monitor

import it.unibo.alchemist.boundary.interfaces.OutputMonitor
import it.unibo.alchemist.model.interfaces.Actionable
import it.unibo.alchemist.model.interfaces.Environment
import it.unibo.alchemist.model.interfaces.Position
import it.unibo.alchemist.model.interfaces.Time
import it.unibo.alchemist.common.model.surrogate.PositionSurrogate
import it.unibo.alchemist.server.surrogates.utility.toEnvironmentSurrogate
import it.unibo.alchemist.server.state.ServerStore.store
import it.unibo.alchemist.common.state.actions.SetEnvironmentSurrogate

/**
 * A monitor that can be used to get the environment state.
 *
 *  @param <P> position type.
 *  @param <T> concentration type.
 *  @param <PS> position surrogate type.
 *  @param <TS> concentration surrogate type.
 *  @param toConcentrationSurrogate the mapping function from <T> to <TS>.
 *  @param toPositionSurrogate the mapping function from <P> to <PS>.
 */
class EnvironmentMonitor<T, P, TS, PS> (
    private val toConcentrationSurrogate: (T) -> TS,
    private val toPositionSurrogate: (P) -> PS
) : OutputMonitor<T, P>
where P : Position<P>, PS : PositionSurrogate {

    /**
     * Every time the environment changes, map it to its surrogate class and set it as the current
     * [it.unibo.alchemist.model.surrogate.EnvironmentSurrogate].
     * @param environment the updated environment.
     * @param reaction the reaction that triggered the update.
     * @param time the current time.
     * @param step the current step.
     */
    override fun stepDone(environment: Environment<T, P>, reaction: Actionable<T>?, time: Time, step: Long) {
        store.dispatch(
            SetEnvironmentSurrogate(
                environment.toEnvironmentSurrogate(toConcentrationSurrogate, toPositionSurrogate)
            )
        )
    }

    /**
     * Call the stepDone method setting time and step to 0.
     * @param environment the environment.
     */
    override fun initialized(environment: Environment<T, P>) {
        this.stepDone(environment, null, Time.ZERO, 0L)
    }

    /**
     * Call the stepDone method setting the reaction to null.
     * @param environment the updated environment.
     * @param time the final time.
     * @param step the final step.
     */
    override fun finished(environment: Environment<T, P>, time: Time, step: Long) {
        this.stepDone(environment, null, time, step)
    }

    companion object {
        private const val serialVersionUID: Long = 1L
    }
}
