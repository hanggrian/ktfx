@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

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
