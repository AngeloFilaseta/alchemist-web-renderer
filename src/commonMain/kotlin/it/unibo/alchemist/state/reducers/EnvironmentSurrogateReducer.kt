@file:Suppress("UNCHECKED_CAST")

package it.unibo.alchemist.state.reducers

import it.unibo.alchemist.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.model.surrogate.PositionSurrogate
import it.unibo.alchemist.state.actions.SetEnvironmentSurrogate

/**
 * Reducer for the environment surrogate.
 * @param <TS> type of the concentration surrogate.
 * @param <PS> type of the position surrogate.
 * @param state the current state.
 * @param action the requested action.
 */
fun <TS, PS : PositionSurrogate> environmentSurrogateReducer(
    state: EnvironmentSurrogate<TS, PS>,
    action: Any
): EnvironmentSurrogate<TS, PS> =
    when (action) {
        is SetEnvironmentSurrogate<*, *> -> action.environmentSurrogate as EnvironmentSurrogate<TS, PS>
        else -> state
    }
