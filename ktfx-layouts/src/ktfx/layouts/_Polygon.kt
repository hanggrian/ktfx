@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Polygon
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Polygon] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.polygon(): Polygon = polygon() { }

/**
 * Create a [Polygon] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun polygon(configuration: (@LayoutDslMarker Polygon).() -> Unit): Polygon {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Polygon(), configuration = configuration)
}

/**
 * Add a [Polygon] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.polygon(configuration: (@LayoutDslMarker Polygon).() -> Unit): Polygon {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Polygon(), configuration = configuration))
}

/**
 * Create a styled [Polygon].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledPolygon(vararg styleClass: String, id: String? = null): Polygon = styledPolygon(styleClass
    = *styleClass, id = id) { }

/**
 * Add a styled [Polygon] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledPolygon(vararg styleClass: String, id: String? = null): Polygon =
    styledPolygon(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Polygon] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledPolygon(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Polygon).() -> Unit
): Polygon {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Polygon(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [Polygon] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledPolygon(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Polygon).() -> Unit
): Polygon {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Polygon(), styleClass = *styleClass, id = id, configuration =
      configuration))
}
