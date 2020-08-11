@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Polyline
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Polyline] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.polyline(): Polyline = polyline() { }

/**
 * Create a [Polyline] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun polyline(configuration: (@LayoutDslMarker Polyline).() -> Unit): Polyline {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Polyline(), configuration = configuration)
}

/**
 * Add a [Polyline] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.polyline(configuration: (@LayoutDslMarker Polyline).() -> Unit): Polyline {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Polyline(), configuration = configuration))
}

/**
 * Create a styled [Polyline].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledPolyline(vararg styleClass: String, id: String? = null): Polyline =
    styledPolyline(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Polyline] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledPolyline(vararg styleClass: String, id: String? = null): Polyline =
    styledPolyline(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Polyline] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledPolyline(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Polyline).() -> Unit
): Polyline {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Polyline(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [Polyline] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledPolyline(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Polyline).() -> Unit
): Polyline {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Polyline(), styleClass = *styleClass, id = id, configuration =
      configuration))
}
