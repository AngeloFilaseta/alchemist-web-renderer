@file:JsModule("react-bootstrap/ToggleButton")
@file:JsNonModule

package it.unibo.alchemist.client.adapters.reactBootstrap.buttons

import react.ComponentClass
import react.Props

/**
 * React Bootstrap ToggleButton adapter
 * @see <a href="https://react-bootstrap.github.io/components/buttons/">
 *     react-bootstrap - buttons</a>
 */

@JsName("default")
external val ToggleButton: ComponentClass<ToggleButtonProps>

/**
 * Props used to customize the ToggleButton.
 */
external interface ToggleButtonProps : Props {

    /**
     * id props, required.
     */
    var id: String

    /**
     * value props.
     */
    var value: Any
}
