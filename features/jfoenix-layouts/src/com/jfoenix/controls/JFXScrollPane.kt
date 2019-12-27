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

inline fun KtfxJFXScrollPane.topBar(configuration: (@LayoutsDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    topBar.children.addAll(NodeManagerImpl().apply(configuration))
}

inline fun KtfxJFXScrollPane.midBar(configuration: (@LayoutsDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    midBar.children.addAll(NodeManagerImpl().apply(configuration))
}

inline fun KtfxJFXScrollPane.bottomBar(configuration: (@LayoutsDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    bottomBar.children.addAll(NodeManagerImpl().apply(configuration))
}

inline fun KtfxJFXScrollPane.mainHeader(configuration: (@LayoutsDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    mainHeader.children.addAll(NodeManagerImpl().apply(configuration))
}

inline fun KtfxJFXScrollPane.condensedHeader(configuration: (@LayoutsDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    condensedHeader.children.addAll(NodeManagerImpl().apply(configuration))
}

/** Create a [JFXScrollPane] with initialization block. */
inline fun jfxScrollPane(
    configuration: (@LayoutsDslMarker KtfxJFXScrollPane).() -> Unit
): JFXScrollPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXScrollPane().apply(configuration)
}

/** Add a [JFXScrollPane] to this manager. */
fun NodeManager.jfxScrollPane(): JFXScrollPane =
    addChild(KtfxJFXScrollPane())

/** Add a [JFXScrollPane] with initialization block to this manager. */
inline fun NodeManager.jfxScrollPane(
    configuration: (@LayoutsDslMarker KtfxJFXScrollPane).() -> Unit
): JFXScrollPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxJFXScrollPane(), configuration)
}
