package it.unibo.alchemist.server.state

import it.unibo.alchemist.core.interfaces.Simulation
import it.unibo.alchemist.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.model.surrogate.PositionSurrogate
import it.unibo.alchemist.server.state.reducers.simulationReducer
import it.unibo.alchemist.state.reducers.environmentSurrogateReducer
import it.unibo.alchemist.state.reducers.incarnationReducer

/**
 * The state of the server.
 * @param incarnation the incarnation used by the simulation.
 * @param simulation the simulation.
 * @param environmentSurrogate the current environment surrogate.
 * @param <TS> the type of concentration surrogate.
 * @param <PS> the type of position surrogate.
 */
data class ServerState<TS, PS : PositionSurrogate>(
    val incarnation: String = "",
    val simulation: Simulation<Any, Nothing>? = null,
    val environmentSurrogate: EnvironmentSurrogate<TS, PS> = EnvironmentSurrogate.uninitializedEnvironment()
)

/**
 * Root reducer of the application. Uses all the other reducers.
 * @param state the old server state.
 * @param action the action to be applied.
 * @param <TS> the type of concentration surrogate.
 * @param <PS> the type of position surrogate.
 */
fun <TS, PS : PositionSurrogate> rootReducer(
    state: ServerState<TS, PS>,
    action: Any
): ServerState<TS, PS> = ServerState(
    incarnation = incarnationReducer(state.incarnation, action),
    simulation = simulationReducer(state.simulation, action),
    environmentSurrogate = environmentSurrogateReducer(state.environmentSurrogate, action)
)
