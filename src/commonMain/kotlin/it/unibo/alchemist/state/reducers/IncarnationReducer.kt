package it.unibo.alchemist.state.reducers

import it.unibo.alchemist.state.actions.SetIncarnation

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
