@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.control.TreeItem
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
import org.controlsfx.control.BreadCrumbBar

/**
 * Add a [BreadCrumbBar] to this manager.
 *
 * @return the control added.
 */
fun <T> NodeManager.breadCrumbBar(selectedCrumb: TreeItem<T>? = null): BreadCrumbBar<T> =
    breadCrumbBar(selectedCrumb = selectedCrumb) { }

/**
 * Create a [BreadCrumbBar] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun <T> breadCrumbBar(selectedCrumb: TreeItem<T>? = null, configuration: (@LayoutDslMarker
    BreadCrumbBar<T>).() -> Unit): BreadCrumbBar<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(BreadCrumbBar<T>(selectedCrumb), configuration = configuration)
}

/**
 * Add a [BreadCrumbBar] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun <T> NodeManager.breadCrumbBar(selectedCrumb: TreeItem<T>? = null,
    configuration: (@LayoutDslMarker BreadCrumbBar<T>).() -> Unit): BreadCrumbBar<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(BreadCrumbBar<T>(selectedCrumb), configuration = configuration))
}

/**
 * Create a styled [BreadCrumbBar].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun <T> styledBreadCrumbBar(
  selectedCrumb: TreeItem<T>? = null,
  vararg styleClass: String,
  id: String? = null
): BreadCrumbBar<T> = styledBreadCrumbBar(selectedCrumb = selectedCrumb, styleClass = *styleClass,
    id = id) { }

/**
 * Add a styled [BreadCrumbBar] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun <T> NodeManager.styledBreadCrumbBar(
  selectedCrumb: TreeItem<T>? = null,
  vararg styleClass: String,
  id: String? = null
): BreadCrumbBar<T> = styledBreadCrumbBar(selectedCrumb = selectedCrumb, styleClass = *styleClass,
    id = id) { }

/**
 * Create a styled [BreadCrumbBar] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun <T> styledBreadCrumbBar(
  selectedCrumb: TreeItem<T>? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker BreadCrumbBar<T>).() -> Unit
): BreadCrumbBar<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(BreadCrumbBar<T>(selectedCrumb), styleClass = *styleClass, id = id, configuration
      = configuration)
}

/**
 * Add a styled [BreadCrumbBar] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun <T> NodeManager.styledBreadCrumbBar(
  selectedCrumb: TreeItem<T>? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker BreadCrumbBar<T>).() -> Unit
): BreadCrumbBar<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(BreadCrumbBar<T>(selectedCrumb), styleClass = *styleClass, id = id,
      configuration = configuration))
}
