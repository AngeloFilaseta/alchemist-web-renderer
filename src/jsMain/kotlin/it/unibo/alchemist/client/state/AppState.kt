package it.unibo.alchemist.client.state

import it.unibo.alchemist.model.RenderMode
import it.unibo.alchemist.model.SimulationAction
import it.unibo.alchemist.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.model.surrogate.PositionSurrogate
import it.unibo.alchemist.state.reducers.environmentSurrogateReducer
import it.unibo.alchemist.client.state.reducers.playButtonReducer
import it.unibo.alchemist.client.state.reducers.renderModeReducer

/**
 * The state representing the state of the application.
 * @param environmentSurrogate the current environment surrogate.
 * @param renderMode the render mode of the application.
 * It can be either client, server or auto. It is set to auto by default.
 * @param playButton the action to execute on the simulation.
 * @param <TS> the type of concentration surrogate.
 * @param <PS> the type of position surrogate.
*/

data class AppState<TS, PS : PositionSurrogate>(
    val environmentSurrogate: EnvironmentSurrogate<TS, PS> = EnvironmentSurrogate.uninitializedEnvironment(),
    val renderMode: RenderMode = RenderMode.AUTO,
    val playButton: SimulationAction = SimulationAction.PAUSE
)

/**
 * Root reducer of the application. Uses all the other reducers.
 * @param state the current state of the application.
 * @param action the action to perform.
 * @param <TS> the type of concentration surrogate.
 * @param <PS> the type of position surrogate.
 * @return the new state of the application.
 */
fun <TS, PS : PositionSurrogate> rootReducer(state: AppState<TS, PS>, action: Any): AppState<TS, PS> = AppState(
    environmentSurrogate = environmentSurrogateReducer(state.environmentSurrogate, action),
    renderMode = renderModeReducer(state.renderMode, action),
    playButton = playButtonReducer(state.playButton, action)
)
