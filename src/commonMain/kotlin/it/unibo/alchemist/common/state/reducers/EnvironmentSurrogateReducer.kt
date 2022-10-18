@file:Suppress("UNCHECKED_CAST")

package it.unibo.alchemist.common.state.reducers

import it.unibo.alchemist.common.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.common.model.surrogate.PositionSurrogate
import it.unibo.alchemist.common.state.actions.SetEnvironmentSurrogate

/**
 * Reducer for the environment surrogate.
 * @param state the current state.
 * @param action the requested action.
 */
fun environmentSurrogateReducer(
    state: EnvironmentSurrogate<Any, PositionSurrogate>,
    action: Any
): EnvironmentSurrogate<Any, PositionSurrogate> =
    when (action) {
        is SetEnvironmentSurrogate -> action.environmentSurrogate
        else -> state
    }
