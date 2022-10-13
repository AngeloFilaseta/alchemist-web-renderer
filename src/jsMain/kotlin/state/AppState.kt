package state

import it.unibo.alchemist.model.RenderMode
import it.unibo.alchemist.model.SimulationAction
import state.reducers.playButtonReducer
import state.reducers.renderModeReducer

/**
 * The state representing the state of the application.
 * @param renderMode the render mode of the application.
 * It can be either client, server or auto. It is set to auto by default.
 * @param playButton the action to execute on the simulation.
*/

data class AppState(
    val renderMode: RenderMode = RenderMode.AUTO,
    val playButton: SimulationAction = SimulationAction.PAUSE
)

/**
 * Root reducer of the application. Uses all the other reducers.
 * @param state the current state of the application.
 * @param action the action to perform.
 * @return the new state of the application.
 */
fun rootReducer(state: AppState, action: Any): AppState = AppState(
    renderMode = renderModeReducer(state.renderMode, action),
    playButton = playButtonReducer(state.playButton, action)
)
