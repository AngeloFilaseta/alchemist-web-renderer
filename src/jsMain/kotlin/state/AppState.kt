package state

import state.actions.RenderMode
import state.reducers.renderModeReducer

/**
 * The state representing the state of the application.
 */
data class AppState(
    /**
     * The render mode of the application. It can be either client, server or auto. It is set to auto by default.
     */
    val renderMode: RenderMode = RenderMode.AUTO
)

/**
 * Root reducer of the application. Uses all the other reducers.
 */
fun rootReducer(state: AppState, action: Any): AppState = AppState(
    renderMode = renderModeReducer(state.renderMode, action)
)
