@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeCell
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
 * Add a [JFXTreeCell] to this manager.
 *
 * @return the control added.
 */
fun <T> NodeManager.jfxTreeCell(): JFXTreeCell<T> = jfxTreeCell() { }

/**
 * Create a [JFXTreeCell] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun <T> jfxTreeCell(configuration: (@LayoutDslMarker JFXTreeCell<T>).() -> Unit):
    JFXTreeCell<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(JFXTreeCell<T>(), configuration = configuration)
}

/**
 * Add a [JFXTreeCell] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun <T> NodeManager.jfxTreeCell(configuration: (@LayoutDslMarker JFXTreeCell<T>).() -> Unit):
    JFXTreeCell<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXTreeCell<T>(), configuration = configuration))
}

/**
 * Create a styled [JFXTreeCell].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun <T> styledJFXTreeCell(vararg styleClass: String, id: String? = null): JFXTreeCell<T> =
    styledJFXTreeCell(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXTreeCell] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun <T> NodeManager.styledJFXTreeCell(vararg styleClass: String, id: String? = null): JFXTreeCell<T>
    = styledJFXTreeCell(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXTreeCell] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun <T> styledJFXTreeCell(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker JFXTreeCell<T>).() -> Unit
): JFXTreeCell<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(JFXTreeCell<T>(), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [JFXTreeCell] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun <T> NodeManager.styledJFXTreeCell(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker JFXTreeCell<T>).() -> Unit
): JFXTreeCell<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXTreeCell<T>(), styleClass = *styleClass, id = id, configuration =
      configuration))
}
