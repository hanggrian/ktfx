@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.shape.CubicCurveTo
import kotlin.Double
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [CubicCurveTo] to this container.
 *
 * @return the control added.
 */
public fun PathElementContainer.cubicCurveTo(
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
): CubicCurveTo = cubicCurveTo(controlX1 = controlX1, controlY1 = controlY1, controlX2 = controlX2,
        controlY2 = controlY2, x = x, y = y) { }

/**
 * Create a [CubicCurveTo] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun cubicCurveTo(
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker CubicCurveTo).() -> Unit,
): CubicCurveTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y)
    child.configuration()
    return child
}

/**
 * Add a [CubicCurveTo] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun PathElementContainer.cubicCurveTo(
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker CubicCurveTo).() -> Unit,
): CubicCurveTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y)
    child.configuration()
    return addChild(child)
}
