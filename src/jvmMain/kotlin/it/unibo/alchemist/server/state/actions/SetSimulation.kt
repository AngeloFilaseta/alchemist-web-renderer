package it.unibo.alchemist.server.state.actions

import it.unibo.alchemist.core.interfaces.Simulation

/**
 * Redux action to set the [it.unibo.alchemist.core.interfaces.Simulation] of the application.
 * @param simulation the new [it.unibo.alchemist.core.interfaces.Simulation].
 */
data class SetSimulation(val simulation: Simulation<Any, Nothing>?)
