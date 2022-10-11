package it.unibo.alchemist.server.modules

import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import it.unibo.alchemist.server.routes.EnvironmentRoute.environmentClientMode
import it.unibo.alchemist.server.routes.EnvironmentRoute.environmentServerMode
import it.unibo.alchemist.server.routes.SimulationActionRoute.simulationActionPause
import it.unibo.alchemist.server.routes.SimulationActionRoute.simulationActionPlay
import it.unibo.alchemist.server.routes.mainRoute

/**
 * Module to add all the routing configuration of the application.
 */
fun Application.routingModule() {
    routing {
        mainRoute()

        simulationActionPlay()

        simulationActionPause()

        environmentServerMode()

        environmentClientMode()
    }
}
