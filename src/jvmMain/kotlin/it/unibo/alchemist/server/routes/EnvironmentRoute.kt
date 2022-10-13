package it.unibo.alchemist.server.routes

import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import it.unibo.alchemist.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.model.surrogate.Position2DSurrogate
import it.unibo.alchemist.model.surrogate.concentrations.sapere.ILsaMoleculeSurrogate
import it.unibo.alchemist.server.state.ServerStore.store
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

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
            call.respond(serialize(store.state.environmentSurrogate))
        }
    }

    /**
     * Route to get the current environment. The server will send the environment to the client in a serialized form.
     */
    fun Route.environmentClientMode() {
        get(EnvironmentSurrogate.clientModePath) {
            call.respond(serialize(store.state.environmentSurrogate))
        }
    }
}

private fun serialize(environmentSurrogate: EnvironmentSurrogate<Any, Nothing>): String {
    if (store.state.incarnation == "sapere") {
        @Suppress("UNCHECKED_CAST")
        val env = store.state.environmentSurrogate
            as EnvironmentSurrogate<List<ILsaMoleculeSurrogate>, Position2DSurrogate>
        return Json.encodeToString(env)
    } else {
        error(
            """
            $environmentSurrogate can't be serialized,
            as incarnation '${store.state.incarnation}' in not recognized.
            """
        )
    }
}
