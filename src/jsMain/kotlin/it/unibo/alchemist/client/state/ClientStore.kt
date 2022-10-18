package it.unibo.alchemist.client.state

import org.reduxkotlin.Store
import org.reduxkotlin.createStore

/**
 * The client store. The object that brings reducers and actions together.
 */
object ClientStore {

    /**
     * The redux store of the client.
     */
    val store: Store<ClientState> = createStore(::rootReducer, ClientState())
}
