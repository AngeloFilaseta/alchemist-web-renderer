package it.unibo.alchemist.model.surrogate

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class EnvironmentSurrogateTest : StringSpec({

    val nodesListSet = listOf(
        NodeSurrogate(
            0,
            mapOf("test-0" to 0, "test-1" to 1)
        ),
        NodeSurrogate(
            1,
            mapOf("test-2" to 2)
        )
    )

    val surrogateEnvironment = EnvironmentSurrogate<Int, Position2DSurrogate>(2, nodesListSet)

    "Surrogate Environment should have the correct dimensions" {
        surrogateEnvironment.dimensions shouldBe 2
    }

    "Surrogate Environment should have the correct nodes" {
        surrogateEnvironment.nodes.size shouldBe 2
        surrogateEnvironment.nodes shouldBe nodesListSet
    }
})
