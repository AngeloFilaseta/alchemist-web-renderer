package react.components

import react.FC
import react.Props
import react.adapters.reactBootstrap.buttons.ToggleButton
import react.adapters.reactBootstrap.buttons.ToggleButtonGroup
import react.adapters.reactBootstrap.navbar.Navbar
import react.adapters.reactBootstrap.navbar.NavbarBrand

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
                console.log("onChange: $value")
            }
            defaultValue = "auto"
            ToggleButton {
                id = "client-button"
                value = "client"
                +"Client"
            }
            ToggleButton {
                id = "auto-button"
                value = "auto"
                +"Auto"
            }
            ToggleButton {
                id = "server-button"
                value = "server"
                +"Server"
            }
        }
    }
}
