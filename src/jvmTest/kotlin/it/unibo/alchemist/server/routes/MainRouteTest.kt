package it.unibo.alchemist.server.routes

import io.kotest.matchers.shouldBe
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.ApplicationTestBuilder

suspend fun ApplicationTestBuilder.mainRouteTest() {
    val response = client.get("/")
    response.status shouldBe HttpStatusCode.OK
    response.bodyAsText() shouldBe this::class.java.classLoader.getResource("index.html")?.readText()
}
