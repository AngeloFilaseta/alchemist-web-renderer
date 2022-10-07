package react.components

import io.ktor.http.HttpStatusCode
import io.ktor.util.InternalAPI
import io.ktor.utils.io.readUTF8Line
import it.unibo.alchemist.model.SimulationAction
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import react.FC
import react.Props
import react.adapters.reactBootstrap.buttons.Button
import react.api.PlayButtonApi.pauseSimulation
import react.api.PlayButtonApi.playSimulation
import react.store
import react.useState
import state.actions.SetPlayButton

private val scope = MainScope()

/**
 * Play Button component. Used to start and pause the simulation.
 */
@OptIn(InternalAPI::class) // TODO remove in the future, used for testing because of httpResponse.content
val PlayButton: FC<Props> = FC {

    var playButtonIsPause: Boolean by useState(store.state.playButton == SimulationAction.PAUSE)
    var showWarningModal: Boolean by useState(false)
    var warningModalContent: Pair<String, String> by useState { Pair("", "") }

    store.subscribe {
        playButtonIsPause = store.state.playButton == SimulationAction.PAUSE
    }

    Button {
        variant = if (playButtonIsPause) "success" else "danger"
        onClick = {
            scope.launch {
                val response = if (playButtonIsPause) playSimulation() else pauseSimulation()
                if (response.status == HttpStatusCode.OK) {
                    store.dispatch(
                        SetPlayButton(if (playButtonIsPause) SimulationAction.PLAY else SimulationAction.PAUSE)
                    )
                } else {
                    warningModalContent = Pair(
                        "Error ${response.status}",
                        response.content.readUTF8Line() ?: "Unknown error"
                    )
                    showWarningModal = true
                }
            }
        }
        +if (playButtonIsPause) "Play" else "Pause"
    }

    WarningModal {
        show = showWarningModal
        onHide = { showWarningModal = false }
        content = warningModalContent
    }
}
