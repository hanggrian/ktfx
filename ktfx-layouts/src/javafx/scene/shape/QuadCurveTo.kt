@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.QuadCurveTo
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [QuadCurveTo]  with configuration block. */
inline fun quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@LayoutDslMarker QuadCurveTo).() -> Unit
): QuadCurveTo {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return QuadCurveTo(controlX, controlY, x, y).apply(configuration)
}

/** Add a [QuadCurveTo] to this manager. */
fun PathElementManager.quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0
): QuadCurveTo = addChild(QuadCurveTo(controlX, controlY, x, y))

/** Add a [QuadCurveTo]  with configuration block to this manager. */
inline fun PathElementManager.quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@LayoutDslMarker QuadCurveTo).() -> Unit
): QuadCurveTo {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(QuadCurveTo(controlX, controlY, x, y), configuration)
}
