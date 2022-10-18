package it.unibo.alchemist.model.surrogate.concentration.sapere

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import it.unibo.alchemist.common.model.surrogate.concentrations.sapere.ILsaMoleculeSurrogate

class IlsaMoleculeSurrogateTest : StringSpec({

    val surrogate = ILsaMoleculeSurrogate("test", listOf(1, 2))

    "Surrogate IlsaMolecule should have the correct name" {
        surrogate.name shouldBe "test"
    }

    "Surrogate IlsaMolecule should have the correct expressions" {
        surrogate.expressions shouldBe listOf(1, 2)
    }
})
