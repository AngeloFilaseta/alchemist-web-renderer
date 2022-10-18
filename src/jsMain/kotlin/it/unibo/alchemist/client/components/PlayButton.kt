package it.unibo.alchemist.client.components

import io.ktor.http.HttpStatusCode
import io.ktor.util.InternalAPI
import io.ktor.utils.io.readUTF8Line
import it.unibo.alchemist.common.model.SimulationAction
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import react.FC
import react.Props
import it.unibo.alchemist.client.adapters.reactBootstrap.buttons.Button
import it.unibo.alchemist.client.api.PlayButtonApi.pauseSimulation
import it.unibo.alchemist.client.api.PlayButtonApi.playSimulation
import react.useState
import it.unibo.alchemist.client.state.ClientStore.store
import it.unibo.alchemist.client.state.actions.SetPlayButton

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
