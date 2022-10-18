package it.unibo.alchemist.common.model.surrogate

import it.unibo.alchemist.common.model.surrogate.MoleculeSurrogate.Companion.serialName
import it.unibo.alchemist.common.model.surrogate.utility.AbstractNameable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Surrogate class for the [it.unibo.alchemist.model.interfaces.Molecule] interface.
 * @param name the name of the molecule.
 */
@Serializable
@SerialName(serialName)
data class MoleculeSurrogate(override val name: String) : AbstractNameable() {
    companion object {
        /**
         * The serial name used by the class.
         */
        const val serialName: String = "Molecule"
    }
}
