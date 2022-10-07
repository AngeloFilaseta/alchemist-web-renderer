package react.api

import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import it.unibo.alchemist.model.EnvironmentSurrogate
import react.api.utility.JsonClient.client
import react.api.utility.JsonClient.endpoint

/**
 * API to retrieve the Environment of the simulation.
 */
object EnvironmentApi {

    /**
     * Get the environment of the simulation in a serialized form. The client will use this to render the environment.
     */
    suspend fun getEnvironmentClient(): HttpResponse {
        return getEnvironment(EnvironmentSurrogate.clientModePath)
    }

    /**
     * Get the environment of the simulation, already rendered by the server.
     */
    suspend fun getEnvironmentServer(): HttpResponse {
        return getEnvironment(EnvironmentSurrogate.serverModePath)
    }

    private suspend fun getEnvironment(path: String): HttpResponse {
        return client.get(endpoint + path)
    }
}
