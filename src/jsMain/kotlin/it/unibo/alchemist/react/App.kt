package it.unibo.alchemist.react

import it.unibo.alchemist.react.components.AppContent
import it.unibo.alchemist.react.components.AppNavbar
import react.FC
import react.Props

/**
 * The App to render.
 */
val App: FC<Props> = FC {
    AppNavbar()
    AppContent()
}
