@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.paint.Paint
import javafx.scene.shape.Circle
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Circle] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null
): Circle = circle(centerX = centerX, centerY = centerY, radius = radius, fill = fill) { }

/**
 * Create a [Circle] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    configuration: (@LayoutDslMarker Circle).() -> Unit
): Circle {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Circle(centerX, centerY, radius, fill)
    child.configuration()
    return child
}

/**
 * Add a [Circle] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    configuration: (@LayoutDslMarker Circle).() -> Unit
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
fun styledCircle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    vararg styleClass: String,
    id: String? = null
): Circle = styledCircle(
    centerX = centerX, centerY = centerY, radius = radius, fill = fill,
    styleClass = *styleClass, id = id
) { }

/**
 * Add a styled [Circle] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledCircle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    vararg styleClass: String,
    id: String? = null
): Circle = styledCircle(
    centerX = centerX, centerY = centerY, radius = radius, fill = fill,
    styleClass = *styleClass, id = id
) { }

/**
 * Create a styled [Circle] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledCircle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Circle).() -> Unit
): Circle {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Circle(centerX, centerY, radius, fill)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Circle] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledCircle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Circle).() -> Unit
): Circle {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Circle(centerX, centerY, radius, fill)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
