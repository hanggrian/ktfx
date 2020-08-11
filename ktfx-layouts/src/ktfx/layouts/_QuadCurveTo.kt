@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.QuadCurveTo
import kotlin.Double
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [QuadCurveTo] to this manager.
 *
 * @return the control added.
 */
fun PathElementManager.quadCurveTo(
  controlX: Double = 0.0,
  controlY: Double = 0.0,
  x: Double = 0.0,
  y: Double = 0.0
): QuadCurveTo = quadCurveTo(controlX = controlX, controlY = controlY, x = x, y = y) { }

/**
 * Create a [QuadCurveTo] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun quadCurveTo(
  controlX: Double = 0.0,
  controlY: Double = 0.0,
  x: Double = 0.0,
  y: Double = 0.0,
  configuration: (@LayoutDslMarker QuadCurveTo).() -> Unit
): QuadCurveTo {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(QuadCurveTo(controlX, controlY, x, y), configuration = configuration)
}

/**
 * Add a [QuadCurveTo] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun PathElementManager.quadCurveTo(
  controlX: Double = 0.0,
  controlY: Double = 0.0,
  x: Double = 0.0,
  y: Double = 0.0,
  configuration: (@LayoutDslMarker QuadCurveTo).() -> Unit
): QuadCurveTo {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(QuadCurveTo(controlX, controlY, x, y), configuration = configuration))
}
