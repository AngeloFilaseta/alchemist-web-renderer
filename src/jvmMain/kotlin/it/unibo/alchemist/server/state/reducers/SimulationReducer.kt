package it.unibo.alchemist.server.state.reducers

import it.unibo.alchemist.core.interfaces.Simulation
import it.unibo.alchemist.server.state.actions.SetSimulation

/**
 * Reducer for the [it.unibo.alchemist.core.interfaces.Simulation].
 * @param state the current [it.unibo.alchemist.core.interfaces.Simulation].
 * @param action the requested action.
 * @return the new [it.unibo.alchemist.core.interfaces.Simulation].
 */
fun simulationReducer(state: Simulation<Any, Nothing>?, action: Any): Simulation<Any, Nothing>? =
    when (action) {
        is SetSimulation -> action.simulation
        else -> state
    }
