@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.paint.Paint
import javafx.scene.shape.Circle
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
 * Add a [Circle] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
): Circle = circle(centerX = centerX, centerY = centerY, radius = radius, fill = fill) { }

/**
 * Create a [Circle] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    configuration: (@KtfxLayoutDslMarker Circle).() -> Unit,
): Circle {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Circle(centerX, centerY, radius, fill)
    child.configuration()
    return child
}

/**
 * Add a [Circle] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    configuration: (@KtfxLayoutDslMarker Circle).() -> Unit,
): Circle {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Circle(centerX, centerY, radius, fill)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Circle].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledCircle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    vararg styleClass: String,
    id: String? = null,
): Circle = styledCircle(centerX = centerX, centerY = centerY, radius = radius, fill = fill,
        styleClass = styleClass, id = id) { }

/**
 * Add a styled [Circle] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledCircle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    vararg styleClass: String,
    id: String? = null,
): Circle = styledCircle(centerX = centerX, centerY = centerY, radius = radius, fill = fill,
        styleClass = styleClass, id = id) { }

/**
 * Create a styled [Circle] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledCircle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Circle).() -> Unit,
): Circle {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Circle(centerX, centerY, radius, fill)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Circle] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledCircle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Circle).() -> Unit,
): Circle {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Circle(centerX, centerY, radius, fill)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
