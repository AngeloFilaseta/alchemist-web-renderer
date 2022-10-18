@file:JsModule("react-bootstrap/ToggleButtonGroup")
@file:JsNonModule

package it.unibo.alchemist.client.adapters.reactBootstrap.buttons

import react.ComponentClass
import react.Props

/**
 * React Bootstrap ToggleButtonGroup adapter
 * @see <a href="https://react-bootstrap.github.io/components/buttons/">
 *     react-bootstrap - buttons</a>
 */

@JsName("default")
external val ToggleButtonGroup: ComponentClass<ToggleButtonGroupProps>

/**
 * Props used to customize the ToggleButtonGroup.
 */
external interface ToggleButtonGroupProps : Props {
    /**
     * type prop, 'checkbox' | 'radio'
     */
    var type: String

    /**
     * size prop to choose buttons size, 'sm' | 'lg'
     */
    var size: String

    /**
     * name prop.
     */
    var name: String

    /**
     * onChange prop, callback function
     */
    var onChange: (Any) -> Unit

    /**
     * defaultValue prop
     */
    var defaultValue: Any
}
