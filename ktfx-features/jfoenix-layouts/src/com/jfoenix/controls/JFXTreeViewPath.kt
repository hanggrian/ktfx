@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeViewPath
import javafx.scene.control.TreeView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.KtfxLayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXTreeViewPath] with initialization block. */
inline fun jfxTreeViewPath(
    treeView: TreeView<*>? = null,
    init: (@KtfxLayoutsDslMarker JFXTreeViewPath).() -> Unit
): JFXTreeViewPath {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXTreeViewPath(treeView).apply(init)
}

/** Add a [JFXTreeViewPath] to this manager. */
fun NodeManager.jfxTreeViewPath(
    treeView: TreeView<*>? = null
): JFXTreeViewPath = addNode(JFXTreeViewPath(treeView))

/** Add a [JFXTreeViewPath] with initialization block to this manager. */
inline fun NodeManager.jfxTreeViewPath(
    treeView: TreeView<*>? = null,
    init: (@KtfxLayoutsDslMarker JFXTreeViewPath).() -> Unit
): JFXTreeViewPath {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXTreeViewPath(treeView), init)
}
