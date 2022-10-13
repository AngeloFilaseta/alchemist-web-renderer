package react.api.utility

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.browser.window

/**
 * Client used to make API call to the server.
 */
object JsonClient {

    /**
     * The endpoint of the server. Used by the client to make API calls.
     */
    val endpoint: String = window.location.origin

    /**
     * Http client that will make the API call.
     */
    val client: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }
}
