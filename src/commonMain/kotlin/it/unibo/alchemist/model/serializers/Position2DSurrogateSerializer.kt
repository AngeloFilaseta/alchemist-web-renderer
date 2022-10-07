package it.unibo.alchemist.model.serializers

import it.unibo.alchemist.model.surrogate.Position2DSurrogate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

/**
 * Custom Serializer for the [it.unibo.alchemist.model.surrogate.Position2DSurrogate] class.
 * Output to : {"x": Double,"y": Double}
 */
object Position2DSurrogateSerializer : KSerializer<Position2DSurrogate> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Position2D") {
        element<Double>("x")
        element<Double>("y")
    }

    override fun serialize(encoder: Encoder, value: Position2DSurrogate) {
        encoder.encodeStructure(descriptor) {
            encodeDoubleElement(descriptor, 0, value.x)
            encodeDoubleElement(descriptor, 1, value.y)
        }
    }

    override fun deserialize(decoder: Decoder): Position2DSurrogate {
        return decoder.decodeStructure(descriptor) {
            var x: Double? = null
            var y: Double? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> x = decodeDoubleElement(descriptor, 0)
                    1 -> y = decodeDoubleElement(descriptor, 1)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            Position2DSurrogate(
                x ?: error("x is null"),
                y ?: error("y is null")
            )
        }
    }
}
