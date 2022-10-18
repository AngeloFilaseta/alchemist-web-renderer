@file:JsModule("react-bootstrap/ModalTitle")
@file:JsNonModule

package it.unibo.alchemist.react.adapters.reactBootstrap.modal

import react.ComponentClass
import react.Props

/**
 * React Bootstrap ModalTitle adapter
 * @see <a href="https://react-bootstrap.github.io/components/modal">
 *     react-bootstrap - modal</a>
 */

@JsName("default")
external val ModalTitle: ComponentClass<ModalTitleProps>

/**
 * Props used to customize the ModalHeader.
 */
external interface ModalTitleProps : Props {
    /**
     * className prop
     */
    var className: String
}
