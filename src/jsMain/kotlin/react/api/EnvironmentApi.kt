package react.api

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import it.unibo.alchemist.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.model.surrogate.PositionSurrogate
import react.api.utility.JsonClient.client
import react.api.utility.JsonClient.endpoint

/**
 * API to retrieve the Environment of the simulation.
 */
object EnvironmentApi {

    /**
     * Get the environment of the simulation in a serialized form.
     * The client will use this to render the environment.
     * @param <TS> the type of concentration surrogate.
     * @param <PS> the type of position surrogate.
     * @return the environment surrogate that the server sent.
     */
    suspend inline fun <reified TS, reified PS> getEnvironmentClient(): EnvironmentSurrogate<TS, PS>
    where PS : PositionSurrogate {
        return client.get(endpoint + EnvironmentSurrogate.serverModePath).body()
    }

    /**
     * Get the environment of the simulation, already rendered by the server.
     * TODO this method needs a proper implementation.
     */
    suspend fun getEnvironmentServer(): HttpResponse {
        return client.get(endpoint + EnvironmentSurrogate.clientModePath)
    }
}
