package it.unibo.alchemist.common.state.actions

import it.unibo.alchemist.common.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.common.model.surrogate.PositionSurrogate

/**
 * Redux action to set the EnvironmentSurrogate of the application.
 * @param environmentSurrogate the new environment surrogate.
 */
data class SetEnvironmentSurrogate(val environmentSurrogate: EnvironmentSurrogate<Any, PositionSurrogate>)
