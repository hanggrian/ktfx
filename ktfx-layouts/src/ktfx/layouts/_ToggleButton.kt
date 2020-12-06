@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ToggleButton] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.toggleButton(text: String? = null, graphic: Node? = null): ToggleButton =
    toggleButton(text = text, graphic = graphic) { }

/**
 * Add a [ToggleButton] to this manager.
 *
 * @return the control added.
 */
public fun ToggleButtonManager.toggleButton(text: String? = null, graphic: Node? = null):
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
    configuration: (@KtfxLayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleButton(text, graphic)
    child.configuration()
    return child
}

/**
 * Add a [ToggleButton] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeManager.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleButton(text, graphic)
    child.configuration()
    return addChild(child)
}

/**
 * Add a [ToggleButton] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun ToggleButtonManager.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker ToggleButton).() -> Unit
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
public fun styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): ToggleButton = styledToggleButton(
    text = text, graphic = graphic, styleClass = *styleClass,
    id =
    id
) { }

/**
 * Add a styled [ToggleButton] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeManager.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): ToggleButton = styledToggleButton(
    text = text, graphic = graphic, styleClass = *styleClass,
    id =
    id
) { }

/**
 * Add a styled [ToggleButton] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun ToggleButtonManager.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): ToggleButton = styledToggleButton(
    text = text, graphic = graphic, styleClass = *styleClass,
    id =
    id
) { }

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
    configuration: (@KtfxLayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleButton(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ToggleButton] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeManager.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleButton(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

/**
 * Add a styled [ToggleButton] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun ToggleButtonManager.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleButton(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
