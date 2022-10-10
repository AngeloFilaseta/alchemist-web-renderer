package it.unibo.alchemist.model.surrogate

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NodeSurrogateTest : StringSpec({

    val mapping = mapOf(MoleculeSurrogate("test-0") to 0, MoleculeSurrogate("test-1") to 1)

    val surrogateNode = NodeSurrogate(29, mapping)

    "SurrogateNode should have the correct id" {
        surrogateNode.id shouldBe 29
    }

    "SurrogateNode should have contents" {
        surrogateNode.contents[MoleculeSurrogate("test-0")] shouldBe 0
        surrogateNode.contents[MoleculeSurrogate("test-1")] shouldBe 1
        surrogateNode.contents.size shouldBe 2
    }
})
