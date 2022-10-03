package react

import react.dom.html.ReactHTML.p

/**
 * The App to render.
 */
val App: FC<Props> = FC {
    p {
        +"Hello World!"
    }
}
