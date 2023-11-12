@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.shape.Line
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
 * Add a [Line] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
): Line = line(centerX = centerX, centerY = centerY, endX = endX, endY = endY) { }

/**
 * Create a [Line] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker Line).() -> Unit,
): Line {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Line(centerX, centerY, endX, endY)
    child.configuration()
    return child
}

/**
 * Add a [Line] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker Line).() -> Unit,
): Line {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Line(centerX, centerY, endX, endY)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Line].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledLine(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): Line = styledLine(centerX = centerX, centerY = centerY, endX = endX, endY = endY, styleClass =
        *styleClass, id = id) { }

/**
 * Add a styled [Line] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledLine(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): Line = styledLine(centerX = centerX, centerY = centerY, endX = endX, endY = endY, styleClass =
        *styleClass, id = id) { }

/**
 * Create a styled [Line] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledLine(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Line).() -> Unit,
): Line {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Line(centerX, centerY, endX, endY)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Line] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledLine(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Line).() -> Unit,
): Line {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Line(centerX, centerY, endX, endY)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
