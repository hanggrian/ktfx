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

/**
 * Container of [Node] that supports placing its children in each side.
 * At this point, [addNode] usually mean putting the child in the center.
 */
interface SidesNodeManager : NodeManager {

    /**
     * Add child in top position.
     *
     * @param node child to add
     * @return the child added
     */
    fun <T : Node> addTopNode(node: T): T

    /**
     * Add child in right position.
     *
     * @param node child to add
     * @return the child added
     */
    fun <T : Node> addRightNode(node: T): T

    /**
     * Add child in bottom position.
     *
     * @param node child to add
     * @return the child added
     */
    fun <T : Node> addBottomNode(node: T): T

    /**
     * Add child in left position.
     *
     * @param node child to add
     * @return the child added
     */
    fun <T : Node> addLeftNode(node: T): T
}

/** Alias of [NodeManager.addNode] with [init] builder. */
inline fun <T : Node> NodeManager.addNode(node: T, init: (@LayoutDslMarker T).() -> Unit): T {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    node.init()
    return addNode(node)
}

/** Alias of [SidesNodeManager.addTopNode] with [init] builder. */
inline fun <T : Node> SidesNodeManager.addTopNode(node: T, init: (@LayoutDslMarker T).() -> Unit): T {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    node.init()
    return addTopNode(node)
}

/** Alias of [SidesNodeManager.addRightNode] with [init] builder. */
inline fun <T : Node> SidesNodeManager.addRightNode(node: T, init: (@LayoutDslMarker T).() -> Unit): T {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    node.init()
    return addRightNode(node)
}

/** Alias of [SidesNodeManager.addBottomNode] with [init] builder. */
inline fun <T : Node> SidesNodeManager.addBottomNode(node: T, init: (@LayoutDslMarker T).() -> Unit): T {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    node.init()
    return addBottomNode(node)
}

/** Alias of [SidesNodeManager.addLeftNode] with [init] builder. */
inline fun <T : Node> SidesNodeManager.addLeftNode(node: T, init: (@LayoutDslMarker T).() -> Unit): T {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    node.init()
    return addLeftNode(node)
}
