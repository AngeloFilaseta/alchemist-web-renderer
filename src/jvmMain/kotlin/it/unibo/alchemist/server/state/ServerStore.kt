package it.unibo.alchemist.server.state

import it.unibo.alchemist.model.surrogate.EnvironmentSurrogate
import org.reduxkotlin.Store
import org.reduxkotlin.createThreadSafeStore

/**
 * The store of the application. It is stored using a singleton pattern.
 */
object ServerStore {
    /**
     * The redux store of the server.
     */
    val store: Store<ServerState<Any, Nothing, Any, Nothing>> = createThreadSafeStore(
        ::rootReducer,
        ServerState("", null, EnvironmentSurrogate(-1, listOf()))
    )
}
