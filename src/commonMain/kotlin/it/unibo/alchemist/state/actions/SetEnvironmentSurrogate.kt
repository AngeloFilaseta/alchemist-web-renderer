package it.unibo.alchemist.state.actions

import it.unibo.alchemist.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.model.surrogate.PositionSurrogate

/**
 * Redux action to set the EnvironmentSurrogate of the application.
 * @param environmentSurrogate the new environment surrogate.
 */
data class SetEnvironmentSurrogate<TS, PS : PositionSurrogate>(val environmentSurrogate: EnvironmentSurrogate<TS, PS>)
