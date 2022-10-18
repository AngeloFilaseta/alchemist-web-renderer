package it.unibo.alchemist.common.state.actions

import it.unibo.alchemist.common.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.common.model.surrogate.PositionSurrogate

/**
 * Redux action to set the EnvironmentSurrogate of the application.
 * @param <TS> the type of the concentration surrogate.
 * @param <PS> the type of the position surrogate.
 * @param environmentSurrogate the new environment surrogate.
 */
data class SetEnvironmentSurrogate<out TS : Any, out PS : PositionSurrogate>(
    val environmentSurrogate: EnvironmentSurrogate<@UnsafeVariance TS, @UnsafeVariance PS>
)
