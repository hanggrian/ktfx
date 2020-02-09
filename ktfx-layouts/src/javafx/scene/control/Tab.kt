@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [Tab] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxTab(title: String?, content: Node?) : Tab(title, content), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content = it }
}

/** Create a [Tab] with configurationialization block. */
inline fun tab(
    text: String? = null,
    content: Node? = null,
    configuration: (@LayoutDslMarker KtfxTab).() -> Unit
): Tab {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxTab(text, content).apply(configuration)
}

/** Add a [Tab] to this manager. */
fun TabManager.tab(
    text: String? = null,
    content: Node? = null
): Tab = addChild(KtfxTab(text, content))

/** Add a [Tab] with configurationialization block to this manager. */
inline fun TabManager.tab(
    text: String? = null,
    content: Node? = null,
    configuration: (@LayoutDslMarker KtfxTab).() -> Unit
): Tab {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxTab(text, content), configuration)
}
