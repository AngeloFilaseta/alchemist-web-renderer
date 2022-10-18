package it.unibo.alchemist.client.state

import it.unibo.alchemist.client.state.reducers.playButtonReducer
import it.unibo.alchemist.client.state.reducers.renderModeReducer
import it.unibo.alchemist.common.model.RenderMode
import it.unibo.alchemist.common.model.SimulationAction
import it.unibo.alchemist.common.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.common.model.surrogate.PositionSurrogate
import it.unibo.alchemist.common.state.reducers.environmentSurrogateReducer

/**
 * The state representing the state of the application.
 * @param environmentSurrogate the current environment surrogate.
 * @param renderMode the render mode of the application.
 * It can be either client, server or auto. It is set to auto by default.
 * @param playButton the action to execute on the simulation.
*/

data class AppState(
    val environmentSurrogate: EnvironmentSurrogate<Any, PositionSurrogate> =
        EnvironmentSurrogate.uninitializedEnvironment(),
    val renderMode: RenderMode = RenderMode.AUTO,
    val playButton: SimulationAction = SimulationAction.PAUSE
)

/**
 * Root reducer of the application. Uses all the other reducers.
 * @param state the current state of the application.
 * @param action the action to perform.
 * @return the new state of the application.
 */
fun rootReducer(state: AppState, action: Any): AppState = AppState(
    environmentSurrogate = environmentSurrogateReducer(state.environmentSurrogate, action),
    renderMode = renderModeReducer(state.renderMode, action),
    playButton = playButtonReducer(state.playButton, action)
)
