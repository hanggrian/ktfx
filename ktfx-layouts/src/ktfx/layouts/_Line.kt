@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Line
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Line] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0
): Line = line(centerX = centerX, centerY = centerY, endX = endX, endY = endY) { }

/**
 * Create a [Line] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker Line).() -> Unit
): Line {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Line(centerX, centerY, endX, endY)
    child.configuration()
    return child
}

/**
 * Add a [Line] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker Line).() -> Unit
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
fun styledLine(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): Line = styledLine(
    centerX = centerX, centerY = centerY, endX = endX, endY = endY,
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Add a styled [Line] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledLine(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): Line = styledLine(
    centerX = centerX, centerY = centerY, endX = endX, endY = endY,
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Create a styled [Line] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledLine(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Line).() -> Unit
): Line {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Line(centerX, centerY, endX, endY)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Line] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledLine(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Line).() -> Unit
): Line {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Line(centerX, centerY, endX, endY)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
