@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.control.CheckBox
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [CheckBox] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.checkBox(text: String? = null): CheckBox = checkBox(text = text) { }

/**
 * Create a [CheckBox] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun checkBox(text: String? = null, configuration: (@KtfxLayoutDslMarker
        CheckBox).() -> Unit): CheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckBox(text)
    child.configuration()
    return child
}

/**
 * Add a [CheckBox] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.checkBox(text: String? = null, configuration: (@KtfxLayoutDslMarker
        CheckBox).() -> Unit): CheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckBox(text)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [CheckBox].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): CheckBox = styledCheckBox(text = text, styleClass = styleClass, id = id) { }

/**
 * Add a styled [CheckBox] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): CheckBox = styledCheckBox(text = text, styleClass = styleClass, id = id) { }

/**
 * Create a styled [CheckBox] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CheckBox).() -> Unit,
): CheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckBox(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [CheckBox] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CheckBox).() -> Unit,
): CheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckBox(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
