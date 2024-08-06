@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.controlsfx.layouts

import javafx.scene.Node
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
import org.controlsfx.control.InfoOverlay

/**
 * Add an [InfoOverlay] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.infoOverlay(content: Node? = null, text: String? = null): InfoOverlay =
        infoOverlay(content = content, text = text) { }

/**
 * Create an [InfoOverlay] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun infoOverlay(
    content: Node? = null,
    text: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxInfoOverlay).() -> Unit,
): InfoOverlay {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxInfoOverlay(content, text)
    child.configuration()
    return child
}

/**
 * Add an [InfoOverlay] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.infoOverlay(
    content: Node? = null,
    text: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxInfoOverlay).() -> Unit,
): InfoOverlay {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxInfoOverlay(content, text)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [InfoOverlay].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledInfoOverlay(
    content: Node? = null,
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): InfoOverlay = styledInfoOverlay(content = content, text = text, styleClass = *styleClass, id =
        id) { }

/**
 * Add a styled [InfoOverlay] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledInfoOverlay(
    content: Node? = null,
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): InfoOverlay = styledInfoOverlay(content = content, text = text, styleClass = *styleClass, id =
        id) { }

/**
 * Create a styled [InfoOverlay] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledInfoOverlay(
    content: Node? = null,
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxInfoOverlay).() -> Unit,
): InfoOverlay {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxInfoOverlay(content, text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [InfoOverlay] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledInfoOverlay(
    content: Node? = null,
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxInfoOverlay).() -> Unit,
): InfoOverlay {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxInfoOverlay(content, text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
