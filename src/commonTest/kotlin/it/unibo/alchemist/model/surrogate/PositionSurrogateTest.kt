package it.unibo.alchemist.model.surrogate

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PositionSurrogateTest : StringSpec({

    val positionSurrogate = PositionSurrogate(doubleArrayOf(5.0, 1.0, 6.0), 3)

    "PositionSurrogate should have the correct number of coordinates" {
        positionSurrogate.coordinates.size shouldBe 3
    }

    "PositionSurrogate should have the correct number of dimensions" {
        positionSurrogate.dimensions shouldBe 3
    }

    "PositionSurrogate should have the correct coordinates" {
        positionSurrogate.coordinates[0] shouldBe 5.0
        positionSurrogate.coordinates[1] shouldBe 1.0
        positionSurrogate.coordinates[2] shouldBe 6.0
    }
})
