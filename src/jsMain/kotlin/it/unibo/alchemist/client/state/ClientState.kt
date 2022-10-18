package it.unibo.alchemist.client.state

import it.unibo.alchemist.client.state.reducers.playButtonReducer
import it.unibo.alchemist.client.state.reducers.renderModeReducer
import it.unibo.alchemist.common.model.RenderMode
import it.unibo.alchemist.common.model.SimulationAction
import it.unibo.alchemist.common.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.common.model.surrogate.PositionSurrogate
import it.unibo.alchemist.common.state.reducers.environmentSurrogateReducer

/**
 * The class representing the state of the client.
 * @param environmentSurrogate the current environment surrogate.
 * @param renderMode the render mode of the client.
 * It can be either client, server or auto. It is set to auto by default.
 * @param playButton the state of the play button.
*/
data class ClientState(
    val environmentSurrogate: EnvironmentSurrogate<Any, PositionSurrogate> =
        EnvironmentSurrogate.uninitializedEnvironment(),
    val renderMode: RenderMode = RenderMode.AUTO,
    val playButton: SimulationAction = SimulationAction.PAUSE
)

/**
 * Root reducer of the client. Uses all the other reducers.
 * @param state the current state of the application.
 * @param action the action to perform.
 * @return the new state of the application.
 */
fun rootReducer(state: ClientState, action: Any): ClientState = ClientState(
    environmentSurrogate = environmentSurrogateReducer(state.environmentSurrogate, action),
    renderMode = renderModeReducer(state.renderMode, action),
    playButton = playButtonReducer(state.playButton, action)
)
