@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Path
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Path] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.path(): Path = path() { }

/**
 * Create a [Path] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun path(configuration: (@LayoutDslMarker KtfxPath).() -> Unit): Path {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxPath(), configuration = configuration)
}

/**
 * Add a [Path] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.path(configuration: (@LayoutDslMarker KtfxPath).() -> Unit): Path {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxPath(), configuration = configuration))
}

/**
 * Create a styled [Path].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledPath(vararg styleClass: String, id: String? = null): Path = styledPath(styleClass =
    *styleClass, id = id) { }

/**
 * Add a styled [Path] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledPath(vararg styleClass: String, id: String? = null): Path =
    styledPath(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Path] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledPath(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxPath).() -> Unit
): Path {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxPath(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [Path] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledPath(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxPath).() -> Unit
): Path {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxPath(), styleClass = *styleClass, id = id, configuration =
      configuration))
}
