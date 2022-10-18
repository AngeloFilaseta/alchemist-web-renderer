package it.unibo.alchemist.client.components

import react.FC
import it.unibo.alchemist.client.adapters.reactBootstrap.modal.Modal
import it.unibo.alchemist.client.adapters.reactBootstrap.modal.ModalBody
import it.unibo.alchemist.client.adapters.reactBootstrap.modal.ModalHeader
import it.unibo.alchemist.client.adapters.reactBootstrap.modal.ModalProps
import it.unibo.alchemist.client.adapters.reactBootstrap.modal.ModalTitle

/**
 * Modal used to show information about something that didn't work as expected.
 */
val WarningModal: FC<WarningModalProps> = FC { props ->
    Modal {
        show = props.show
        onHide = props.onHide
        ModalHeader {
            closeButton = true
            ModalTitle {
                className = "text-danger"
                +props.content.first
            }
        }
        ModalBody {
            +props.content.second
        }
    }
}

/**
 * Props used to customize the WarningModal.
 */
external interface WarningModalProps : ModalProps {
    /**
     * Content of the modal. The first line is used as the title, the rest as the message.
     */
    var content: Pair<String, String>
}