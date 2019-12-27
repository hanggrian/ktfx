@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.CubicCurveTo
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [CubicCurveTo] with initialization block. */
inline fun cubicCurveTo(
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@LayoutsDslMarker CubicCurveTo).() -> Unit
): CubicCurveTo {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return CubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y).apply(configuration)
}

/** Add a [CubicCurveTo] to this manager. */
fun PathElementManager.cubicCurveTo(
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0
): CubicCurveTo = addChild(CubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y))

/** Add a [CubicCurveTo] with initialization block to this manager. */
inline fun PathElementManager.cubicCurveTo(
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@LayoutsDslMarker CubicCurveTo).() -> Unit
): CubicCurveTo {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(CubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y), configuration)
}
