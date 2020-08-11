@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.layout.Pane
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Pane] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.pane(): Pane = pane() { }

/**
 * Create a [Pane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun pane(configuration: (@LayoutDslMarker KtfxPane).() -> Unit): Pane {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxPane(), configuration = configuration)
}

/**
 * Add a [Pane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.pane(configuration: (@LayoutDslMarker KtfxPane).() -> Unit): Pane {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxPane(), configuration = configuration))
}

/**
 * Create a styled [Pane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledPane(vararg styleClass: String, id: String? = null): Pane = styledPane(styleClass =
    *styleClass, id = id) { }

/**
 * Add a styled [Pane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledPane(vararg styleClass: String, id: String? = null): Pane =
    styledPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Pane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledPane(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxPane).() -> Unit
): Pane {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxPane(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [Pane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledPane(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxPane).() -> Unit
): Pane {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxPane(), styleClass = *styleClass, id = id, configuration =
      configuration))
}
