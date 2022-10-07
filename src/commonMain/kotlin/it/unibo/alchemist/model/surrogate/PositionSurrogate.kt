package it.unibo.alchemist.model.surrogate

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  Surrogate class for the [it.unibo.alchemist.model.interfaces.Position] interface.
 *  @param coordinates the coordinates of the position.
 *  See [it.unibo.alchemist.model.interfaces.Position.coordinates] for details.
 *  @param dimensions the dimensions of the position.
 *  See [it.unibo.alchemist.model.interfaces.Position.dimensions] for details.
 */
@Serializable
@SerialName("Position")
open class PositionSurrogate(
    val coordinates: DoubleArray,
    val dimensions: Int
) {
    init {
        require(coordinates.size == dimensions) {
            "The number of coordinates must be equal to the number of dimensions."
        }
    }

    /**
     * Generated equals because an Array is present in the properties.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as PositionSurrogate

        if (!coordinates.contentEquals(other.coordinates)) return false
        if (dimensions != other.dimensions) return false

        return true
    }

    /**
     * Generated hashCode because an Array is present in the properties.
     */
    override fun hashCode(): Int {
        var result = coordinates.contentHashCode()
        result = 31 * result + dimensions
        return result
    }
}
