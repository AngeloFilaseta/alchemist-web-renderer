package react.components

import react.FC
import react.Props
import react.adapters.reactBootstrap.buttons.ToggleButton
import react.adapters.reactBootstrap.buttons.ToggleButtonGroup
import react.adapters.reactBootstrap.navbar.Navbar
import react.adapters.reactBootstrap.navbar.NavbarBrand
import react.store
import state.actions.RenderMode
import state.actions.SetRenderMode

/**
 * The application navbar.
 */
val AppNavbar: FC<Props> = FC {
    Navbar {
        bg = "dark"
        variant = "dark"
        NavbarBrand {
            +"Alchemist Web Renderer"
        }

        ToggleButtonGroup {
            name = "toggle-render-mode"
            onChange = { value ->
                store.dispatch(SetRenderMode(value as RenderMode))
            }
            defaultValue = "auto"
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
}
