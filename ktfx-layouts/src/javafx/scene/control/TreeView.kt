@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [TreeView] with initialization block. */
inline fun <T> treeView(
    root: TreeItem<T>? = null,
    init: (@LayoutDslMarker TreeView<T>).() -> Unit
): TreeView<T> {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return TreeView(root).apply(init)
}
/** Add a [TreeView] to this manager. */
fun <T> NodeManager.treeView(
    root: TreeItem<T>? = null
): TreeView<T> = addNode(TreeView(root))

/** Add a [TreeView] with initialization block to this manager. */
inline fun <T> NodeManager.treeView(
    root: TreeItem<T>? = null,
    init: (@LayoutDslMarker TreeView<T>).() -> Unit
): TreeView<T> {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(TreeView(root), init)
}
