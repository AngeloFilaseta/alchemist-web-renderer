package it.unibo.alchemist.server.monitor

import it.unibo.alchemist.boundary.interfaces.OutputMonitor
import it.unibo.alchemist.model.interfaces.Actionable
import it.unibo.alchemist.model.interfaces.Environment
import it.unibo.alchemist.model.interfaces.Position
import it.unibo.alchemist.model.interfaces.Time
import it.unibo.alchemist.server.state.ServerStore.store
import it.unibo.alchemist.server.state.actions.SetEnvironment

/**
 * A monitor that can be used to get the environment state.
 *
 *  @param <P> position type.
 *  @param <T> concentration type.
 */
class EnvironmentMonitor<T, P : Position<out P>> : OutputMonitor<T, P> {

    /**
     * Every time the environment changes, set it as the current environment.
     */
    override fun stepDone(environment: Environment<T, P>, reaction: Actionable<T>?, time: Time, step: Long) {
        store.dispatch(SetEnvironment(environment))
    }

    /**
     * Call the stepDone method setting time and step to 0.
     */
    override fun initialized(environment: Environment<T, P>) {
        this.stepDone(environment, null, Time.ZERO, 0L)
    }

    /**
     * Call the stepDone method setting the reaction to null.
     */
    override fun finished(environment: Environment<T, P>, time: Time, step: Long) {
        this.stepDone(environment, null, time, step)
    }

    companion object {
        private const val serialVersionUID: Long = 1L
    }
}
