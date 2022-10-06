package state.reducers

import it.unibo.alchemist.model.SimulationAction
import state.actions.SetPlayButton

/**
 * Reducer for the simulation play button.
 */
fun playButtonReducer(simulationAction: SimulationAction, action: Any): SimulationAction = when (action) {
    is SetPlayButton -> action.simulationAction
    else -> simulationAction
}
