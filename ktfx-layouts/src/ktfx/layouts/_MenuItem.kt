@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [MenuItem] to this manager.
 *
 * @return the control added.
 */
fun MenuItemManager.menuItem(text: String? = null, graphic: Node? = null): MenuItem = menuItem(text
    = text, graphic = graphic) { }

/**
 * Create a [MenuItem] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun menuItem(
  text: String? = null,
  graphic: Node? = null,
  configuration: (@LayoutDslMarker MenuItem).() -> Unit
): MenuItem {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(MenuItem(text, graphic), configuration = configuration)
}

/**
 * Add a [MenuItem] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun MenuItemManager.menuItem(
  text: String? = null,
  graphic: Node? = null,
  configuration: (@LayoutDslMarker MenuItem).() -> Unit
): MenuItem {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(MenuItem(text, graphic), configuration = configuration))
}

/**
 * Create a styled [MenuItem].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledMenuItem(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null
): MenuItem = styledMenuItem(text = text, graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [MenuItem] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun MenuItemManager.styledMenuItem(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null
): MenuItem = styledMenuItem(text = text, graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [MenuItem] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledMenuItem(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker MenuItem).() -> Unit
): MenuItem {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(MenuItem(text, graphic), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [MenuItem] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun MenuItemManager.styledMenuItem(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker MenuItem).() -> Unit
): MenuItem {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(MenuItem(text, graphic), styleClass = *styleClass, id = id, configuration
      = configuration))
}
