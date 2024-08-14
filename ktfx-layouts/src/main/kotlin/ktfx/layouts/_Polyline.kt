@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.shape.Polyline
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Polyline] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.polyline(): Polyline = polyline() { }

/**
 * Create a [Polyline] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public fun polyline(configuration: (@KtfxLayoutDslMarker Polyline).() -> Unit): Polyline {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Polyline()
    child.configuration()
    return child
}

/**
 * Add a [Polyline] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public fun NodeContainer.polyline(configuration: (@KtfxLayoutDslMarker Polyline).() -> Unit):
        Polyline {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Polyline()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Polyline].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun styledPolyline(vararg styleClass: String, id: String? = null): Polyline =
        styledPolyline(styleClass = styleClass, id = id) { }

/**
 * Add a styled [Polyline] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledPolyline(vararg styleClass: String, id: String? = null):
        Polyline = styledPolyline(styleClass = styleClass, id = id) { }

/**
 * Create a styled [Polyline] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public fun styledPolyline(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Polyline).() -> Unit,
): Polyline {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Polyline()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Polyline] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public fun NodeContainer.styledPolyline(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Polyline).() -> Unit,
): Polyline {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Polyline()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
