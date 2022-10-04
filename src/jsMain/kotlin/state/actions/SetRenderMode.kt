package state.actions

import it.unibo.alchemist.model.RenderMode

/**
 * Redux action to set the Render Mode of the application.
 * @param renderMode the new render mode.
 */
data class SetRenderMode(val renderMode: RenderMode)
