package it.unibo.alchemist.server.serializers.utility

import it.unibo.alchemist.model.interfaces.Environment
import it.unibo.alchemist.model.interfaces.Position
import it.unibo.alchemist.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.model.surrogate.PositionSurrogate

/**
 * A function that maps an [it.unibo.alchemist.model.interfaces.Environment] to its surrogate class
 * [it.unibo.alchemist.model.surrogate.EnvironmentSurrogate].
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
