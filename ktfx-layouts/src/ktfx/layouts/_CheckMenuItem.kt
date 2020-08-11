@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CheckMenuItem
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [CheckMenuItem] to this manager.
 *
 * @return the control added.
 */
fun MenuItemManager.checkMenuItem(text: String? = null, graphic: Node? = null): CheckMenuItem =
    checkMenuItem(text = text, graphic = graphic) { }

/**
 * Create a [CheckMenuItem] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun checkMenuItem(
  text: String? = null,
  graphic: Node? = null,
  configuration: (@LayoutDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(CheckMenuItem(text, graphic), configuration = configuration)
}

/**
 * Add a [CheckMenuItem] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun MenuItemManager.checkMenuItem(
  text: String? = null,
  graphic: Node? = null,
  configuration: (@LayoutDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(CheckMenuItem(text, graphic), configuration = configuration))
}

/**
 * Create a styled [CheckMenuItem].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledCheckMenuItem(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null
): CheckMenuItem = styledCheckMenuItem(text = text, graphic = graphic, styleClass = *styleClass, id
    = id) { }

/**
 * Add a styled [CheckMenuItem] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun MenuItemManager.styledCheckMenuItem(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null
): CheckMenuItem = styledCheckMenuItem(text = text, graphic = graphic, styleClass = *styleClass, id
    = id) { }

/**
 * Create a styled [CheckMenuItem] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledCheckMenuItem(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(CheckMenuItem(text, graphic), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [CheckMenuItem] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun MenuItemManager.styledCheckMenuItem(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(CheckMenuItem(text, graphic), styleClass = *styleClass, id = id,
      configuration = configuration))
}
