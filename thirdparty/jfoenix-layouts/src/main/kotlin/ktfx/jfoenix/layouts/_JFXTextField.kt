@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTextField
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer

/**
 * Add a [JFXTextField] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.jfxTextField(text: String? = null): JFXTextField = jfxTextField(text =
        text) { }

/**
 * Create a [JFXTextField] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun jfxTextField(text: String? = null, configuration: (@KtfxLayoutDslMarker
        JFXTextField).() -> Unit): JFXTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextField(text)
    child.configuration()
    return child
}

/**
 * Add a [JFXTextField] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxTextField(text: String? = null,
        configuration: (@KtfxLayoutDslMarker JFXTextField).() -> Unit): JFXTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextField(text)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXTextField].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledJFXTextField(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXTextField = styledJFXTextField(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXTextField] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledJFXTextField(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXTextField = styledJFXTextField(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXTextField] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledJFXTextField(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTextField).() -> Unit,
): JFXTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextField(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXTextField] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJFXTextField(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTextField).() -> Unit,
): JFXTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextField(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
