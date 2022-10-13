package react

import react.components.AppContent
import react.components.AppNavbar

/**
 * The App to render.
 */
val App: FC<Props> = FC {
    AppNavbar()
    AppContent()
}
