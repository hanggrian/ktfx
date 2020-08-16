@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.InfoOverlay
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add an [InfoOverlay] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.infoOverlay(content: Node? = null, text: String? = null): InfoOverlay =
    infoOverlay(content = content, text = text) { }

/**
 * Create an [InfoOverlay] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun infoOverlay(
    content: Node? = null,
    text: String? = null,
    configuration: (@LayoutDslMarker KtfxInfoOverlay).() -> Unit
): InfoOverlay {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxInfoOverlay(content, text)
    child.configuration()
    return child
}

/**
 * Add an [InfoOverlay] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.infoOverlay(
    content: Node? = null,
    text: String? = null,
    configuration: (@LayoutDslMarker KtfxInfoOverlay).() -> Unit
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
fun styledInfoOverlay(
    content: Node? = null,
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): InfoOverlay = styledInfoOverlay(
    content = content, text = text, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Add a styled [InfoOverlay] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledInfoOverlay(
    content: Node? = null,
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): InfoOverlay = styledInfoOverlay(
    content = content, text = text, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Create a styled [InfoOverlay] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledInfoOverlay(
    content: Node? = null,
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxInfoOverlay).() -> Unit
): InfoOverlay {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxInfoOverlay(content, text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [InfoOverlay] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledInfoOverlay(
    content: Node? = null,
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxInfoOverlay).() -> Unit
): InfoOverlay {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxInfoOverlay(content, text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
