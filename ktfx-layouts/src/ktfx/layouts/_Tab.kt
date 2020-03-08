@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Tab] to this manager.
 */
fun TabManager.tab(text: String? = null, content: Node? = null): Tab = tab(text = text, content =
        content) { }

/**
 * Create a [Tab] with configuration block.
 */
inline fun tab(
    text: String? = null,
    content: Node? = null,
    configuration: (@LayoutDslMarker KtfxTab).() -> Unit
): Tab {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxTab(text, content), configuration = configuration)
}

/**
 * Add a [Tab] with configuration block to this manager.
 */
inline fun TabManager.tab(
    text: String? = null,
    content: Node? = null,
    configuration: (@LayoutDslMarker KtfxTab).() -> Unit
): Tab {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxTab(text, content), configuration = configuration))
}

/**
 * Create a styled [Tab].
 */
fun styledTab(
    text: String? = null,
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null
): Tab = styledTab(text = text, content = content, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Tab] to this manager.
 */
fun TabManager.styledTab(
    text: String? = null,
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null
): Tab = styledTab(text = text, content = content, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Tab] with configuration block.
 */
inline fun styledTab(
    text: String? = null,
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxTab).() -> Unit
): Tab {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxTab(text, content), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [Tab] with configuration block to this manager.
 */
inline fun TabManager.styledTab(
    text: String? = null,
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxTab).() -> Unit
): Tab {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxTab(text, content), styleClass = *styleClass, id = id,
            configuration = configuration))
}
