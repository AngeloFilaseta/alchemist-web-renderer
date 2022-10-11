package it.unibo.alchemist.model.surrogate.concentrations.sapere

import it.unibo.alchemist.model.surrogate.concentrations.sapere.ILsaMoleculeSurrogate.Companion.serialName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Surrogate class for the [it.unibo.alchemist.model.interfaces.ILsaMolecule] interface.
 * NOTE: This class should be a subclass of [it.unibo.alchemist.model.surrogate.MoleculeSurrogate], but this is not
 * possible due to bug [KT-38958](https://youtrack.jetbrains.com/issue/KT-38958). Change it when the bug is fixed.
 * @param name the name of the molecule.
 * @param expressions the list of expressions of the molecule.
 */
@Serializable
@SerialName(serialName)
data class ILsaMoleculeSurrogate(
    val name: String,
    val expressions: List<Int> // TODO change from Int to effective type
) {
    companion object {
        /**
         * The serial name used by the class.
         */
        const val serialName: String = "ILsaMolecule"
    }
}
