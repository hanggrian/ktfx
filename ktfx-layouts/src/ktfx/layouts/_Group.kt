@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Group
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Group] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.group(): Group = group() { }

/**
 * Create a [Group] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun group(configuration: (@LayoutDslMarker KtfxGroup).() -> Unit): Group {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxGroup(), configuration = configuration)
}

/**
 * Add a [Group] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.group(configuration: (@LayoutDslMarker KtfxGroup).() -> Unit): Group {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxGroup(), configuration = configuration))
}

/**
 * Create a styled [Group].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledGroup(vararg styleClass: String, id: String? = null): Group = styledGroup(styleClass =
    *styleClass, id = id) { }

/**
 * Add a styled [Group] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledGroup(vararg styleClass: String, id: String? = null): Group =
    styledGroup(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Group] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledGroup(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxGroup).() -> Unit
): Group {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxGroup(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [Group] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledGroup(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxGroup).() -> Unit
): Group {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxGroup(), styleClass = *styleClass, id = id, configuration =
      configuration))
}
