package it.unibo.alchemist.server.monitor

import it.unibo.alchemist.boundary.interfaces.OutputMonitor
import it.unibo.alchemist.model.interfaces.Actionable
import it.unibo.alchemist.model.interfaces.Environment
import it.unibo.alchemist.model.interfaces.Position
import it.unibo.alchemist.model.interfaces.Time

/**
 * A monitor that can be used to get the environment state.
 *
 *  @param <P> position type.
 *  @param <T> concentration type.
 */
class EnvironmentMonitor<T, P : Position<out P>> : OutputMonitor<T, P> {

    override fun stepDone(environment: Environment<T, P>, reaction: Actionable<T>?, time: Time, step: Long) {
        println("Step done") // TODO, update the global Environment state
    }

    override fun initialized(environment: Environment<T, P>) {
        this.stepDone(environment, null, Time.ZERO, 0L)
    }

    override fun finished(environment: Environment<T, P>, time: Time, step: Long) {
        this.stepDone(environment, null, time, step)
    }
}
