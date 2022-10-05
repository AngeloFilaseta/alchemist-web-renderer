package it.unibo.alchemist.server

import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import it.unibo.alchemist.server.modules.installModule
import it.unibo.alchemist.server.modules.routingModule

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
            installModule()
            routingModule()
        }.start(wait = true)
    }
}
