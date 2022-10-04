package it.unibo.alchemist.server.state.reducers

import it.unibo.alchemist.model.interfaces.Environment
import it.unibo.alchemist.model.interfaces.Position
import it.unibo.alchemist.server.state.actions.SetEnvironment

/**
 * Reducer for the environment.
 */
fun <T, P : Position<out P>?> environmentReducer(state: Environment<T, P>?, action: Any): Environment<T, P>? =
    @Suppress("UNCHECKED_CAST")
    when (action) {
        is SetEnvironment<*, *> -> action.environment as Environment<T, P>?
        else -> state
    }
