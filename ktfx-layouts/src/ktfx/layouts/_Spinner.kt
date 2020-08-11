@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Spinner
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Spinner] to this manager.
 *
 * @return the control added.
 */
fun <T> NodeManager.spinner(): Spinner<T> = spinner() { }

/**
 * Create a [Spinner] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun <T> spinner(configuration: (@LayoutDslMarker Spinner<T>).() -> Unit): Spinner<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Spinner<T>(), configuration = configuration)
}

/**
 * Add a [Spinner] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun <T> NodeManager.spinner(configuration: (@LayoutDslMarker Spinner<T>).() -> Unit):
    Spinner<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Spinner<T>(), configuration = configuration))
}

/**
 * Create a styled [Spinner].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun <T> styledSpinner(vararg styleClass: String, id: String? = null): Spinner<T> =
    styledSpinner(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Spinner] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun <T> NodeManager.styledSpinner(vararg styleClass: String, id: String? = null): Spinner<T> =
    styledSpinner(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Spinner] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun <T> styledSpinner(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Spinner<T>).() -> Unit
): Spinner<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Spinner<T>(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [Spinner] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun <T> NodeManager.styledSpinner(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Spinner<T>).() -> Unit
): Spinner<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Spinner<T>(), styleClass = *styleClass, id = id, configuration =
      configuration))
}
