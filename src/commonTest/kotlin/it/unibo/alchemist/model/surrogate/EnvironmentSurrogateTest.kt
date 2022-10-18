package it.unibo.alchemist.model.surrogate

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class EnvironmentSurrogateTest : StringSpec({

    val position = Position2DSurrogate(5.6, 8.42)

    val nodesListSet = listOf(
        NodeSurrogate(
            0,
            mapOf("test-0" to 0, "test-1" to 1),
            position
        ),
        NodeSurrogate(
            1,
            mapOf("test-2" to 2),
            position
        )
    )

    val surrogateEnvironment = EnvironmentSurrogate(2, nodesListSet)

    "Surrogate Environment should have the correct dimensions" {
        surrogateEnvironment.dimensions shouldBe 2
    }

    "Surrogate Environment should have the correct nodes" {
        surrogateEnvironment.nodes.size shouldBe 2
        surrogateEnvironment.nodes shouldBe nodesListSet
    }

    "Surrogate Environment should be serialized correctly" {
        val serialized = Json.encodeToString(surrogateEnvironment)
        val deserialized: EnvironmentSurrogate<Int, Position2DSurrogate> = Json.decodeFromString(serialized)
        deserialized shouldBe surrogateEnvironment
    }
})
