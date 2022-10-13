package it.unibo.alchemist.server.state

import it.unibo.alchemist.model.interfaces.Environment
import it.unibo.alchemist.model.interfaces.Position
import it.unibo.alchemist.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.model.surrogate.PositionSurrogate
import it.unibo.alchemist.server.state.reducers.environmentReducer
import it.unibo.alchemist.state.reducers.environmentSurrogateReducer

/**
 * The state of the server.
 * @param environment the current environment.
 * @param environmentSurrogate the current environment surrogate.
 */
data class ServerState<T, P : Position<out P>, TS, PS : PositionSurrogate>(
    val environment: Environment<T, P>?,
    val environmentSurrogate: EnvironmentSurrogate<TS, PS>
)

/**
 * Root reducer of the application. Uses all the other reducers.
 */
fun <T, P : Position<out P>, TS, PS : PositionSurrogate> rootReducer(
    state: ServerState<T, P, TS, PS>,
    action: Any
): ServerState<T, P, TS, PS> = ServerState(
    environment = environmentReducer(state.environment, action),
    environmentSurrogate = environmentSurrogateReducer(state.environmentSurrogate, action)
)
