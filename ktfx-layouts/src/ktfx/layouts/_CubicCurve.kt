@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.CubicCurve
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
 * Add a [CubicCurve] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.cubicCurve(
  startX: Double = 0.0,
  startY: Double = 0.0,
  controlX1: Double = 0.0,
  controlY1: Double = 0.0,
  controlX2: Double = 0.0,
  controlY2: Double = 0.0,
  endX: Double = 0.0,
  endY: Double = 0.0
): CubicCurve = cubicCurve(startX = startX, startY = startY, controlX1 = controlX1, controlY1 =
    controlY1, controlX2 = controlX2, controlY2 = controlY2, endX = endX, endY = endY) { }

/**
 * Create a [CubicCurve] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun cubicCurve(
  startX: Double = 0.0,
  startY: Double = 0.0,
  controlX1: Double = 0.0,
  controlY1: Double = 0.0,
  controlX2: Double = 0.0,
  controlY2: Double = 0.0,
  endX: Double = 0.0,
  endY: Double = 0.0,
  configuration: (@LayoutDslMarker CubicCurve).() -> Unit
): CubicCurve {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX,
      endY), configuration = configuration)
}

/**
 * Add a [CubicCurve] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.cubicCurve(
  startX: Double = 0.0,
  startY: Double = 0.0,
  controlX1: Double = 0.0,
  controlY1: Double = 0.0,
  controlX2: Double = 0.0,
  controlY2: Double = 0.0,
  endX: Double = 0.0,
  endY: Double = 0.0,
  configuration: (@LayoutDslMarker CubicCurve).() -> Unit
): CubicCurve {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2,
      endX, endY), configuration = configuration))
}

/**
 * Create a styled [CubicCurve].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledCubicCurve(
  startX: Double = 0.0,
  startY: Double = 0.0,
  controlX1: Double = 0.0,
  controlY1: Double = 0.0,
  controlX2: Double = 0.0,
  controlY2: Double = 0.0,
  endX: Double = 0.0,
  endY: Double = 0.0,
  vararg styleClass: String,
  id: String? = null
): CubicCurve = styledCubicCurve(startX = startX, startY = startY, controlX1 = controlX1, controlY1
    = controlY1, controlX2 = controlX2, controlY2 = controlY2, endX = endX, endY = endY, styleClass
    = *styleClass, id = id) { }

/**
 * Add a styled [CubicCurve] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledCubicCurve(
  startX: Double = 0.0,
  startY: Double = 0.0,
  controlX1: Double = 0.0,
  controlY1: Double = 0.0,
  controlX2: Double = 0.0,
  controlY2: Double = 0.0,
  endX: Double = 0.0,
  endY: Double = 0.0,
  vararg styleClass: String,
  id: String? = null
): CubicCurve = styledCubicCurve(startX = startX, startY = startY, controlX1 = controlX1, controlY1
    = controlY1, controlX2 = controlX2, controlY2 = controlY2, endX = endX, endY = endY, styleClass
    = *styleClass, id = id) { }

/**
 * Create a styled [CubicCurve] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledCubicCurve(
  startX: Double = 0.0,
  startY: Double = 0.0,
  controlX1: Double = 0.0,
  controlY1: Double = 0.0,
  controlX2: Double = 0.0,
  controlY2: Double = 0.0,
  endX: Double = 0.0,
  endY: Double = 0.0,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker CubicCurve).() -> Unit
): CubicCurve {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX,
      endY), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [CubicCurve] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledCubicCurve(
  startX: Double = 0.0,
  startY: Double = 0.0,
  controlX1: Double = 0.0,
  controlY1: Double = 0.0,
  controlX2: Double = 0.0,
  controlY2: Double = 0.0,
  endX: Double = 0.0,
  endY: Double = 0.0,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker CubicCurve).() -> Unit
): CubicCurve {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2,
      endX, endY), styleClass = *styleClass, id = id, configuration = configuration))
}
