package state

import it.unibo.alchemist.model.RenderMode
import it.unibo.alchemist.model.SimulationAction
import state.reducers.playButtonReducer
import state.reducers.renderModeReducer

/**
 * The state representing the state of the application.
 */
data class AppState(
    /**
     * The render mode of the application. It can be either client, server or auto. It is set to auto by default.
     */
    val renderMode: RenderMode = RenderMode.AUTO,

    /**
     * The action to execute on the simulation.
     */
    val playButton: SimulationAction = SimulationAction.PAUSE
)

/**
 * Root reducer of the application. Uses all the other reducers.
 */
fun rootReducer(state: AppState, action: Any): AppState = AppState(
    renderMode = renderModeReducer(state.renderMode, action),
    playButton = playButtonReducer(state.playButton, action)
)
