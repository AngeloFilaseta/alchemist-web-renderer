@file:JsModule("react-bootstrap/Navbar")
@file:JsNonModule

package react.adapters.reactBootstrap.navbar

import react.ComponentClass
import react.Props

/**
 * React Bootstrap Navbar adapter
 * @see <a href="https://react-bootstrap.github.io/components/navbar/">react-bootstrap - navbar</a>
 */
@JsName("default")
external val Navbar: ComponentClass<NavbarProps>

/**
 * Props used to customize the Navbar.
 */
external interface NavbarProps : Props {
    /**
     * bg props.
     */
    var bg: String

    /**
     * variant props.
     */
    var variant: String
}
