@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.shape.Cylinder
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Cylinder] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
): Cylinder = cylinder(radius = radius, height = height, division = division) { }

/**
 * Create a [Cylinder] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    configuration: (@KtfxLayoutDslMarker Cylinder).() -> Unit,
): Cylinder {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Cylinder(radius, height, division)
    child.configuration()
    return child
}

/**
 * Add a [Cylinder] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    configuration: (@KtfxLayoutDslMarker Cylinder).() -> Unit,
): Cylinder {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Cylinder(radius, height, division)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Cylinder].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledCylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    vararg styleClass: String,
    id: String? = null,
): Cylinder = styledCylinder(radius = radius, height = height, division = division, styleClass =
        styleClass, id = id) { }

/**
 * Add a styled [Cylinder] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledCylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    vararg styleClass: String,
    id: String? = null,
): Cylinder = styledCylinder(radius = radius, height = height, division = division, styleClass =
        styleClass, id = id) { }

/**
 * Create a styled [Cylinder] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledCylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Cylinder).() -> Unit,
): Cylinder {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Cylinder(radius, height, division)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Cylinder] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledCylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Cylinder).() -> Unit,
): Cylinder {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Cylinder(radius, height, division)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
