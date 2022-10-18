@file:JsModule("react-bootstrap/Modal")
@file:JsNonModule

package it.unibo.alchemist.client.adapters.reactBootstrap.modal

import react.ComponentClass
import react.Props

/**
 * React Bootstrap Modal adapter
 * @see <a href="https://react-bootstrap.github.io/components/modal">
 *     react-bootstrap - modal</a>
 */

@JsName("default")
external val Modal: ComponentClass<ModalProps>

/**
 * Props used to customize the Modal.
 */
external interface ModalProps : Props {
    /**
     * show prop, false by default.
     */
    var show: Boolean?

    /**
     * onHide prop
     */
    var onHide: () -> Unit
}
