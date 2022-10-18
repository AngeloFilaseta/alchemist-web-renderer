package it.unibo.alchemist.server.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.util.pipeline.PipelineContext
import it.unibo.alchemist.common.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.common.model.surrogate.Position2DSurrogate
import it.unibo.alchemist.common.model.surrogate.concentrations.sapere.ILsaMoleculeSurrogate
import it.unibo.alchemist.server.state.ServerStore.store

/**
 * Logic of the Routes in the /environment path.
 */
object EnvironmentRoute {

    /**
     * Route to get the current environment. The server will render the environment and send it to the client.
     */
    fun Route.environmentServerMode() {
        get(EnvironmentSurrogate.serverModePath) {
            // TODO add effective logic here
            sendSerializedEnvironment()
        }
    }

    /**
     * Route to get the current environment. The server will send the environment to the client in a serialized form.
     */
    fun Route.environmentClientMode() {
        get(EnvironmentSurrogate.clientModePath) {
            sendSerializedEnvironment()
        }
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.sendSerializedEnvironment() {
    if (store.state.incarnation == "sapere") {
        @Suppress("UNCHECKED_CAST")
        val env = store.state.environmentSurrogate
            as EnvironmentSurrogate<List<ILsaMoleculeSurrogate>, Position2DSurrogate>
        call.respond(env)
    } else {
        call.respond(
            HttpStatusCode.InternalServerError,
            "Serialization is not available for incarnation '${store.state.incarnation}'."
        )
    }
}
