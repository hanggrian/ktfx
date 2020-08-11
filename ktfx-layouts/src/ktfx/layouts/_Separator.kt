@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.control.Separator
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Separator] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.separator(orientation: Orientation = HORIZONTAL): Separator = separator(orientation
    = orientation) { }

/**
 * Create a [Separator] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun separator(orientation: Orientation = HORIZONTAL, configuration: (@LayoutDslMarker
    Separator).() -> Unit): Separator {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Separator(orientation), configuration = configuration)
}

/**
 * Add a [Separator] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.separator(orientation: Orientation = HORIZONTAL,
    configuration: (@LayoutDslMarker Separator).() -> Unit): Separator {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Separator(orientation), configuration = configuration))
}

/**
 * Create a styled [Separator].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledSeparator(
  orientation: Orientation = HORIZONTAL,
  vararg styleClass: String,
  id: String? = null
): Separator = styledSeparator(orientation = orientation, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Separator] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledSeparator(
  orientation: Orientation = HORIZONTAL,
  vararg styleClass: String,
  id: String? = null
): Separator = styledSeparator(orientation = orientation, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Separator] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledSeparator(
  orientation: Orientation = HORIZONTAL,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Separator).() -> Unit
): Separator {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Separator(orientation), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [Separator] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledSeparator(
  orientation: Orientation = HORIZONTAL,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Separator).() -> Unit
): Separator {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Separator(orientation), styleClass = *styleClass, id = id, configuration
      = configuration))
}
