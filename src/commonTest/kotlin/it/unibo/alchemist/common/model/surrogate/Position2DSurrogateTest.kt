package it.unibo.alchemist.common.surrogate

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import it.unibo.alchemist.common.model.surrogate.Position2DSurrogate
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Position2DSurrogateTest : StringSpec({

    val positionSurrogate = Position2DSurrogate(5.012345, 1.0000000001)

    "PositionSurrogate2D should have the correct number of coordinates" {
        positionSurrogate.coordinates.size shouldBe 2
    }

    "PositionSurrogate2D should have the correct number of dimensions" {
        positionSurrogate.dimensions shouldBe 2
    }

    "PositionSurrogate2D should have the correct coordinates" {
        positionSurrogate.coordinates[0] shouldBe 5.012345
        positionSurrogate.coordinates[1] shouldBe 1.0000000001
    }

    "PositionSurrogate2D should be serialized correctly" {
        val serialized = Json.encodeToString(positionSurrogate)
        serialized shouldBe """{"x":5.012345,"y":1.0000000001}"""
        val deserialized = Json.decodeFromString<Position2DSurrogate>(serialized)
        deserialized shouldBe positionSurrogate
    }
})
