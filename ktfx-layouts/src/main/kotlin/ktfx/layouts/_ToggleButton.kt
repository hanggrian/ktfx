@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ToggleButton] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.toggleButton(text: String? = null, graphic: Node? = null):
        ToggleButton = toggleButton(text = text, graphic = graphic) { }

/**
 * Add a [ToggleButton] to this container.
 *
 * @return the control added.
 */
public inline fun ToggleButtonContainer.toggleButton(text: String? = null, graphic: Node? = null):
        ToggleButton = toggleButton(text = text, graphic = graphic) { }

/**
 * Create a [ToggleButton] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun toggleButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker ToggleButton).() -> Unit,
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleButton(text, graphic)
    child.configuration()
    return child
}

/**
 * Add a [ToggleButton] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker ToggleButton).() -> Unit,
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleButton(text, graphic)
    child.configuration()
    return addChild(child)
}

/**
 * Add a [ToggleButton] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun ToggleButtonContainer.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker ToggleButton).() -> Unit,
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleButton(text, graphic)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [ToggleButton].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): ToggleButton = styledToggleButton(text = text, graphic = graphic, styleClass = styleClass, id =
        id) { }

/**
 * Add a styled [ToggleButton] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): ToggleButton = styledToggleButton(text = text, graphic = graphic, styleClass = styleClass, id =
        id) { }

/**
 * Add a styled [ToggleButton] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun ToggleButtonContainer.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): ToggleButton = styledToggleButton(text = text, graphic = graphic, styleClass = styleClass, id =
        id) { }

/**
 * Create a styled [ToggleButton] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ToggleButton).() -> Unit,
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleButton(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ToggleButton] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ToggleButton).() -> Unit,
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleButton(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

/**
 * Add a styled [ToggleButton] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun ToggleButtonContainer.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ToggleButton).() -> Unit,
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleButton(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
