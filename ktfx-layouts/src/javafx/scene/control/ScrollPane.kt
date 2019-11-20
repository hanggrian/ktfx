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

    final override fun <T : Node> addNode(node: T): T =
        node.also { content = it }
}

/** Create a [ScrollPane] with initialization block. */
inline fun scrollPane(
    content: Node? = null,
    init: (@KtfxLayoutsDslMarker KtfxScrollPane).() -> Unit
): ScrollPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxScrollPane(content).apply(init)
}

/** Add a [ScrollPane] to this manager. */
fun NodeManager.scrollPane(
    content: Node? = null
): ScrollPane = addNode(KtfxScrollPane(content))

/** Add a [ScrollPane] with initialization block to this manager. */
inline fun NodeManager.scrollPane(
    content: Node? = null,
    init: (@KtfxLayoutsDslMarker KtfxScrollPane).() -> Unit
): ScrollPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxScrollPane(content), init)
}
