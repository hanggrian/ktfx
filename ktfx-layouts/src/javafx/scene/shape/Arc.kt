@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Arc
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create an [Arc] with initialization block. */
inline fun arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    init: (@LayoutsDslMarker Arc).() -> Unit
): Arc {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Arc(centerX, centerY, radiusX, radiusY, startAngle, length).apply(init)
}

/** Add an [Arc] to this manager. */
fun NodeManager.arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0
): Arc = addNode(Arc(centerX, centerY, radiusX, radiusY, startAngle, length))

/** Add an [Arc] with initialization block to this manager. */
inline fun NodeManager.arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    init: (@LayoutsDslMarker Arc).() -> Unit
): Arc {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(Arc(centerX, centerY, radiusX, radiusY, startAngle, length), init)
}
