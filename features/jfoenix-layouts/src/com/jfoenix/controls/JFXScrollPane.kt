@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXScrollPane
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/**
 * [JFXScrollPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxJFXScrollPane : JFXScrollPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content = it }
}

@PublishedApi
internal class NodeManagerImpl : NodeManager, MutableList<Node> by mutableListOf() {
    override fun <C : Node> addChild(child: C): C = child.also { this += it }
}

inline fun KtfxJFXScrollPane.topBar(configuration: (@LayoutDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    topBar.children.addAll(NodeManagerImpl().apply(configuration))
}

inline fun KtfxJFXScrollPane.midBar(configuration: (@LayoutDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    midBar.children.addAll(NodeManagerImpl().apply(configuration))
}

inline fun KtfxJFXScrollPane.bottomBar(configuration: (@LayoutDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    bottomBar.children.addAll(NodeManagerImpl().apply(configuration))
}

inline fun KtfxJFXScrollPane.mainHeader(configuration: (@LayoutDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    mainHeader.children.addAll(NodeManagerImpl().apply(configuration))
}

inline fun KtfxJFXScrollPane.condensedHeader(configuration: (@LayoutDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    condensedHeader.children.addAll(NodeManagerImpl().apply(configuration))
}

/** Create a [JFXScrollPane] with configuration block. */
inline fun jfxScrollPane(
    configuration: (@LayoutDslMarker KtfxJFXScrollPane).() -> Unit
): JFXScrollPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXScrollPane().apply(configuration)
}

/** Add a [JFXScrollPane] to this manager. */
fun NodeManager.jfxScrollPane(): JFXScrollPane =
    addChild(KtfxJFXScrollPane())

/** Add a [JFXScrollPane] with configuration block to this manager. */
inline fun NodeManager.jfxScrollPane(
    configuration: (@LayoutDslMarker KtfxJFXScrollPane).() -> Unit
): JFXScrollPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxJFXScrollPane(), configuration)
}
