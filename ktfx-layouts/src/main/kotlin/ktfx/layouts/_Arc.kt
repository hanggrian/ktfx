@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.shape.Arc
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
 * Add an [Arc] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
): Arc = arc(centerX = centerX, centerY = centerY, radiusX = radiusX, radiusY = radiusY, startAngle
        = startAngle, length = length) { }

/**
 * Create an [Arc] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker Arc).() -> Unit,
): Arc {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Arc(centerX, centerY, radiusX, radiusY, startAngle, length)
    child.configuration()
    return child
}

/**
 * Add an [Arc] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeManager.arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker Arc).() -> Unit,
): Arc {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Arc(centerX, centerY, radiusX, radiusY, startAngle, length)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Arc].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledArc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): Arc = styledArc(centerX = centerX, centerY = centerY, radiusX = radiusX, radiusY = radiusY,
        startAngle = startAngle, length = length, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Arc] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeManager.styledArc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): Arc = styledArc(centerX = centerX, centerY = centerY, radiusX = radiusX, radiusY = radiusY,
        startAngle = startAngle, length = length, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Arc] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledArc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Arc).() -> Unit,
): Arc {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Arc(centerX, centerY, radiusX, radiusY, startAngle, length)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Arc] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeManager.styledArc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Arc).() -> Unit,
): Arc {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Arc(centerX, centerY, radiusX, radiusY, startAngle, length)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
