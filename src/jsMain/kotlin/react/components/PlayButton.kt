package react.components

import it.unibo.alchemist.model.SimulationAction
import react.FC
import react.Props
import react.adapters.reactBootstrap.buttons.Button
import react.store
import react.useState
import state.actions.SetPlayButton

/**
 * Play Button component. Used to start and pause the simulation.
 */
val PlayButton: FC<Props> = FC {
    var playButtonIsPause: Boolean by useState(store.state.playButton == SimulationAction.PAUSE)

    store.subscribe {
        playButtonIsPause = store.state.playButton == SimulationAction.PAUSE
    }

    Button {
        variant = if (playButtonIsPause) "success" else "danger"
        onClick = {
            if (playButtonIsPause) {
                store.dispatch(SetPlayButton(SimulationAction.PLAY))
                console.log(store.state.playButton)
            } else {
                store.dispatch(SetPlayButton(SimulationAction.PAUSE))
                console.log(store.state.playButton)
            }
        }
        +if (playButtonIsPause) "Play" else "Pause"
    }
}
