package it.unibo.alchemist.server.state.actions

import it.unibo.alchemist.model.interfaces.Environment
import it.unibo.alchemist.model.interfaces.Position

/**
 * Redux action to set the Environment of the application.
 * @param environment the new environment.
 */
data class SetEnvironment<T, P : Position<out P>>(val environment: Environment<T, P>?)
