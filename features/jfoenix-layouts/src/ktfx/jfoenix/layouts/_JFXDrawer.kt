@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawer
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
 * Add a [JFXDrawer] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxDrawer(): JFXDrawer = jfxDrawer() { }

/**
 * Create a [JFXDrawer] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun jfxDrawer(configuration: (@LayoutDslMarker KtfxJFXDrawer).() -> Unit): JFXDrawer {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxJFXDrawer(), configuration = configuration)
}

/**
 * Add a [JFXDrawer] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.jfxDrawer(configuration: (@LayoutDslMarker KtfxJFXDrawer).() -> Unit):
    JFXDrawer {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxJFXDrawer(), configuration = configuration))
}

/**
 * Create a styled [JFXDrawer].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledJFXDrawer(vararg styleClass: String, id: String? = null): JFXDrawer =
    styledJFXDrawer(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXDrawer] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledJFXDrawer(vararg styleClass: String, id: String? = null): JFXDrawer =
    styledJFXDrawer(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXDrawer] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledJFXDrawer(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxJFXDrawer).() -> Unit
): JFXDrawer {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxJFXDrawer(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [JFXDrawer] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXDrawer(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxJFXDrawer).() -> Unit
): JFXDrawer {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxJFXDrawer(), styleClass = *styleClass, id = id, configuration =
      configuration))
}
