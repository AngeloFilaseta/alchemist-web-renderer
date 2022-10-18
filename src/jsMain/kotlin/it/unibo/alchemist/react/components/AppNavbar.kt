package it.unibo.alchemist.react.components

import react.FC
import react.Props
import it.unibo.alchemist.react.adapters.reactBootstrap.navbar.Navbar
import it.unibo.alchemist.react.adapters.reactBootstrap.navbar.NavbarBrand

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
