@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.InfoOverlay

/**
 * Add an [InfoOverlay] to this manager.
 */
fun NodeManager.infoOverlay(content: Node? = null, text: String? = null): InfoOverlay =
        infoOverlay(content = content, text = text) { }

/**
 * Create an [InfoOverlay] with configuration block.
 */
inline fun infoOverlay(
    content: Node? = null,
    text: String? = null,
    configuration: (@LayoutDslMarker KtfxInfoOverlay).() -> Unit
): InfoOverlay {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxInfoOverlay(content, text), configuration = configuration)
}

/**
 * Add an [InfoOverlay] with configuration block to this manager.
 */
inline fun NodeManager.infoOverlay(
    content: Node? = null,
    text: String? = null,
    configuration: (@LayoutDslMarker KtfxInfoOverlay).() -> Unit
): InfoOverlay {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxInfoOverlay(content, text), configuration = configuration))
}

/**
 * Create a styled [InfoOverlay].
 */
fun styledInfoOverlay(
    content: Node? = null,
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): InfoOverlay = styledInfoOverlay(content = content, text = text, styleClass = *styleClass, id =
        id) { }

/**
 * Add a styled [InfoOverlay] to this manager.
 */
fun NodeManager.styledInfoOverlay(
    content: Node? = null,
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): InfoOverlay = styledInfoOverlay(content = content, text = text, styleClass = *styleClass, id =
        id) { }

/**
 * Create a styled [InfoOverlay] with configuration block.
 */
inline fun styledInfoOverlay(
    content: Node? = null,
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxInfoOverlay).() -> Unit
): InfoOverlay {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxInfoOverlay(content, text), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [InfoOverlay] with configuration block to this manager.
 */
inline fun NodeManager.styledInfoOverlay(
    content: Node? = null,
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxInfoOverlay).() -> Unit
): InfoOverlay {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxInfoOverlay(content, text), styleClass = *styleClass, id = id,
            configuration = configuration))
}
