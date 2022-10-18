package it.unibo.alchemist.common.state.reducers

import it.unibo.alchemist.common.state.actions.SetIncarnation

/**
 * Reducer for the incarnation surrogate.
 * @param state the current incarnation.
 * @param action the requested action.
 */
fun incarnationReducer(state: String, action: Any): String =
    when (action) {
        is SetIncarnation -> action.incarnation
        else -> state
    }
