@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Label
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Label] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.label(text: String? = null, graphic: Node? = null): Label = label(text =
        text, graphic = graphic) { }

/**
 * Create a [Label] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun label(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker Label).() -> Unit,
): Label {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Label(text, graphic)
    child.configuration()
    return child
}

/**
 * Add a [Label] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.label(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker Label).() -> Unit,
): Label {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Label(text, graphic)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Label].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledLabel(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): Label = styledLabel(text = text, graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Label] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledLabel(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): Label = styledLabel(text = text, graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Label] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledLabel(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Label).() -> Unit,
): Label {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Label(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Label] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledLabel(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Label).() -> Unit,
): Label {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Label(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
