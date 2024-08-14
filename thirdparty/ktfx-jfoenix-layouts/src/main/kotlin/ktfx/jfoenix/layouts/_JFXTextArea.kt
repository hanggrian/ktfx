@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTextArea
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer

/**
 * Add a [JFXTextArea] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxTextArea(text: String = ""): JFXTextArea = jfxTextArea(text =
        text) { }

/**
 * Create a [JFXTextArea] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun jfxTextArea(text: String = "", configuration: (@KtfxLayoutDslMarker
        JFXTextArea).() -> Unit): JFXTextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextArea(text)
    child.configuration()
    return child
}

/**
 * Add a [JFXTextArea] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.jfxTextArea(text: String = "", configuration: (@KtfxLayoutDslMarker
        JFXTextArea).() -> Unit): JFXTextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextArea(text)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXTextArea].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledJfxTextArea(
    text: String = "",
    vararg styleClass: String,
    id: String? = null,
): JFXTextArea = styledJfxTextArea(text = text, styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXTextArea] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJfxTextArea(
    text: String = "",
    vararg styleClass: String,
    id: String? = null,
): JFXTextArea = styledJfxTextArea(text = text, styleClass = styleClass, id = id) { }

/**
 * Create a styled [JFXTextArea] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledJfxTextArea(
    text: String = "",
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTextArea).() -> Unit,
): JFXTextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextArea(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXTextArea] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledJfxTextArea(
    text: String = "",
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTextArea).() -> Unit,
): JFXTextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextArea(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
