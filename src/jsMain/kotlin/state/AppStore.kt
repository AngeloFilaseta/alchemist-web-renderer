package state

import org.reduxkotlin.Store
import org.reduxkotlin.createStore

/**
 * The application store. The object that brings reducers and actions together.
 */
object AppStore {

    /**
     * The redux store of the application.
     */
    val store: Store<AppState> = createStore(::rootReducer, AppState())
}
