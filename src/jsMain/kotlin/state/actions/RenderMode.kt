package state.actions

/**
 * Redux action to set the Render Mode of the application.
 * @param renderMode the new render mode.
 */
data class SetRenderMode(val renderMode: RenderMode)

/**
 * Render mode of the application.
 */
enum class RenderMode {
    /**
     * The rendering computation is executed on the client.
     */
    CLIENT,

    /**
     * A strategy will choose the best rendering mode.
     */
    AUTO,

    /**
     * The rendering computation is executed on the server.
     */
    SERVER
}
