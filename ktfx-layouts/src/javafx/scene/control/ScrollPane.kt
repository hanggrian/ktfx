@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [ScrollPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxScrollPane(content: Node?) : ScrollPane(content), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content = it }

    final override val childCount: Int get() = if (content != null) 1 else 0
}

/** Create a [ScrollPane] with initialization block. */
inline fun scrollPane(
    content: Node? = null,
    init: (@LayoutsDslMarker KtfxScrollPane).() -> Unit
): ScrollPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxScrollPane(content).apply(init)
}

/** Add a [ScrollPane] to this manager. */
fun NodeManager.scrollPane(
    content: Node? = null
): ScrollPane = addChild(KtfxScrollPane(content))

/** Add a [ScrollPane] with initialization block to this manager. */
inline fun NodeManager.scrollPane(
    content: Node? = null,
    init: (@LayoutsDslMarker KtfxScrollPane).() -> Unit
): ScrollPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxScrollPane(content), init)
}
