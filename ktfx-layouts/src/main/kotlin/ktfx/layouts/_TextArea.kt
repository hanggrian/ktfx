@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.control.TextArea
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [TextArea] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.textArea(text: String = ""): TextArea = textArea(text = text) { }

/**
 * Create a [TextArea] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun textArea(text: String = "", configuration: (@KtfxLayoutDslMarker TextArea).() -> Unit):
        TextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TextArea(text)
    child.configuration()
    return child
}

/**
 * Add a [TextArea] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.textArea(text: String = "", configuration: (@KtfxLayoutDslMarker
        TextArea).() -> Unit): TextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TextArea(text)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [TextArea].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledTextArea(
    text: String = "",
    vararg styleClass: String,
    id: String? = null,
): TextArea = styledTextArea(text = text, styleClass = styleClass, id = id) { }

/**
 * Add a styled [TextArea] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledTextArea(
    text: String = "",
    vararg styleClass: String,
    id: String? = null,
): TextArea = styledTextArea(text = text, styleClass = styleClass, id = id) { }

/**
 * Create a styled [TextArea] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledTextArea(
    text: String = "",
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker TextArea).() -> Unit,
): TextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TextArea(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [TextArea] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledTextArea(
    text: String = "",
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker TextArea).() -> Unit,
): TextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TextArea(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
