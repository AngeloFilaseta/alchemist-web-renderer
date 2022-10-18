package it.unibo.alchemist.client.components

import react.FC
import react.Props
import it.unibo.alchemist.client.adapters.reactBootstrap.navbar.Navbar
import it.unibo.alchemist.client.adapters.reactBootstrap.navbar.NavbarBrand

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
