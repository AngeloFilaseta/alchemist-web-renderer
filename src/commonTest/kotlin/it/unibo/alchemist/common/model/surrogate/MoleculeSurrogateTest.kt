package it.unibo.alchemist.common.surrogate

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import it.unibo.alchemist.common.model.surrogate.MoleculeSurrogate

class MoleculeSurrogateTest : StringSpec({

    val surrogateMolecule = MoleculeSurrogate("molecule")

    "Surrogate Molecule should have the correct name" {
        surrogateMolecule.name shouldBe "molecule"
    }
})
