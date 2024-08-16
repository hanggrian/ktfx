@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.shape.Sphere
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
 * Add a [Sphere] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.sphere(radius: Double = 1.0, division: Int = 64): Sphere =
        sphere(radius = radius, division = division) { }

/**
 * Create a [Sphere] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun sphere(
    radius: Double = 1.0,
    division: Int = 64,
    configuration: (@KtfxLayoutDslMarker Sphere).() -> Unit,
): Sphere {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Sphere(radius, division)
    child.configuration()
    return child
}

/**
 * Add a [Sphere] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.sphere(
    radius: Double = 1.0,
    division: Int = 64,
    configuration: (@KtfxLayoutDslMarker Sphere).() -> Unit,
): Sphere {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Sphere(radius, division)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Sphere].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledSphere(
    radius: Double = 1.0,
    division: Int = 64,
    vararg styleClass: String,
    id: String? = null,
): Sphere = styledSphere(radius = radius, division = division, styleClass = styleClass, id = id) { }

/**
 * Add a styled [Sphere] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledSphere(
    radius: Double = 1.0,
    division: Int = 64,
    vararg styleClass: String,
    id: String? = null,
): Sphere = styledSphere(radius = radius, division = division, styleClass = styleClass, id = id) { }

/**
 * Create a styled [Sphere] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledSphere(
    radius: Double = 1.0,
    division: Int = 64,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Sphere).() -> Unit,
): Sphere {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Sphere(radius, division)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Sphere] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledSphere(
    radius: Double = 1.0,
    division: Int = 64,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Sphere).() -> Unit,
): Sphere {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Sphere(radius, division)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
