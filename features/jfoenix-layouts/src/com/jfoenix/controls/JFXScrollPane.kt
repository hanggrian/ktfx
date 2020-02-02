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
import ktfx.layouts.addChild

/**
 * [JFXScrollPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxJFXScrollPane : JFXScrollPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content = it }

    final override val childCount: Int get() = if (content != null) 1 else 0
}

@PublishedApi
internal class NodeManagerImpl : NodeManager, MutableList<Node> by mutableListOf() {
    override fun <C : Node> addChild(child: C): C = child.also { this += it }
    override val childCount: Int get() = size
}

inline fun KtfxJFXScrollPane.topBar(init: (@LayoutsDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    topBar.children.addAll(NodeManagerImpl().apply(init))
}

inline fun KtfxJFXScrollPane.midBar(init: (@LayoutsDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    midBar.children.addAll(NodeManagerImpl().apply(init))
}

inline fun KtfxJFXScrollPane.bottomBar(init: (@LayoutsDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    bottomBar.children.addAll(NodeManagerImpl().apply(init))
}

inline fun KtfxJFXScrollPane.mainHeader(init: (@LayoutsDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    mainHeader.children.addAll(NodeManagerImpl().apply(init))
}

inline fun KtfxJFXScrollPane.condensedHeader(init: (@LayoutsDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    condensedHeader.children.addAll(NodeManagerImpl().apply(init))
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
    addChild(KtfxJFXScrollPane())

/** Add a [JFXScrollPane] with initialization block to this manager. */
inline fun NodeManager.jfxScrollPane(
    init: (@LayoutsDslMarker KtfxJFXScrollPane).() -> Unit
): JFXScrollPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxJFXScrollPane(), init)
}
