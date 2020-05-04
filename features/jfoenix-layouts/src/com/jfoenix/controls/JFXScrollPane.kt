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

@PublishedApi
internal class NodeManagerImpl : NodeManager {
    val children: MutableList<Node> = mutableListOf()

    override fun <C : Node> addChild(child: C): C = child.also { children += it }
}

inline fun JFXScrollPane.topBar(configuration: (@LayoutDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    topBar.children.addAll(NodeManagerImpl().apply(configuration).children)
}

inline fun JFXScrollPane.midBar(configuration: (@LayoutDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    midBar.children.addAll(NodeManagerImpl().apply(configuration).children)
}

inline fun JFXScrollPane.bottomBar(configuration: (@LayoutDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    bottomBar.children.addAll(NodeManagerImpl().apply(configuration).children)
}

inline fun JFXScrollPane.mainHeader(configuration: (@LayoutDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    mainHeader.children.addAll(NodeManagerImpl().apply(configuration).children)
}

inline fun JFXScrollPane.condensedHeader(configuration: (@LayoutDslMarker NodeManager).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    condensedHeader.children.addAll(NodeManagerImpl().apply(configuration).children)
}
