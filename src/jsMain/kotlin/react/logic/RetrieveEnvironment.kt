package react.logic

import io.ktor.client.statement.HttpResponse
import it.unibo.alchemist.model.RenderMode
import kotlinx.browser.window
import react.api.EnvironmentApi

/**
 * The recommended number of core to use for the Auto mode.
 * This is just a sample.
 */
private const val MIN_HW_CONCURRENCY: Int = 4

/**
 * Retrieve the environment of the simulation using the correct approach.
 * @param renderMode the render mode set by the user.
 * @param autoStrategy the strategy to use is Auto mode is selected.
 */
suspend fun retrieveEnvironment(renderMode: RenderMode, autoStrategy: () -> RenderMode): HttpResponse =
    when (renderMode) {
        RenderMode.CLIENT -> EnvironmentApi.getEnvironmentClient()
        RenderMode.SERVER -> EnvironmentApi.getEnvironmentServer()
        RenderMode.AUTO -> {
            retrieveEnvironment(autoStrategy()) {
                throw IllegalStateException("Only client or Server mode allowed here.")
            }
        }
    }

/**
 * Return the render mode to use based on the hardware capacity of the client.
 */
val hwAutoStrategy: () -> RenderMode = {
    if (window.navigator.hardwareConcurrency.toInt() > MIN_HW_CONCURRENCY) {
        RenderMode.CLIENT
    } else {
        RenderMode.SERVER
    }
}
