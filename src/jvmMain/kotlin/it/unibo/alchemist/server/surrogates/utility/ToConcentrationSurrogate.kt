package it.unibo.alchemist.server.surrogates.utility

import it.unibo.alchemist.model.interfaces.ILsaMolecule
import it.unibo.alchemist.model.surrogate.concentrations.sapere.ILsaMoleculeSurrogate

/**
 * A set of functions to map the concentrations to the corresponding surrogate classes.
 */
object ToConcentrationSurrogate {

    /**
     * @return A function that maps a list of [it.unibo.alchemist.model.interfaces.ILsaMolecule] a list of
     * [it.unibo.alchemist.model.surrogate.concentrations.sapere.ILsaMoleculeSurrogate]. This Concentration is used
     * by the SAPERE Incarnation.
     */
    val toSapereConcentrationSurrogate: (List<ILsaMolecule>) -> List<ILsaMoleculeSurrogate> = { concentration ->
        concentration.map { ILsaMoleculeSurrogate(it.name, listOf()) }
    }
}
