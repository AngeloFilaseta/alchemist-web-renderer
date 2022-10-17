package it.unibo.alchemist.server.state

import org.reduxkotlin.Store
import org.reduxkotlin.createThreadSafeStore

/**
 * The store of the application. It is stored using a singleton pattern.
 */
object ServerStore {
    /**
     * The redux store of the server.
     */
    val store: Store<ServerState<Any, Nothing>> = createThreadSafeStore(::rootReducer, ServerState())
}
