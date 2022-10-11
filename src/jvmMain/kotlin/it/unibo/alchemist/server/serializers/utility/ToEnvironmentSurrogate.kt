package it.unibo.alchemist.server.serializers.utility

import it.unibo.alchemist.model.interfaces.Environment
import it.unibo.alchemist.model.interfaces.Position
import it.unibo.alchemist.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.model.surrogate.PositionSurrogate

/**
 * A function that maps an [it.unibo.alchemist.model.interfaces.Environment] to its surrogate class
 * [it.unibo.alchemist.model.surrogate.EnvironmentSurrogate].
 * @param <T> the original type of the concentration.
 * @param <P> the original type of the position.
 * @param <TS> the surrogate type of the concentration.
 * @param <PS> the surrogate type of the position.
 * @param toConcentrationSurrogate a function that maps a concentration to its surrogate class.
 */
fun <T, P, TS, PS> Environment<T, P>.toEnvironmentSurrogate(
    toConcentrationSurrogate: (T) -> TS
): EnvironmentSurrogate<TS, PS>
    where P : Position<out P>, PS : PositionSurrogate {
    return EnvironmentSurrogate(
        dimensions,
        nodes.map { it.toNodeSurrogate(toConcentrationSurrogate) }
    )
}
