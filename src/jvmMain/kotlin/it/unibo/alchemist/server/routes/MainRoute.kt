package it.unibo.alchemist.server.routes

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.mainRoute() {
    get("/") {
        this::class.java.classLoader.getResource("index.html")?.let {
            call.respondText(it.readText(), ContentType.Text.Html)
        } ?: call.respond(HttpStatusCode.NotFound)
    }
}
