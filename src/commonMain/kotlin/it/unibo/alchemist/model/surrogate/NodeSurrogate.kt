package it.unibo.alchemist.model.surrogate

import it.unibo.alchemist.model.surrogate.NodeSurrogate.Companion.serialName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * typealias used to clarify the key of the [it.unibo.alchemist.model.surrogate.NodeSurrogate.contents] map.
 */
typealias MoleculeSurrogateName = String

/**
 * Surrogate class for the [it.unibo.alchemist.model.interfaces.Node] interface.
 * @param id the id of the node.
 * @param contents the mapping between molecules and concentrations.
 * @param <TS> the type of concentration surrogate.
 */
@Serializable
@SerialName(serialName)
data class NodeSurrogate<TS>(
    val id: Int,
    val contents: Map<MoleculeSurrogateName, TS>
) {
    companion object {
        /**
         * The serial name used by the class.
         */
        const val serialName: String = "Node"
    }
}
