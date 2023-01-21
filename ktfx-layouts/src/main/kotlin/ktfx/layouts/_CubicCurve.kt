@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.shape.CubicCurve
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [CubicCurve] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.cubicCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
): CubicCurve = cubicCurve(startX = startX, startY = startY, controlX1 = controlX1, controlY1 =
        controlY1, controlX2 = controlX2, controlY2 = controlY2, endX = endX, endY = endY) { }

/**
 * Create a [CubicCurve] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun cubicCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker CubicCurve).() -> Unit,
): CubicCurve {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY)
    child.configuration()
    return child
}

/**
 * Add a [CubicCurve] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeManager.cubicCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker CubicCurve).() -> Unit,
): CubicCurve {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [CubicCurve].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledCubicCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): CubicCurve = styledCubicCurve(startX = startX, startY = startY, controlX1 = controlX1, controlY1
        = controlY1, controlX2 = controlX2, controlY2 = controlY2, endX = endX, endY = endY,
        styleClass = *styleClass, id = id) { }

/**
 * Add a styled [CubicCurve] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeManager.styledCubicCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): CubicCurve = styledCubicCurve(startX = startX, startY = startY, controlX1 = controlX1, controlY1
        = controlY1, controlX2 = controlX2, controlY2 = controlY2, endX = endX, endY = endY,
        styleClass = *styleClass, id = id) { }

/**
 * Create a styled [CubicCurve] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledCubicCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CubicCurve).() -> Unit,
): CubicCurve {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [CubicCurve] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeManager.styledCubicCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CubicCurve).() -> Unit,
): CubicCurve {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
