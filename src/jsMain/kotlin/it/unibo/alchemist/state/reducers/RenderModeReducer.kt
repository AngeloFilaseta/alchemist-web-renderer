package it.unibo.alchemist.state.reducers

import it.unibo.alchemist.model.RenderMode
import it.unibo.alchemist.state.actions.SetRenderMode

/**
 * Reducer for the render mode.
 * @param state the current render mode state.
 * @param action the action to perform.
 * @return the new render mode.
 */
fun renderModeReducer(state: RenderMode, action: Any): RenderMode = when (action) {
    is SetRenderMode -> action.renderMode
    else -> state
}
