package it.unibo.alchemist.client.components

import it.unibo.alchemist.common.model.RenderMode
import react.FC
import react.Props
import it.unibo.alchemist.client.adapters.reactBootstrap.buttons.ToggleButton
import it.unibo.alchemist.client.adapters.reactBootstrap.buttons.ToggleButtonGroup
import it.unibo.alchemist.client.state.ClientStore.store
import it.unibo.alchemist.client.state.actions.SetRenderMode

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
