package it.unibo.alchemist.model.surrogate

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MoleculeSurrogateTest : StringSpec({

    val surrogateMolecule = MoleculeSurrogate("molecule")

    "Surrogate Molecule should have the correct name" {
        surrogateMolecule.name shouldBe "molecule"
    }
})
