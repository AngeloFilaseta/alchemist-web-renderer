package it.unibo.alchemist.model

/**
 * Actions that can be performed on a simulation.
 */
enum class SimulationAction {

    /**
     * The action used to start the Simulation.
     */
    PLAY,

    /**
     * The action used to pause the Simulation.
     */
    PAUSE;
    companion object {
        private const val path: String = "/action"

        /**
         * Route used if the client will execute the render computation.
         */
        const val playPath: String = "$path/play"

        /**
         * Route used if the server will execute the render computation.
         */
        const val pausePath: String = "$path/pause"
    }
}
