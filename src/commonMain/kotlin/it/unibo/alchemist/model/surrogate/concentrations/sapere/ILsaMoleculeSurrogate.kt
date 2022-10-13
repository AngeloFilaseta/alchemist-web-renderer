package it.unibo.alchemist.model.surrogate.concentrations.sapere

import it.unibo.alchemist.model.surrogate.concentrations.sapere.ILsaMoleculeSurrogate.Companion.serialName
import it.unibo.alchemist.model.surrogate.utility.AbstractNameable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Surrogate class for the [it.unibo.alchemist.model.interfaces.ILsaMolecule] interface.
 * @param name the name of the molecule.
 * @param expressions the list of expressions of the molecule.
 */
@Serializable
@SerialName(serialName)
data class ILsaMoleculeSurrogate(
    override val name: String,
    val expressions: List<Int> // TODO change from Int to effective type
) : AbstractNameable() {
    companion object {
        /**
         * The serial name used by the class.
         */
        const val serialName: String = "ILsaMolecule"
    }
}
