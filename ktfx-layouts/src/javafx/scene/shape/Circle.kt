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
    configuration: (@LayoutsDslMarker Circle).() -> Unit
): Circle {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Circle(centerX, centerY, radius, fill).apply(configuration)
}

/** Add a [Circle] to this manager. */
fun NodeManager.circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null
): Circle = addChild(Circle(centerX, centerY, radius, fill))

/** Add a [Circle] with initialization block to this manager. */
inline fun NodeManager.circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    configuration: (@LayoutsDslMarker Circle).() -> Unit
): Circle {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Circle(centerX, centerY, radius, fill), configuration)
}
