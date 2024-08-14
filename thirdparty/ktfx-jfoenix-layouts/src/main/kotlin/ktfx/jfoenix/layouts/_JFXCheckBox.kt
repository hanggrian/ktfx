@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXCheckBox
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
 * Add a [JFXCheckBox] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxCheckBox(text: String? = null): JFXCheckBox = jfxCheckBox(text =
        text) { }

/**
 * Create a [JFXCheckBox] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun jfxCheckBox(text: String? = null, configuration: (@KtfxLayoutDslMarker
        JFXCheckBox).() -> Unit): JFXCheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXCheckBox(text)
    child.configuration()
    return child
}

/**
 * Add a [JFXCheckBox] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.jfxCheckBox(text: String? = null, configuration: (@KtfxLayoutDslMarker
        JFXCheckBox).() -> Unit): JFXCheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXCheckBox(text)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXCheckBox].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledJfxCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXCheckBox = styledJfxCheckBox(text = text, styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXCheckBox] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJfxCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXCheckBox = styledJfxCheckBox(text = text, styleClass = styleClass, id = id) { }

/**
 * Create a styled [JFXCheckBox] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledJfxCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXCheckBox).() -> Unit,
): JFXCheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXCheckBox(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXCheckBox] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledJfxCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXCheckBox).() -> Unit,
): JFXCheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXCheckBox(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
