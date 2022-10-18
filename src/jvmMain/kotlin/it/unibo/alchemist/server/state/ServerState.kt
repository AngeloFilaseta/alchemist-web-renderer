package it.unibo.alchemist.server.state

import it.unibo.alchemist.common.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.common.model.surrogate.PositionSurrogate
import it.unibo.alchemist.common.state.reducers.environmentSurrogateReducer
import it.unibo.alchemist.common.state.reducers.incarnationReducer
import it.unibo.alchemist.core.interfaces.Simulation
import it.unibo.alchemist.server.state.reducers.simulationReducer

/**
 * The state of the server.
 * @param incarnation the incarnation used by the simulation.
 * @param simulation the simulation.
 * @param environmentSurrogate the current environment surrogate.
 */
data class ServerState(
    val incarnation: String = "",
    val simulation: Simulation<Any, Nothing>? = null,
    val environmentSurrogate: EnvironmentSurrogate<Any, PositionSurrogate> =
        EnvironmentSurrogate.uninitializedEnvironment()
)

/**
 * Root reducer of the application. Uses all the other reducers.
 * @param state the old server state.
 * @param action the action to be applied.
 */
fun rootReducer(
    state: ServerState,
    action: Any
): ServerState = ServerState(
    incarnation = incarnationReducer(state.incarnation, action),
    simulation = simulationReducer(state.simulation, action),
    environmentSurrogate = environmentSurrogateReducer(state.environmentSurrogate, action)
)
