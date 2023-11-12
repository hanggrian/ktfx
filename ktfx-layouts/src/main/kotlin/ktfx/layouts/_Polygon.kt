@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.shape.Polygon
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Polygon] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.polygon(): Polygon = polygon() { }

/**
 * Create a [Polygon] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun polygon(configuration: (@KtfxLayoutDslMarker Polygon).() -> Unit): Polygon {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Polygon()
    child.configuration()
    return child
}

/**
 * Add a [Polygon] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.polygon(configuration: (@KtfxLayoutDslMarker Polygon).() -> Unit):
        Polygon {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Polygon()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Polygon].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledPolygon(vararg styleClass: String, id: String? = null): Polygon =
        styledPolygon(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Polygon] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeContainer.styledPolygon(vararg styleClass: String, id: String? = null): Polygon =
        styledPolygon(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Polygon] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledPolygon(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Polygon).() -> Unit,
): Polygon {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Polygon()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Polygon] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledPolygon(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Polygon).() -> Unit,
): Polygon {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Polygon()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
