@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXBadge
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
 * Add a [JFXBadge] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxBadge(): JFXBadge = jfxBadge() { }

/**
 * Create a [JFXBadge] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun jfxBadge(configuration: (@LayoutDslMarker KtfxJFXBadge).() -> Unit): JFXBadge {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxJFXBadge(), configuration = configuration)
}

/**
 * Add a [JFXBadge] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.jfxBadge(configuration: (@LayoutDslMarker KtfxJFXBadge).() -> Unit):
    JFXBadge {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxJFXBadge(), configuration = configuration))
}

/**
 * Create a styled [JFXBadge].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledJFXBadge(vararg styleClass: String, id: String? = null): JFXBadge =
    styledJFXBadge(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXBadge] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledJFXBadge(vararg styleClass: String, id: String? = null): JFXBadge =
    styledJFXBadge(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXBadge] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledJFXBadge(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxJFXBadge).() -> Unit
): JFXBadge {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxJFXBadge(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [JFXBadge] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXBadge(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxJFXBadge).() -> Unit
): JFXBadge {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxJFXBadge(), styleClass = *styleClass, id = id, configuration =
      configuration))
}
