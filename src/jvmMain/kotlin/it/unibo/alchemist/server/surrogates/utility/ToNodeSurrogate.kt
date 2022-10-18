package it.unibo.alchemist.server.surrogates.utility

import it.unibo.alchemist.model.interfaces.Environment
import it.unibo.alchemist.model.interfaces.Node
import it.unibo.alchemist.model.interfaces.Position
import it.unibo.alchemist.common.model.surrogate.NodeSurrogate
import it.unibo.alchemist.common.model.surrogate.PositionSurrogate

/**
 * A function that maps a [it.unibo.alchemist.model.interfaces.Node] to its surrogate class
 * [it.unibo.alchemist.model.surrogate.NodeSurrogate].
 * @param environment the environment in which the node is. Used to collapse the position inside the node.
 * @param toConcentrationSurrogate the mapping function from <T> to <TS>.
 * @param toPositionSurrogate the mapping function from <P> to <PS>.
 * @param <T> the original type of the concentration.
 * @param <P> the original type of the position.
 * @param <TS> the surrogate type of concentration.
 * @param <PS> the surrogate type of position.
 * @return the [it.unibo.alchemist.model.surrogate.NodeSurrogate] mapped starting from the
 * [it.unibo.alchemist.model.interfaces.Node].
 */
fun <T, P, TS, PS> Node<T>.toNodeSurrogate(
    environment: Environment<T, P>,
    toConcentrationSurrogate: (T) -> TS,
    toPositionSurrogate: (P) -> PS
): NodeSurrogate<TS, PS>
where P : Position<out P>, PS : PositionSurrogate = NodeSurrogate(
    id,
    contents.map { it.key.toMoleculeSurrogate().name to toConcentrationSurrogate(it.value) }.toMap(),
    toPositionSurrogate(environment.getPosition(this))
)
