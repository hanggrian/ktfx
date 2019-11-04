@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXScrollPane
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

open class KtfxJFXScrollPane : JFXScrollPane(), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { content = it }

    val collection: MutableCollection<Node> = mutableListOf()

    fun topBar(init: (@LayoutDslMarker NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <T : Node> addNode(node: T): T = node.also { collection += it }
        }.apply(init)
        topBar.children.addAll(collection)
    }

    fun midBar(init: (@LayoutDslMarker NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <T : Node> addNode(node: T): T = node.also { collection += it }
        }.apply(init)
        midBar.children.addAll(collection)
    }

    fun bottomBar(init: (@LayoutDslMarker NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <T : Node> addNode(node: T): T = node.also { collection += it }
        }.apply(init)
        bottomBar.children.addAll(collection)
    }

    fun mainHeader(init: (@LayoutDslMarker NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <T : Node> addNode(node: T): T = node.also { collection += it }
        }.apply(init)
        mainHeader.children.addAll(collection)
    }

    fun condensedHeader(init: (@LayoutDslMarker NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <T : Node> addNode(node: T): T = node.also { collection += it }
        }.apply(init)
        condensedHeader.children.addAll(collection)
    }
}

/** Create a [JFXScrollPane] with initialization block. */
inline fun jfxScrollPane(
    init: (@LayoutDslMarker KtfxJFXScrollPane).() -> Unit
): JFXScrollPane {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return KtfxJFXScrollPane().apply(init)
}
/** Add a [JFXScrollPane] to this manager. */
fun NodeManager.jfxScrollPane(): JFXScrollPane =
    addNode(KtfxJFXScrollPane())

/** Add a [JFXScrollPane] with initialization block to this manager. */
inline fun NodeManager.jfxScrollPane(
    init: (@LayoutDslMarker KtfxJFXScrollPane).() -> Unit
): JFXScrollPane {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(KtfxJFXScrollPane(), init)
}
