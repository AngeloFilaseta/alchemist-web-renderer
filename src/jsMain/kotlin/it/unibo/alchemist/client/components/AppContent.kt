package it.unibo.alchemist.client.components

import it.unibo.alchemist.common.model.SimulationAction
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.js.timers.setInterval
import react.FC
import react.Props
import react.dom.html.ReactHTML.p
import it.unibo.alchemist.client.logic.hwAutoStrategy
import it.unibo.alchemist.client.logic.updateState
import react.useState
import it.unibo.alchemist.client.state.AppStore.store
import kotlin.time.Duration

private val scope = MainScope()

/**
 * The application main content section.
 */
val AppContent: FC<Props> = FC {

    var environment: String by useState(store.state.environmentSurrogate.toString())

    store.subscribe {
        environment = store.state.environmentSurrogate.toString()
    }

    suspend fun updateState() {
        updateState(store.state.renderMode, hwAutoStrategy)
    }

    setInterval(Duration.parse("3s")) {
        if (store.state.playButton == SimulationAction.PLAY) {
            scope.launch {
                updateState()
            }
        }
    }

    p {
        +environment
    }
}
