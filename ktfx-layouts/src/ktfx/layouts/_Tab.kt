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
fun TabManager.tab(text: String, content: Node): Tab = tab(text = text, content = content) { }

/**
 * Create a [Tab] with configuration block.
 */
inline fun tab(
    text: String,
    content: Node,
    configuration: (@LayoutDslMarker KtfxTab).() -> Unit
): Tab {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxTab(text, content), configuration = configuration)
}

/**
 * Add a [Tab] with configuration block to this manager.
 */
inline fun TabManager.tab(
    text: String,
    content: Node,
    configuration: (@LayoutDslMarker KtfxTab).() -> Unit
): Tab {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxTab(text, content), configuration = configuration))
}

/**
 * Create a styled [Tab].
 */
fun styledTab(
    text: String,
    content: Node,
    vararg styleClass: String
): Tab = styledTab(text = text, content = content, styleClass = *styleClass) { }

/**
 * Add a styled [Tab] to this manager.
 */
fun TabManager.styledTab(
    text: String,
    content: Node,
    vararg styleClass: String
): Tab = styledTab(text = text, content = content, styleClass = *styleClass) { }

/**
 * Create a styled [Tab] with configuration block.
 */
inline fun styledTab(
    text: String,
    content: Node,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker KtfxTab).() -> Unit
): Tab {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxTab(text, content), styleClass = *styleClass, configuration = configuration)
}

/**
 * Add a styled [Tab] with configuration block to this manager.
 */
inline fun TabManager.styledTab(
    text: String,
    content: Node,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker KtfxTab).() -> Unit
): Tab {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxTab(text, content), styleClass = *styleClass, configuration =
            configuration))
}
