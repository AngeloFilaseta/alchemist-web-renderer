package it.unibo.alchemist.server.surrogates.utility

import it.unibo.alchemist.model.interfaces.Molecule
import it.unibo.alchemist.common.model.surrogate.MoleculeSurrogate

/**
 * A function that maps a [it.unibo.alchemist.model.interfaces.Molecule] to its surrogate class
 * [it.unibo.alchemist.model.surrogate.MoleculeSurrogate]
 * @return the [it.unibo.alchemist.model.surrogate.MoleculeSurrogate] mapped starting from the
 * [it.unibo.alchemist.model.interfaces.Molecule].
 */
fun Molecule.toMoleculeSurrogate(): MoleculeSurrogate = MoleculeSurrogate(name)
