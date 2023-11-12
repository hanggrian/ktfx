@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.control.TextField
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [TextField] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.textField(text: String = ""): TextField = textField(text = text) { }

/**
 * Create a [TextField] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun textField(text: String = "", configuration: (@KtfxLayoutDslMarker
        TextField).() -> Unit): TextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TextField(text)
    child.configuration()
    return child
}

/**
 * Add a [TextField] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.textField(text: String = "", configuration: (@KtfxLayoutDslMarker
        TextField).() -> Unit): TextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TextField(text)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [TextField].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledTextField(
    text: String = "",
    vararg styleClass: String,
    id: String? = null,
): TextField = styledTextField(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [TextField] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledTextField(
    text: String = "",
    vararg styleClass: String,
    id: String? = null,
): TextField = styledTextField(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [TextField] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledTextField(
    text: String = "",
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker TextField).() -> Unit,
): TextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TextField(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [TextField] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledTextField(
    text: String = "",
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker TextField).() -> Unit,
): TextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TextField(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
