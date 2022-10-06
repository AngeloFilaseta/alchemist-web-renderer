package react.api.utility

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.browser.window

/**
 * Client used to make API call to the server.
 */
object JsonClient {

    val endpoint = window.location.origin

    /**
     * Http client that will make the API call.
     */
    val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }
}
