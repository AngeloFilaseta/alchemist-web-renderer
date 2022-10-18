package it.unibo.alchemist.common.state.actions

import it.unibo.alchemist.common.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.common.model.surrogate.PositionSurrogate

/**
 * Redux action to set the EnvironmentSurrogate of the application.
 * @param <TS> type of the concentration surrogate.
 * @param <PS> type of the position surrogate.
 * @param environmentSurrogate the new environment surrogate.
 */
data class SetEnvironmentSurrogate<TS, PS : PositionSurrogate>(val environmentSurrogate: EnvironmentSurrogate<TS, PS>)
