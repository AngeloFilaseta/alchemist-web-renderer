package it.unibo.alchemist.server.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import it.unibo.alchemist.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.server.state.ServerStore

/**
 * Logic of the Routes in the /environment path.
 */
object EnvironmentRoute {

    /**
     * Route to get the current environment. The server will render the environment and send it to the client.
     */
    fun Route.environmentServerMode() {
        get(EnvironmentSurrogate.serverModePath) {
            ServerStore.store.state.environment?.let {
                call.respond(it.toString()) // TODO
            } ?: call.respond(HttpStatusCode.InternalServerError)
        }
    }

    /**
     * Route to get the current environment. The server will send the environment to the client in a serialized form.
     */
    fun Route.environmentClientMode() {
        get(EnvironmentSurrogate.clientModePath) {
            ServerStore.store.state.environment?.let {
                call.respond(it.toString()) // TODO
            } ?: call.respond(HttpStatusCode.InternalServerError)
        }
    }
}
