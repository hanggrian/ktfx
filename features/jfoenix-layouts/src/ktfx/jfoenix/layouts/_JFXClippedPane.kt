@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXClippedPane
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
 * Add a [JFXClippedPane] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxClippedPane(): JFXClippedPane = jfxClippedPane() { }

/**
 * Create a [JFXClippedPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun jfxClippedPane(configuration: (@LayoutDslMarker KtfxJFXClippedPane).() -> Unit):
    JFXClippedPane {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxJFXClippedPane(), configuration = configuration)
}

/**
 * Add a [JFXClippedPane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.jfxClippedPane(configuration: (@LayoutDslMarker KtfxJFXClippedPane).() ->
    Unit): JFXClippedPane {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxJFXClippedPane(), configuration = configuration))
}

/**
 * Create a styled [JFXClippedPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledJFXClippedPane(vararg styleClass: String, id: String? = null): JFXClippedPane =
    styledJFXClippedPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXClippedPane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledJFXClippedPane(vararg styleClass: String, id: String? = null): JFXClippedPane
    = styledJFXClippedPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXClippedPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledJFXClippedPane(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxJFXClippedPane).() -> Unit
): JFXClippedPane {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxJFXClippedPane(), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [JFXClippedPane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXClippedPane(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxJFXClippedPane).() -> Unit
): JFXClippedPane {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxJFXClippedPane(), styleClass = *styleClass, id = id, configuration =
      configuration))
}
