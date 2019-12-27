@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Ellipse
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create an [Ellipse] with initialization block. */
inline fun ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    configuration: (@LayoutsDslMarker Ellipse).() -> Unit
): Ellipse {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Ellipse(centerX, centerY, radiusX, radiusY).apply(configuration)
}

/** Add an [Ellipse] to this manager. */
fun NodeManager.ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0
): Ellipse = addChild(Ellipse(centerX, centerY, radiusX, radiusY))

/** Add an [Ellipse] with initialization block to this manager. */
inline fun NodeManager.ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    configuration: (@LayoutsDslMarker Ellipse).() -> Unit
): Ellipse {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Ellipse(centerX, centerY, radiusX, radiusY), configuration)
}
