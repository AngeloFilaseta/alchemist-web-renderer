package it.unibo.alchemist.common.state.actions

/**
 * Redux action to set the incarnation used by the simulation.
 * @param incarnation the new incarnation.
 */
data class SetIncarnation(val incarnation: String)
