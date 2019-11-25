@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXScrollPane
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/**
 * [JFXScrollPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxJFXScrollPane : JFXScrollPane(), NodeManager {

    final override fun <T : Node> addNode(node: T): T = node.also { content = it }

    fun topBar(init: (@LayoutsDslMarker NodeManager).() -> Unit) {
        topBar.children.addAll(NodeManagerImpl().apply(init))
    }

    fun midBar(init: (@LayoutsDslMarker NodeManager).() -> Unit) {
        midBar.children.addAll(NodeManagerImpl().apply(init))
    }

    fun bottomBar(init: (@LayoutsDslMarker NodeManager).() -> Unit) {
        bottomBar.children.addAll(NodeManagerImpl().apply(init))
    }

    fun mainHeader(init: (@LayoutsDslMarker NodeManager).() -> Unit) {
        mainHeader.children.addAll(NodeManagerImpl().apply(init))
    }

    fun condensedHeader(init: (@LayoutsDslMarker NodeManager).() -> Unit) {
        condensedHeader.children.addAll(NodeManagerImpl().apply(init))
    }

    private class NodeManagerImpl : NodeManager, MutableList<Node> by mutableListOf() {
        override fun <T : Node> addNode(node: T): T = node.also { this += it }
    }
}

/** Create a [JFXScrollPane] with initialization block. */
inline fun jfxScrollPane(
    init: (@LayoutsDslMarker KtfxJFXScrollPane).() -> Unit
): JFXScrollPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXScrollPane().apply(init)
}

/** Add a [JFXScrollPane] to this manager. */
fun NodeManager.jfxScrollPane(): JFXScrollPane =
    addNode(KtfxJFXScrollPane())

/** Add a [JFXScrollPane] with initialization block to this manager. */
inline fun NodeManager.jfxScrollPane(
    init: (@LayoutsDslMarker KtfxJFXScrollPane).() -> Unit
): JFXScrollPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxJFXScrollPane(), init)
}
