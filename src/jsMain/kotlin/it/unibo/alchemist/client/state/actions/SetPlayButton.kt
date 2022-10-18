package it.unibo.alchemist.client.state.actions

import it.unibo.alchemist.model.SimulationAction

/**
 * Redux action to set the Simulation state of the application and switch between Play and pause.
 * @param simulationAction the new simulation action to set.
 */
data class SetPlayButton(val simulationAction: SimulationAction)
