@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Line
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Line] with initialization block. */
inline fun line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: (@LayoutsDslMarker Line).() -> Unit
): Line {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Line(centerX, centerY, endX, endY).apply(init)
}

/** Add a [Line] to this manager. */
fun NodeManager.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0
): Line = addNode(Line(centerX, centerY, endX, endY))

/** Add a [Line] with initialization block to this manager. */
inline fun NodeManager.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: (@LayoutsDslMarker Line).() -> Unit
): Line {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(Line(centerX, centerY, endX, endY), init)
}
