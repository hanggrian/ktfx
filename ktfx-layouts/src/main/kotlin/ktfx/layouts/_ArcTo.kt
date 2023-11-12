@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.shape.ArcTo
import kotlin.Boolean
import kotlin.Double
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add an [ArcTo] to this container.
 *
 * @return the control added.
 */
public fun PathElementContainer.arcTo(
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    xAxisRotation: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    largeArcFlag: Boolean = false,
    sweepFlag: Boolean = false,
): ArcTo = arcTo(radiusX = radiusX, radiusY = radiusY, xAxisRotation = xAxisRotation, x = x, y = y,
        largeArcFlag = largeArcFlag, sweepFlag = sweepFlag) { }

/**
 * Create an [ArcTo] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun arcTo(
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    xAxisRotation: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    largeArcFlag: Boolean = false,
    sweepFlag: Boolean = false,
    configuration: (@KtfxLayoutDslMarker ArcTo).() -> Unit,
): ArcTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ArcTo(radiusX, radiusY, xAxisRotation, x, y, largeArcFlag, sweepFlag)
    child.configuration()
    return child
}

/**
 * Add an [ArcTo] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun PathElementContainer.arcTo(
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    xAxisRotation: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    largeArcFlag: Boolean = false,
    sweepFlag: Boolean = false,
    configuration: (@KtfxLayoutDslMarker ArcTo).() -> Unit,
): ArcTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ArcTo(radiusX, radiusY, xAxisRotation, x, y, largeArcFlag, sweepFlag)
    child.configuration()
    return addChild(child)
}
