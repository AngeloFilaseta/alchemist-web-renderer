package it.unibo.alchemist.server

import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.http.content.resources
import io.ktor.server.http.content.static
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.compression.Compression
import io.ktor.server.plugins.compression.gzip
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.cors.routing.CORS
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * A Server implementation that offers API to access the Environment of the Simulation.
 */
object Server {

    private const val PORT = 9090

    /**
     * Configure the server and start it.
     */
    fun start() {
        embeddedServer(Netty, PORT) {
            install(ContentNegotiation) {
                json()
            }
            install(CORS) {
                allowMethod(HttpMethod.Get)
                allowMethod(HttpMethod.Post)
                anyHost()
            }
            install(Compression) {
                gzip()
            }

            routing {
                get("/") {
                    this::class.java.classLoader.getResource("index.html")?.let {
                        call.respondText(it.readText(), ContentType.Text.Html)
                    } ?: call.respond(HttpStatusCode.NotFound)
                }

                static("/") {
                    resources("")
                }
            }
        }.start(wait = true)
    }
}
