package state.reducers

import it.unibo.alchemist.model.RenderMode
import state.actions.SetRenderMode

/**
 * Reducer for the render mode.
 */
fun renderModeReducer(state: RenderMode, action: Any): RenderMode = when (action) {
    is SetRenderMode -> action.renderMode
    else -> state
}
