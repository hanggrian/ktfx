@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.paint.Paint
import javafx.scene.shape.Circle
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Circle] with initialization block. */
inline fun circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    init: (@LayoutDslMarker Circle).() -> Unit
): Circle {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return Circle(centerX, centerY, radius, fill).apply(init)
}
/** Add a [Circle] to this manager. */
fun NodeManager.circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null
): Circle = addNode(Circle(centerX, centerY, radius, fill))

/** Add a [Circle] with initialization block to this manager. */
inline fun NodeManager.circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    init: (@LayoutDslMarker Circle).() -> Unit
): Circle {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(Circle(centerX, centerY, radius, fill), init)
}
