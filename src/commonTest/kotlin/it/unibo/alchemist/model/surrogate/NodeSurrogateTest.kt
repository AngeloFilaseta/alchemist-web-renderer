package it.unibo.alchemist.model.surrogate

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class NodeSurrogateTest : StringSpec({

    val mapping = mapOf("test-0" to 0, "test-1" to 1)

    val nodePosition = Position2DSurrogate(5.6, 1.2)

    val surrogateNode = NodeSurrogate(29, mapping, nodePosition)

    "SurrogateNode should have the correct id" {
        surrogateNode.id shouldBe 29
    }

    "SurrogateNode should have contents" {
        surrogateNode.contents["test-0"] shouldBe 0
        surrogateNode.contents["test-1"] shouldBe 1
        surrogateNode.contents.size shouldBe 2
    }

    "SurrogateNode should have a position" {
        surrogateNode.position shouldBe nodePosition
    }

    "SurrogateNode should be serialized correctly" {
        val serialized = Json.encodeToString(surrogateNode)
        val deserialized = Json.decodeFromString<NodeSurrogate<Int>>(serialized)
        deserialized shouldBe surrogateNode
    }
})
