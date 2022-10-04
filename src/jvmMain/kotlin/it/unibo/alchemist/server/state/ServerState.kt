package it.unibo.alchemist.server.state

import it.unibo.alchemist.model.interfaces.Environment
import it.unibo.alchemist.model.interfaces.Position
import it.unibo.alchemist.server.state.reducers.environmentReducer

/**
 * The state of the server.
 * @param environment the current environment.
 */
data class ServerState<T, P : Position<out P>>(
    val environment: Environment<T, P>?
)

/**
 * Root reducer of the application. Uses all the other reducers.
 */
fun <T, P : Position<out P>> rootReducer(state: ServerState<T, P>, action: Any): ServerState<T, P> = ServerState(
    environment = environmentReducer(state.environment, action)
)
