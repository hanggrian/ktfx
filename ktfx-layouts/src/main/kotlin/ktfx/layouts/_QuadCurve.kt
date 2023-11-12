@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.shape.QuadCurve
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [QuadCurve] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
): QuadCurve = quadCurve(startX = startX, startY = startY, controlX = controlX, controlY = controlY,
        endX = endX, endY = endY) { }

/**
 * Create a [QuadCurve] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker QuadCurve).() -> Unit,
): QuadCurve {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = QuadCurve(startX, startY, controlX, controlY, endX, endY)
    child.configuration()
    return child
}

/**
 * Add a [QuadCurve] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker QuadCurve).() -> Unit,
): QuadCurve {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = QuadCurve(startX, startY, controlX, controlY, endX, endY)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [QuadCurve].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledQuadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): QuadCurve = styledQuadCurve(startX = startX, startY = startY, controlX = controlX, controlY =
        controlY, endX = endX, endY = endY, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [QuadCurve] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledQuadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): QuadCurve = styledQuadCurve(startX = startX, startY = startY, controlX = controlX, controlY =
        controlY, endX = endX, endY = endY, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [QuadCurve] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledQuadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker QuadCurve).() -> Unit,
): QuadCurve {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = QuadCurve(startX, startY, controlX, controlY, endX, endY)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [QuadCurve] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledQuadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker QuadCurve).() -> Unit,
): QuadCurve {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = QuadCurve(startX, startY, controlX, controlY, endX, endY)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
