@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.QuadCurveTo
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [QuadCurveTo]  with initialization block. */
inline fun quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    init: (@LayoutDslMarker QuadCurveTo).() -> Unit
): QuadCurveTo {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return QuadCurveTo(controlX, controlY, x, y).apply(init)
}
/** Add a [QuadCurveTo] to this manager. */
fun PathElementManager.quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0
): QuadCurveTo = addElement(QuadCurveTo(controlX, controlY, x, y))

/** Add a [QuadCurveTo]  with initialization block to this manager. */
inline fun PathElementManager.quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    init: (@LayoutDslMarker QuadCurveTo).() -> Unit
): QuadCurveTo {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addElement(QuadCurveTo(controlX, controlY, x, y), init)
}
