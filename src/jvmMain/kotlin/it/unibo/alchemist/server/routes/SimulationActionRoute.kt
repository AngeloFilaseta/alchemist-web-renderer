package it.unibo.alchemist.server.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.util.pipeline.PipelineContext
import it.unibo.alchemist.core.interfaces.Simulation
import it.unibo.alchemist.core.interfaces.Status
import it.unibo.alchemist.common.model.SimulationAction
import it.unibo.alchemist.server.state.ServerStore

/**
 * Logic of the Routes in the /action path.
 */
object SimulationActionRoute {

    /**
     * Route to play the simulation.
     */
    fun Route.simulationActionPlay() {
        get(SimulationAction.playPath) {
            simulationActionStep(
                {
                    it.play()
                },
                Pair(Status.RUNNING, "The Simulation is already running.")
            )
        }
    }

    /**
     * Route to pause the simulation.
     */
    fun Route.simulationActionPause() {
        get(SimulationAction.pausePath) {
            simulationActionStep(
                {
                    it.pause()
                },
                Pair(Status.PAUSED, "The Simulation is already paused.")
            )
        }
    }

    private suspend fun PipelineContext<Unit, ApplicationCall>.simulationActionStep(
        action: (Simulation<Any, Nothing>) -> Unit,
        additionalCheck: Pair<Status, String>
    ) {
        ServerStore.store.state.simulation?.let {
            when (it.status) {
                Status.INIT -> call.respond(
                    HttpStatusCode.Conflict,
                    "The Simulation is being initialized and can't be started."
                )

                Status.TERMINATED -> call.respond(
                    HttpStatusCode.Conflict,
                    "The Simulation is terminated."
                )

                additionalCheck.first -> call.respond(
                    HttpStatusCode.Conflict,
                    additionalCheck.second
                )
                else -> {
                    action(it)
                    call.respond(HttpStatusCode.OK)
                }
            }
        } ?: call.respond(HttpStatusCode.InternalServerError, "No Environment found on the server.")
    }
}
