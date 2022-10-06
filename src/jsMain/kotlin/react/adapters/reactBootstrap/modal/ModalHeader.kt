@file:JsModule("react-bootstrap/ModalHeader")
@file:JsNonModule

package react.adapters.reactBootstrap.modal

import react.ComponentClass
import react.Props

/**
 * React Bootstrap ModalHeader adapter
 * @see <a href="https://react-bootstrap.github.io/components/modal">
 *     react-bootstrap - modal</a>
 */

@JsName("default")
external val ModalHeader: ComponentClass<ModalHeaderProps>

/**
 * Props used to customize the ModalHeader.
 */
external interface ModalHeaderProps : Props {
    /**
     * closeButton prop
     */
    var closeButton: Boolean?
}
