@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.ArcTo
import kotlin.Boolean
import kotlin.Double
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add an [ArcTo] to this manager.
 */
fun PathElementManager.arcTo(
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    xAxisRotation: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    largeArcFlag: Boolean = false,
    sweepFlag: Boolean = false
): ArcTo = arcTo(radiusX = radiusX, radiusY = radiusY, xAxisRotation = xAxisRotation, x = x, y = y,
        largeArcFlag = largeArcFlag, sweepFlag = sweepFlag) { }

/**
 * Create an [ArcTo] with configuration block.
 */
inline fun arcTo(
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    xAxisRotation: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    largeArcFlag: Boolean = false,
    sweepFlag: Boolean = false,
    configuration: (@LayoutDslMarker ArcTo).() -> Unit
): ArcTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ArcTo(radiusX, radiusY, xAxisRotation, x, y, largeArcFlag, sweepFlag),
            configuration = configuration)
}

/**
 * Add an [ArcTo] with configuration block to this manager.
 */
inline fun PathElementManager.arcTo(
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    xAxisRotation: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    largeArcFlag: Boolean = false,
    sweepFlag: Boolean = false,
    configuration: (@LayoutDslMarker ArcTo).() -> Unit
): ArcTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ArcTo(radiusX, radiusY, xAxisRotation, x, y, largeArcFlag, sweepFlag),
            configuration = configuration))
}
