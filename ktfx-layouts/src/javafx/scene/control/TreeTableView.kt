@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [TreeTableView] with initialization block. */
inline fun <S> treeTableView(
    root: TreeItem<S>? = null,
    init: (@LayoutDslMarker TreeTableView<S>).() -> Unit
): TreeTableView<S> {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return TreeTableView(root).apply(init)
}
/** Add a [TreeTableView] to this manager. */
fun <S> NodeManager.treeTableView(
    root: TreeItem<S>? = null
): TreeTableView<S> = addNode(TreeTableView(root))

/** Add a [TreeTableView] with initialization block to this manager. */
inline fun <S> NodeManager.treeTableView(
    root: TreeItem<S>? = null,
    init: (@LayoutDslMarker TreeTableView<S>).() -> Unit
): TreeTableView<S> {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(TreeTableView(root), init)
}
