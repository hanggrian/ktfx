@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeViewPath
import javafx.scene.control.TreeView
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXTreeViewPath] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.jfxTreeViewPath(treeView: TreeView<*>? = null): JFXTreeViewPath =
    jfxTreeViewPath(treeView = treeView) { }

/**
 * Create a [JFXTreeViewPath] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun jfxTreeViewPath(
    treeView: TreeView<*>? = null,
    configuration: (@KtfxLayoutDslMarker JFXTreeViewPath).() -> Unit
): JFXTreeViewPath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeViewPath(treeView)
    child.configuration()
    return child
}

/**
 * Add a [JFXTreeViewPath] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeManager.jfxTreeViewPath(
    treeView: TreeView<*>? = null,
    configuration: (@KtfxLayoutDslMarker JFXTreeViewPath).() -> Unit
): JFXTreeViewPath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeViewPath(treeView)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXTreeViewPath].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledJFXTreeViewPath(
    treeView: TreeView<*>? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTreeViewPath = styledJFXTreeViewPath(treeView = treeView, styleClass = *styleClass, id = id) {
}

/**
 * Add a styled [JFXTreeViewPath] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeManager.styledJFXTreeViewPath(
    treeView: TreeView<*>? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTreeViewPath = styledJFXTreeViewPath(treeView = treeView, styleClass = *styleClass, id = id) {
}

/**
 * Create a styled [JFXTreeViewPath] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledJFXTreeViewPath(
    treeView: TreeView<*>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTreeViewPath).() -> Unit
): JFXTreeViewPath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeViewPath(treeView)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXTreeViewPath] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeManager.styledJFXTreeViewPath(
    treeView: TreeView<*>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTreeViewPath).() -> Unit
): JFXTreeViewPath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeViewPath(treeView)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
