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
    configuration: (@LayoutsDslMarker TreeView<T>).() -> Unit
): TreeView<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return TreeView(root).apply(configuration)
}

/** Add a [TreeView] to this manager. */
fun <T> NodeManager.treeView(
    root: TreeItem<T>? = null
): TreeView<T> = addChild(TreeView(root))

/** Add a [TreeView] with initialization block to this manager. */
inline fun <T> NodeManager.treeView(
    root: TreeItem<T>? = null,
    configuration: (@LayoutsDslMarker TreeView<T>).() -> Unit
): TreeView<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(TreeView(root), configuration)
}
