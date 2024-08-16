@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.shape.QuadCurveTo
import kotlin.Double
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [QuadCurveTo] to this container.
 *
 * @return the control added.
 */
public inline fun PathElementContainer.quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
): QuadCurveTo = quadCurveTo(controlX = controlX, controlY = controlY, x = x, y = y) { }

/**
 * Create a [QuadCurveTo] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker QuadCurveTo).() -> Unit,
): QuadCurveTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = QuadCurveTo(controlX, controlY, x, y)
    child.configuration()
    return child
}

/**
 * Add a [QuadCurveTo] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun PathElementContainer.quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker QuadCurveTo).() -> Unit,
): QuadCurveTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = QuadCurveTo(controlX, controlY, x, y)
    child.configuration()
    return addChild(child)
}
