package react.api
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import it.unibo.alchemist.model.SimulationAction
import react.api.utility.JsonClient.client
import react.api.utility.JsonClient.endpoint

/**
 * API to interact with the simulation using the Play Button.
 */
object PlayButtonApi {

    /**
     * Play the simulation.
     */
    suspend fun playSimulation(): HttpResponse {
        return actOnSimulation(SimulationAction.playPath)
    }

    /**
     * Pause the simulation.
     */
    suspend fun pauseSimulation(): HttpResponse {
        return actOnSimulation(SimulationAction.pausePath)
    }

    /**
     * Send a get request to the server to perform an action on the simulation.
     * @param path the path of the action to perform.
     */
    private suspend fun actOnSimulation(path: String): HttpResponse {
        return client.get(endpoint + path)
    }
}
