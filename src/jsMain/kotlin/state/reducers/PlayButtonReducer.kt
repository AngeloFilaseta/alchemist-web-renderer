package state.reducers

import it.unibo.alchemist.model.SimulationAction
import state.actions.SetPlayButton

/**
 * Reducer for the simulation play button.
 * @param simulationAction the current simulation play button state.
 * @param action the action to perform.
 * @return the new simulation play button state.
 */
fun playButtonReducer(simulationAction: SimulationAction, action: Any): SimulationAction = when (action) {
    is SetPlayButton -> action.simulationAction
    else -> simulationAction
}
