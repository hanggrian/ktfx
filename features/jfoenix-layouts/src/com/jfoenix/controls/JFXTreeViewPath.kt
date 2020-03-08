@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeViewPath
import javafx.scene.control.TreeView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXTreeViewPath] with configuration block. */
inline fun jfxTreeViewPath(
    treeView: TreeView<*>? = null,
    configuration: (@LayoutDslMarker JFXTreeViewPath).() -> Unit
): JFXTreeViewPath {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXTreeViewPath(treeView).apply(configuration)
}

/** Add a [JFXTreeViewPath] to this manager. */
fun NodeManager.jfxTreeViewPath(
    treeView: TreeView<*>? = null
): JFXTreeViewPath = addChild(JFXTreeViewPath(treeView))

/** Add a [JFXTreeViewPath] with configuration block to this manager. */
inline fun NodeManager.jfxTreeViewPath(
    treeView: TreeView<*>? = null,
    configuration: (@LayoutDslMarker JFXTreeViewPath).() -> Unit
): JFXTreeViewPath {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXTreeViewPath(treeView), configuration)
}
