package it.unibo.alchemist.server.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import it.unibo.alchemist.core.interfaces.Status
import it.unibo.alchemist.model.SimulationAction
import it.unibo.alchemist.server.state.ServerStore

/**
 * Route to play the simulation.
 */
fun Route.simulationActionPlay() {
    get(SimulationAction.playPath) {
        ServerStore.store.state.environment?.let {
            when (it.simulation.status) {
                Status.INIT -> call.respond(
                    HttpStatusCode.Conflict,
                    "The Simulation is being initialized and can't be started."
                )
                Status.RUNNING -> call.respond(
                    HttpStatusCode.Conflict,
                    "The Simulation is already running."
                )
                Status.TERMINATED -> call.respond(
                    HttpStatusCode.Conflict,
                    "The Simulation is terminated."
                )
                else -> {
                    it.simulation.play()
                    call.respond(HttpStatusCode.OK)
                }
            }
        } ?: call.respond(HttpStatusCode.InternalServerError)
    }
}

/**
 * Route to pause the simulation.
 */
fun Route.simulationActionPause() {
    get(SimulationAction.pausePath) {
        ServerStore.store.state.environment?.let {
            when (it.simulation.status) {
                Status.INIT -> call.respond(
                    HttpStatusCode.Conflict,
                    "The Simulation is being initialized and can't be started."
                )
                Status.PAUSED -> call.respond(
                    HttpStatusCode.Conflict,
                    "The Simulation is already in pause."
                )
                Status.TERMINATED -> call.respond(
                    HttpStatusCode.Conflict,
                    "The Simulation is terminated."
                )
                else -> {
                    it.simulation.pause()
                    call.respond(HttpStatusCode.OK)
                }
            }
        } ?: call.respond(HttpStatusCode.InternalServerError)
    }
}
