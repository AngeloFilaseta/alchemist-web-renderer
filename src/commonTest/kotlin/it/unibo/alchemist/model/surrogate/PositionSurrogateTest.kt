package it.unibo.alchemist.model.surrogate

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import it.unibo.alchemist.common.model.surrogate.PositionSurrogate
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PositionSurrogateTest : StringSpec({

    val positionSurrogate = PositionSurrogate(doubleArrayOf(5.0, 1.1, 6.0), 3)

    "PositionSurrogate should have the correct number of coordinates" {
        positionSurrogate.coordinates.size shouldBe 3
    }

    "PositionSurrogate should have the correct number of dimensions" {
        positionSurrogate.dimensions shouldBe 3
    }

    "PositionSurrogate should have the correct coordinates" {
        positionSurrogate.coordinates[0] shouldBe 5.0
        positionSurrogate.coordinates[1] shouldBe 1.1
        positionSurrogate.coordinates[2] shouldBe 6.0
    }

    "PositionSurrogate should be serialized correctly" {
        val serialized = Json.encodeToString(positionSurrogate)
        val deserialized = Json.decodeFromString<PositionSurrogate>(serialized)
        deserialized shouldBe positionSurrogate
    }
})
