@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.MenuBar
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [MenuBar] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.menuBar(): MenuBar = menuBar() { }

/**
 * Create a [MenuBar] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun menuBar(configuration: (@LayoutDslMarker KtfxMenuBar).() -> Unit): MenuBar {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxMenuBar(), configuration = configuration)
}

/**
 * Add a [MenuBar] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.menuBar(configuration: (@LayoutDslMarker KtfxMenuBar).() -> Unit): MenuBar {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxMenuBar(), configuration = configuration))
}

/**
 * Create a styled [MenuBar].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledMenuBar(vararg styleClass: String, id: String? = null): MenuBar = styledMenuBar(styleClass
    = *styleClass, id = id) { }

/**
 * Add a styled [MenuBar] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledMenuBar(vararg styleClass: String, id: String? = null): MenuBar =
    styledMenuBar(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [MenuBar] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledMenuBar(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxMenuBar).() -> Unit
): MenuBar {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxMenuBar(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [MenuBar] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledMenuBar(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxMenuBar).() -> Unit
): MenuBar {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxMenuBar(), styleClass = *styleClass, id = id, configuration =
      configuration))
}
