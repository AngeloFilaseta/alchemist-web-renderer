package react.components

import react.FC
import react.adapters.reactBootstrap.modal.Modal
import react.adapters.reactBootstrap.modal.ModalBody
import react.adapters.reactBootstrap.modal.ModalHeader
import react.adapters.reactBootstrap.modal.ModalProps
import react.adapters.reactBootstrap.modal.ModalTitle

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
