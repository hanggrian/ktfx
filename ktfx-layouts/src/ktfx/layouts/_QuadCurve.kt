@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.QuadCurve
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [QuadCurve] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.quadCurve(
  startX: Double = 0.0,
  startY: Double = 0.0,
  controlX: Double = 0.0,
  controlY: Double = 0.0,
  endX: Double = 0.0,
  endY: Double = 0.0
): QuadCurve = quadCurve(startX = startX, startY = startY, controlX = controlX, controlY = controlY,
    endX = endX, endY = endY) { }

/**
 * Create a [QuadCurve] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun quadCurve(
  startX: Double = 0.0,
  startY: Double = 0.0,
  controlX: Double = 0.0,
  controlY: Double = 0.0,
  endX: Double = 0.0,
  endY: Double = 0.0,
  configuration: (@LayoutDslMarker QuadCurve).() -> Unit
): QuadCurve {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(QuadCurve(startX, startY, controlX, controlY, endX, endY), configuration =
      configuration)
}

/**
 * Add a [QuadCurve] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.quadCurve(
  startX: Double = 0.0,
  startY: Double = 0.0,
  controlX: Double = 0.0,
  controlY: Double = 0.0,
  endX: Double = 0.0,
  endY: Double = 0.0,
  configuration: (@LayoutDslMarker QuadCurve).() -> Unit
): QuadCurve {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(QuadCurve(startX, startY, controlX, controlY, endX, endY), configuration
      = configuration))
}

/**
 * Create a styled [QuadCurve].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledQuadCurve(
  startX: Double = 0.0,
  startY: Double = 0.0,
  controlX: Double = 0.0,
  controlY: Double = 0.0,
  endX: Double = 0.0,
  endY: Double = 0.0,
  vararg styleClass: String,
  id: String? = null
): QuadCurve = styledQuadCurve(startX = startX, startY = startY, controlX = controlX, controlY =
    controlY, endX = endX, endY = endY, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [QuadCurve] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledQuadCurve(
  startX: Double = 0.0,
  startY: Double = 0.0,
  controlX: Double = 0.0,
  controlY: Double = 0.0,
  endX: Double = 0.0,
  endY: Double = 0.0,
  vararg styleClass: String,
  id: String? = null
): QuadCurve = styledQuadCurve(startX = startX, startY = startY, controlX = controlX, controlY =
    controlY, endX = endX, endY = endY, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [QuadCurve] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledQuadCurve(
  startX: Double = 0.0,
  startY: Double = 0.0,
  controlX: Double = 0.0,
  controlY: Double = 0.0,
  endX: Double = 0.0,
  endY: Double = 0.0,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker QuadCurve).() -> Unit
): QuadCurve {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(QuadCurve(startX, startY, controlX, controlY, endX, endY), styleClass =
      *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [QuadCurve] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledQuadCurve(
  startX: Double = 0.0,
  startY: Double = 0.0,
  controlX: Double = 0.0,
  controlY: Double = 0.0,
  endX: Double = 0.0,
  endY: Double = 0.0,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker QuadCurve).() -> Unit
): QuadCurve {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(QuadCurve(startX, startY, controlX, controlY, endX, endY), styleClass =
      *styleClass, id = id, configuration = configuration))
}
