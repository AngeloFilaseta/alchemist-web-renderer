package it.unibo.alchemist.server.serializers.utility

import it.unibo.alchemist.model.interfaces.Molecule
import it.unibo.alchemist.model.surrogate.MoleculeSurrogate

/**
 * A function that maps a [it.unibo.alchemist.model.interfaces.Molecule] to its surrogate class
 * [it.unibo.alchemist.model.surrogate.MoleculeSurrogate]
 */
fun Molecule.toMoleculeSurrogate(): MoleculeSurrogate = MoleculeSurrogate(name)
