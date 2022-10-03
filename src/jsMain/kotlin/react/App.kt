package react

import react.adapters.reactBootstrap.navbar.Navbar
import react.adapters.reactBootstrap.navbar.NavbarBrand

/**
 * The App to render.
 */
val App: FC<Props> = FC {
    Navbar {
        bg = "dark"
        variant = "dark"
        NavbarBrand {
            +"Alchemist Web Renderer"
        }
    }
}
