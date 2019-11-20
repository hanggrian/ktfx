@file:JvmMultifileClass
@file:JvmName("ManagerKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Container of [Node], being used in most subclasses of [javafx.scene.Parent]. */
interface NodeManager {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @param node child to add
     * @return the child added
     */
    fun <T : Node> addNode(node: T): T
}

/** Alias of [NodeManager.addNode] with [init] builder. */
inline fun <T : Node> NodeManager.addNode(node: T, init: T.() -> Unit): T {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    node.init()
    return addNode(node)
}
