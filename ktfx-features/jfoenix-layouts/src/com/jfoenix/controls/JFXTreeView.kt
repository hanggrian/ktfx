@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeView
import javafx.scene.control.TreeItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXTreeView] with initialization block. */
inline fun <T> jfxTreeView(
    root: TreeItem<T>? = null,
    init: (@LayoutDslMarker JFXTreeView<T>).() -> Unit
): JFXTreeView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXTreeView(root).apply(init)
}
/** Add a [JFXTreeView] to this manager. */
fun <T> NodeManager.jfxTreeView(
    root: TreeItem<T>? = null
): JFXTreeView<T> = addNode(JFXTreeView(root))

/** Add a [JFXTreeView] with initialization block to this manager. */
inline fun <T> NodeManager.jfxTreeView(
    root: TreeItem<T>? = null,
    init: (@LayoutDslMarker JFXTreeView<T>).() -> Unit
): JFXTreeView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXTreeView(root), init)
}
