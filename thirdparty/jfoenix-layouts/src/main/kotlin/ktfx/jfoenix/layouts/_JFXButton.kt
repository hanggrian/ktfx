@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXButton
import javafx.scene.Node
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
 * Add a [JFXButton] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.jfxButton(text: String? = null, graphic: Node? = null): JFXButton =
        jfxButton(text = text, graphic = graphic) { }

/**
 * Create a [JFXButton] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun jfxButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker JFXButton).() -> Unit,
): JFXButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXButton(text, graphic)
    child.configuration()
    return child
}

/**
 * Add a [JFXButton] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker JFXButton).() -> Unit,
): JFXButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXButton(text, graphic)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXButton].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledJFXButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXButton = styledJFXButton(text = text, graphic = graphic, styleClass = *styleClass, id = id) {
        }

/**
 * Add a styled [JFXButton] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledJFXButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXButton = styledJFXButton(text = text, graphic = graphic, styleClass = *styleClass, id = id) {
        }

/**
 * Create a styled [JFXButton] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledJFXButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXButton).() -> Unit,
): JFXButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXButton(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXButton] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJFXButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXButton).() -> Unit,
): JFXButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXButton(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
