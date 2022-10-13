package react.components

import io.ktor.util.InternalAPI
import io.ktor.utils.io.readUTF8Line
import it.unibo.alchemist.model.SimulationAction
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.js.timers.setInterval
import react.FC
import react.Props
import react.dom.html.ReactHTML.p
import react.logic.hwAutoStrategy
import react.logic.retrieveEnvironment
import react.useState
import state.AppStore.store
import kotlin.time.Duration

private val scope = MainScope()

/**
 * The application main content section.
 */
@OptIn(InternalAPI::class) // TODO remove in the future, used for testing because of httpResponse.content
val AppContent: FC<Props> = FC {
    var environment: String by useState("")

    suspend fun setEnvironment() {
        val httpResponse = retrieveEnvironment(store.state.renderMode, hwAutoStrategy)
        environment = "[${httpResponse.status}] ${httpResponse.content.readUTF8Line()}"
    }

    setInterval(Duration.parse("3s")) {
        if (store.state.playButton == SimulationAction.PLAY) {
            scope.launch {
                setEnvironment()
            }
        }
    }

    p {
        +environment
    }
}
