package it.unibo.alchemist.common.model

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
