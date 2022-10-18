package it.unibo.alchemist.common.model.surrogate

import it.unibo.alchemist.common.model.surrogate.EnvironmentSurrogate.Companion.serialName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Surrogate class for the [it.unibo.alchemist.model.interfaces.Environment] interface.
 * @param dimensions the number of dimensions of the environment.
 * @param nodes the nodes contained in the environment.
 * @param <TS> the type of concentration.
 * @param <PS> the type of position.
 */
@Serializable
@SerialName(serialName)
data class EnvironmentSurrogate<TS, PS : PositionSurrogate>(
    val dimensions: Int,
    val nodes: List<NodeSurrogate<TS, PS>>
) {

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

        /**
         * @param <TS> the type of concentration.
         * @param <PS> the type of position.
         * @return an empty and uninitialized environment surrogate.
         */
        fun <TS, PS : PositionSurrogate> uninitializedEnvironment(): EnvironmentSurrogate<TS, PS> =
            EnvironmentSurrogate(-1, emptyList())
    }
}
