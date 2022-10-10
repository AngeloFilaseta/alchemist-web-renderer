package it.unibo.alchemist.model.surrogate

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NodeSurrogateTest : StringSpec({

    val surrogateNode = NodeSurrogate<Int>(29)

    "SurrogateNode should have the correct id" {
        surrogateNode.id shouldBe 29
    }
})
