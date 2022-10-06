package react.components

import it.unibo.alchemist.model.RenderMode
import react.FC
import react.Props
import react.adapters.reactBootstrap.buttons.ToggleButton
import react.adapters.reactBootstrap.buttons.ToggleButtonGroup
import react.store
import state.actions.SetRenderMode

/**
 * The button group that let the user decide which render mode to use.
 */
val RenderModeButtons: FC<Props> = FC {
    ToggleButtonGroup {
        name = "toggle-render-mode"
        onChange = { value ->
            store.dispatch(SetRenderMode(value as RenderMode))
        }
        defaultValue = RenderMode.valueOf("AUTO")
        ToggleButton {
            id = "client-button"
            value = RenderMode.valueOf("CLIENT")
            +"Client"
        }
        ToggleButton {
            id = "auto-button"
            value = RenderMode.valueOf("AUTO")
            +"Auto"
        }
        ToggleButton {
            id = "server-button"
            value = RenderMode.valueOf("SERVER")
            +"Server"
        }
    }
}
