@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.QuadCurve
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [QuadCurve] with initialization block. */
inline fun quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: QuadCurve.() -> Unit
): QuadCurve {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return QuadCurve(startX, startY, controlX, controlY, endX, endY).apply(init)
}

/** Add a [QuadCurve] to this manager. */
fun NodeManager.quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0
): QuadCurve = addNode(QuadCurve(startX, startY, controlX, controlY, endX, endY))

/** Add a [QuadCurve] with initialization block to this manager. */
inline fun NodeManager.quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: QuadCurve.() -> Unit
): QuadCurve {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(QuadCurve(startX, startY, controlX, controlY, endX, endY), init)
}
