package react.components

import react.FC
import react.Props
import react.adapters.reactBootstrap.navbar.Navbar
import react.adapters.reactBootstrap.navbar.NavbarBrand

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
        RenderModeButtons()
        PlayButton()
    }
}
