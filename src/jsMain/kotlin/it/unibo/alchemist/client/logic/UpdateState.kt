@file:Suppress("UNCHECKED_CAST")

package it.unibo.alchemist.client.logic

import it.unibo.alchemist.common.model.RenderMode
import it.unibo.alchemist.common.model.surrogate.EnvironmentSurrogate
import it.unibo.alchemist.common.model.surrogate.PositionSurrogate
import it.unibo.alchemist.common.model.surrogate.concentrations.sapere.ILsaMoleculeSurrogate
import it.unibo.alchemist.common.state.actions.SetEnvironmentSurrogate
import kotlinx.browser.window
import it.unibo.alchemist.client.api.EnvironmentApi
import it.unibo.alchemist.client.state.AppStore.store

/**
 * The recommended number of core to use for the Auto mode.
 * This is just a sample.
 */
private const val MIN_HW_CONCURRENCY: Int = 4

/**
 * Update the application state.
 * @param renderMode the render mode set by the user.
 * @param autoStrategy the strategy to use is Auto mode is selected.
 */
suspend fun updateState(renderMode: RenderMode, autoStrategy: () -> RenderMode) {
    when (renderMode) {
        RenderMode.CLIENT -> {
            val env: EnvironmentSurrogate<List<ILsaMoleculeSurrogate>, PositionSurrogate> =
                EnvironmentApi.getEnvironmentClient()
            store.dispatch(SetEnvironmentSurrogate(env as EnvironmentSurrogate<Any, Nothing>))
        }
        RenderMode.SERVER -> {
            TODO()
        }
        RenderMode.AUTO -> {
            updateState(autoStrategy()) {
                throw IllegalStateException("Only client or Server mode allowed here.")
            }
        }
    }
}

/**
 * @return the render mode to use based on the hardware capacity of the client.
 */
val hwAutoStrategy: () -> RenderMode = {
    if (window.navigator.hardwareConcurrency.toInt() > MIN_HW_CONCURRENCY) {
        RenderMode.CLIENT
    } else {
        RenderMode.SERVER
    }
}
