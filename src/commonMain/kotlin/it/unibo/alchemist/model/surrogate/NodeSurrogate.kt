package it.unibo.alchemist.model.surrogate

import it.unibo.alchemist.model.surrogate.NodeSurrogate.Companion.serialName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Surrogate class for the [it.unibo.alchemist.model.interfaces.Node] interface.
 * @param id the id of the node.
 * @param <T> the type of concentration.
 */
@Serializable
@SerialName(serialName)
data class NodeSurrogate<T>(val id: Int) {
    companion object {
        /**
         * The serial name used by the class.
         */
        const val serialName: String = "Node"
    }
}
