@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.control.Separator
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Separator] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.separator(orientation: Orientation = HORIZONTAL): Separator =
        separator(orientation = orientation) { }

/**
 * Create a [Separator] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun separator(orientation: Orientation = HORIZONTAL,
        configuration: (@KtfxLayoutDslMarker Separator).() -> Unit): Separator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Separator(orientation)
    child.configuration()
    return child
}

/**
 * Add a [Separator] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.separator(orientation: Orientation = HORIZONTAL,
        configuration: (@KtfxLayoutDslMarker Separator).() -> Unit): Separator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Separator(orientation)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Separator].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledSeparator(
    orientation: Orientation = HORIZONTAL,
    vararg styleClass: String,
    id: String? = null,
): Separator = styledSeparator(orientation = orientation, styleClass = styleClass, id = id) { }

/**
 * Add a styled [Separator] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledSeparator(
    orientation: Orientation = HORIZONTAL,
    vararg styleClass: String,
    id: String? = null,
): Separator = styledSeparator(orientation = orientation, styleClass = styleClass, id = id) { }

/**
 * Create a styled [Separator] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledSeparator(
    orientation: Orientation = HORIZONTAL,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Separator).() -> Unit,
): Separator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Separator(orientation)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Separator] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledSeparator(
    orientation: Orientation = HORIZONTAL,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Separator).() -> Unit,
): Separator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Separator(orientation)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
