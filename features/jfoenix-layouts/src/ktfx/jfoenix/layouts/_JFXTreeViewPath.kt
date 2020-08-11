@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeViewPath
import javafx.scene.control.TreeView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/**
 * Add a [JFXTreeViewPath] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxTreeViewPath(treeView: TreeView<*>? = null): JFXTreeViewPath =
    jfxTreeViewPath(treeView = treeView) { }

/**
 * Create a [JFXTreeViewPath] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun jfxTreeViewPath(treeView: TreeView<*>? = null, configuration: (@LayoutDslMarker
    JFXTreeViewPath).() -> Unit): JFXTreeViewPath {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(JFXTreeViewPath(treeView), configuration = configuration)
}

/**
 * Add a [JFXTreeViewPath] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.jfxTreeViewPath(treeView: TreeView<*>? = null,
    configuration: (@LayoutDslMarker JFXTreeViewPath).() -> Unit): JFXTreeViewPath {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXTreeViewPath(treeView), configuration = configuration))
}

/**
 * Create a styled [JFXTreeViewPath].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledJFXTreeViewPath(
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
fun NodeManager.styledJFXTreeViewPath(
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
inline fun styledJFXTreeViewPath(
  treeView: TreeView<*>? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker JFXTreeViewPath).() -> Unit
): JFXTreeViewPath {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(JFXTreeViewPath(treeView), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [JFXTreeViewPath] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXTreeViewPath(
  treeView: TreeView<*>? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker JFXTreeViewPath).() -> Unit
): JFXTreeViewPath {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXTreeViewPath(treeView), styleClass = *styleClass, id = id,
      configuration = configuration))
}
