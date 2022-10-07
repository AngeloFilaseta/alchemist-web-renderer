package it.unibo.alchemist.server.modules

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import it.unibo.alchemist.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.server.routes.SimulationActionRoute.simulationActionPause
import it.unibo.alchemist.server.routes.SimulationActionRoute.simulationActionPlay
import it.unibo.alchemist.server.routes.mainRoute
import it.unibo.alchemist.server.state.ServerStore

/**
 * Module to add all the routing configuration of the application.
 */
fun Application.routingModule() {
    routing {
        mainRoute()

        simulationActionPlay()

        simulationActionPause()

        get(EnvironmentSurrogate.serverModePath) {
            ServerStore.store.state.environment?.let {
                call.respond(it.toString()) // TODO
            } ?: call.respond(HttpStatusCode.InternalServerError)
        }

        get(EnvironmentSurrogate.clientModePath) {
            ServerStore.store.state.environment?.let {
                call.respond(it.toString()) // TODO
            } ?: call.respond(HttpStatusCode.InternalServerError)
        }
    }
}
