@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.shape.Ellipse
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
 * Add an [Ellipse] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
): Ellipse = ellipse(centerX = centerX, centerY = centerY, radiusX = radiusX, radiusY = radiusY) { }

/**
 * Create an [Ellipse] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker Ellipse).() -> Unit,
): Ellipse {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Ellipse(centerX, centerY, radiusX, radiusY)
    child.configuration()
    return child
}

/**
 * Add an [Ellipse] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker Ellipse).() -> Unit,
): Ellipse {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Ellipse(centerX, centerY, radiusX, radiusY)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Ellipse].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledEllipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): Ellipse = styledEllipse(centerX = centerX, centerY = centerY, radiusX = radiusX, radiusY =
        radiusY, styleClass = styleClass, id = id) { }

/**
 * Add a styled [Ellipse] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledEllipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): Ellipse = styledEllipse(centerX = centerX, centerY = centerY, radiusX = radiusX, radiusY =
        radiusY, styleClass = styleClass, id = id) { }

/**
 * Create a styled [Ellipse] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledEllipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Ellipse).() -> Unit,
): Ellipse {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Ellipse(centerX, centerY, radiusX, radiusY)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Ellipse] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledEllipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Ellipse).() -> Unit,
): Ellipse {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Ellipse(centerX, centerY, radiusX, radiusY)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
