package it.unibo.alchemist.common.model.surrogate

import it.unibo.alchemist.common.model.serializers.Position2DSurrogateSerializer
import it.unibo.alchemist.common.model.surrogate.Position2DSurrogate.Companion.serialName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Surrogate class for the [it.unibo.alchemist.model.interfaces.Position2D] interface.
 * @param x the first coordinate of the position.
 * @param y the second coordinate of the position.
 */
@Serializable(with = Position2DSurrogateSerializer::class)
@SerialName(serialName)
data class Position2DSurrogate(val x: Double, val y: Double) : PositionSurrogate(doubleArrayOf(x, y), 2) {
    companion object {
        /**
         * The serial name used by the class.
         */
        const val serialName: String = "Position2D"
    }
}
