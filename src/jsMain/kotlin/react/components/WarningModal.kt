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
                +props.title
            }
        }
        ModalBody {
            +props.message
        }
    }
}

/**
 * Props used to customize the WarningModal.
 */
external interface WarningModalProps : ModalProps {
    /**
     * Title of the modal.
     */
    var title: String

    /**
     * Message to show in the modal.
     */
    var message: String
}
