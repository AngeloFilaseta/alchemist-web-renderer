@file:JsModule("react-bootstrap/Button")
@file:JsNonModule

package react.adapters.reactBootstrap.buttons

import react.ComponentClass
import react.Props

/**
 * React Bootstrap Button adapter
 * @see <a href="https://react-bootstrap.github.io/components/buttons/">
 *     react-bootstrap - buttons</a>
 */

@JsName("default")
external val Button: ComponentClass<ButtonProps>

/**
 * Props used to customize the Button.
 */
external interface ButtonProps : Props {

    /**
     * active prop, false by default.
     */
    var active: Boolean?

    /**
     * disable prop, false by default.
     */
    var disabled: Boolean?

    /**
     * variant prop, 'primary' by default.
     */
    var variant: String

    /**
     * onClick prop
     */
    var onClick: () -> Unit
}
