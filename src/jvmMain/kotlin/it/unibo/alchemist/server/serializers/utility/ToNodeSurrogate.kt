package it.unibo.alchemist.server.serializers.utility

import it.unibo.alchemist.model.interfaces.Node
import it.unibo.alchemist.model.surrogate.NodeSurrogate

/**
 * A function that maps a [it.unibo.alchemist.model.interfaces.Node] to its surrogate class
 * [it.unibo.alchemist.model.surrogate.NodeSurrogate].
 * @param <TS> the type of concentration.
 */
fun <T, TS> Node<T>.toNodeSurrogate(toConcentrationSurrogate: (T) -> TS): NodeSurrogate<TS> = NodeSurrogate(
    id,
    contents.map { it.key.toMoleculeSurrogate().name to toConcentrationSurrogate(it.value) }.toMap()
)
