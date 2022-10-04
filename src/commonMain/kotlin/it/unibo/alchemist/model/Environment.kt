package it.unibo.alchemist.model

/**
 * The Environment to render. This is a Surrogate class that will be used instead of the original Alchemist Environment.
 */
@Suppress("UtilityClassWithPublicConstructor") // TODO Remove in the future
class Environment<T, U> {

    /**
     * The available routes for the environment retrieval process.
     */
    companion object {
        private const val path: String = "/environment"

        /**
         * Route used if the client will execute the render computation.
         */
        const val clientModePath: String = "$path/client"

        /**
         * Route used if the server will execute the render computation.
         */
        const val serverModePath: String = "$path/server"
    }
}
