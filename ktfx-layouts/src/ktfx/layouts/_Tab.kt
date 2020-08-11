@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Tab] to this manager.
 *
 * @return the control added.
 */
fun TabManager.tab(text: String? = null, content: Node? = null): Tab = tab(
    text = text,
    content =
        content
) { }

/**
 * Create a [Tab] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
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
 * @param configuration the configuration block.
 *
 * @return the control added.
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
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledTab(
    text: String? = null,
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null
): Tab = styledTab(text = text, content = content, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Tab] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun TabManager.styledTab(
    text: String? = null,
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null
): Tab = styledTab(text = text, content = content, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Tab] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledTab(
    text: String? = null,
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxTab).() -> Unit
): Tab {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxTab(text, content), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [Tab] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun TabManager.styledTab(
    text: String? = null,
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxTab).() -> Unit
): Tab {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxTab(text, content), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}
