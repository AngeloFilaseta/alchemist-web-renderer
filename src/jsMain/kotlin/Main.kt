import kotlinx.browser.document
import react.App
import react.create
import react.dom.client.createRoot

/**
 * The entry point of the Kotlin/JS application. Find the root element and render the App.
 */
fun main() {
    val container = document.getElementById("root") ?: error("Couldn't find container!")
    createRoot(container).render(App.create())
}
