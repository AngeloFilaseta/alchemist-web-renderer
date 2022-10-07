package it.unibo.alchemist.model.surrogate

import it.unibo.alchemist.model.surrogate.EnvironmentSurrogate.Companion.serialName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Surrogate class for the [it.unibo.alchemist.model.interfaces.Environment] interface.
 */
@Serializable
@SerialName(serialName)
@Suppress("UtilityClassWithPublicConstructor") // TODO Remove in the future
class EnvironmentSurrogate<T> {

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

        /**
         * Serial name used by the class.
         */
        const val serialName: String = "Environment"
    }
}
