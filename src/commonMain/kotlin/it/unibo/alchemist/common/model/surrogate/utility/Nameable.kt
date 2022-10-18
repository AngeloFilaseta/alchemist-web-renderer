package it.unibo.alchemist.common.model.surrogate.utility

import kotlinx.serialization.Serializable

/**
 * This interface is needed to dry, it is used because of a known bug in kotlinx.serialization.
 * @see <a href="https://youtrack.jetbrains.com/issue/KT-38958">KT-38958</a>.
 */
@Serializable
sealed interface Nameable {
    /**
     * The name of the object.
     */
    val name: String
}

/**
 * This abstract class is needed to dry, it is used because of a known bug in kotlinx.serialization.
 * @see <a href="https://youtrack.jetbrains.com/issue/KT-38958">KT-38958</a>.
 */
@Serializable
abstract class AbstractNameable : Nameable {
    abstract override val name: String
}
