package it.unibo.alchemist.client

import it.unibo.alchemist.client.components.AppContent
import it.unibo.alchemist.client.components.AppNavbar
import kotlinx.browser.document
import react.FC
import react.Props
import react.create
import react.dom.client.createRoot

/**
 * The entry point of the Kotlin/JS application. Find the root element and render the App.
 */
fun main() {
    val container = document.getElementById("root") ?: error("Couldn't find container!")
    createRoot(container).render(App.create())
}

/**
 * The App to render.
 */
val App: FC<Props> = FC {
    AppNavbar()
    AppContent()
}
