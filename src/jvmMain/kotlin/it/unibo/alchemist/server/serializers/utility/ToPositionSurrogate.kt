package it.unibo.alchemist.server.serializers.utility

import it.unibo.alchemist.model.interfaces.Position
import it.unibo.alchemist.model.surrogate.Position2DSurrogate
import it.unibo.alchemist.model.surrogate.PositionSurrogate

/**
 * A function that maps a [it.unibo.alchemist.model.interfaces.Position] to its surrogate class
 * [it.unibo.alchemist.model.surrogate.PositionSurrogate].
 * @return the corresponding position surrogate.
 */
fun Position<*>.toPositionSurrogate(): PositionSurrogate = if (dimensions == 2) {
    Position2DSurrogate(coordinates[0], coordinates[1])
} else {
    PositionSurrogate(coordinates, dimensions)
}
