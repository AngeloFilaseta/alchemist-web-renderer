package it.unibo.alchemist.server.surrogates.utility

import it.unibo.alchemist.model.interfaces.Position
import it.unibo.alchemist.model.interfaces.Position2D
import it.unibo.alchemist.model.surrogate.Position2DSurrogate
import it.unibo.alchemist.model.surrogate.PositionSurrogate

/**
 * A set of functions to map the Position to the corresponding surrogate classes.
 */
object ToPositionSurrogate {

    /**
     * @return A function that maps a [it.unibo.alchemist.model.interfaces.Position] to a
     * [it.unibo.alchemist.model.surrogate.Position2DSurrogate] surrogate class. This works only
     * if the position is a [it.unibo.alchemist.model.interfaces.Position2D].
     */
    val toPosition2DSurrogate: (Position<*>) -> Position2DSurrogate = { position ->
        require(position is Position2D<*>)
        Position2DSurrogate(position.x, position.y)
    }

    /**
     * @return A function that maps a [it.unibo.alchemist.model.interfaces.Position] to its surrogate class.
     */
    val toGeneralPositionSurrogate: (Position<*>) -> PositionSurrogate = { position ->
        PositionSurrogate(position.coordinates, position.dimensions)
    }
}
