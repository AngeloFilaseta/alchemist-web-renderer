package react

import org.reduxkotlin.Store
import org.reduxkotlin.createStore
import react.components.AppContent
import react.components.AppNavbar
import state.AppState
import state.rootReducer

/**
 * The application store. The object that brings reducers and actions together.
 */
val store: Store<AppState> = createStore(::rootReducer, AppState())

/**
 * The App to render.
 */
val App: FC<Props> = FC {
    AppNavbar()
    AppContent()
}
