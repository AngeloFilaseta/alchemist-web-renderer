package it.unibo.alchemist.server.serializers.utility

import it.unibo.alchemist.model.interfaces.Node
import it.unibo.alchemist.model.surrogate.NodeSurrogate

/**
 * A function that maps a [it.unibo.alchemist.model.interfaces.Node] to its surrogate class
 * [it.unibo.alchemist.model.surrogate.NodeSurrogate].
 * @param <T> the original type of the concentration.
 * @param <TS> the surrogate type of concentration.
 * @param toConcentrationSurrogate a function that maps a concentration to its surrogate class.
 * @return the [it.unibo.alchemist.model.surrogate.NodeSurrogate] mapped starting from the
 * [it.unibo.alchemist.model.interfaces.Node].
 */
fun <T, TS> Node<T>.toNodeSurrogate(toConcentrationSurrogate: (T) -> TS): NodeSurrogate<TS> = NodeSurrogate(
    id,
    contents.map { it.key.toMoleculeSurrogate().name to toConcentrationSurrogate(it.value) }.toMap()
)
