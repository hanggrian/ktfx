@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ColorPicker] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.colorPicker(color: Color = WHITE): ColorPicker = colorPicker(color =
        color) { }

/**
 * Create a [ColorPicker] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun colorPicker(color: Color = WHITE, configuration: (@KtfxLayoutDslMarker
        ColorPicker).() -> Unit): ColorPicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ColorPicker(color)
    child.configuration()
    return child
}

/**
 * Add a [ColorPicker] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.colorPicker(color: Color = WHITE,
        configuration: (@KtfxLayoutDslMarker ColorPicker).() -> Unit): ColorPicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ColorPicker(color)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [ColorPicker].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledColorPicker(
    color: Color = WHITE,
    vararg styleClass: String,
    id: String? = null,
): ColorPicker = styledColorPicker(color = color, styleClass = styleClass, id = id) { }

/**
 * Add a styled [ColorPicker] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledColorPicker(
    color: Color = WHITE,
    vararg styleClass: String,
    id: String? = null,
): ColorPicker = styledColorPicker(color = color, styleClass = styleClass, id = id) { }

/**
 * Create a styled [ColorPicker] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledColorPicker(
    color: Color = WHITE,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ColorPicker).() -> Unit,
): ColorPicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ColorPicker(color)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ColorPicker] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledColorPicker(
    color: Color = WHITE,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ColorPicker).() -> Unit,
): ColorPicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ColorPicker(color)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
