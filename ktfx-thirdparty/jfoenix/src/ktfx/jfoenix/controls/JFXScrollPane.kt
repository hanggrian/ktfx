@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXScrollPane
import javafx.scene.Node
import ktfx.layouts.LayoutMarker
import ktfx.layouts.NodeInvokable

open class _JFXScrollPane : JFXScrollPane(), NodeInvokable {

    override fun <R : Node> R.invoke(): R = also { content = it }

    val collection: MutableCollection<Node> = mutableListOf()

    fun topBar(init: (@LayoutMarker NodeInvokable).() -> Unit) {
        collection.clear()
        object : NodeInvokable {
            override fun <R : Node> R.invoke(): R = also { collection += it }
        }.apply(init)
        topBar.children.addAll(collection)
    }

    fun midBar(init: (@LayoutMarker NodeInvokable).() -> Unit) {
        collection.clear()
        object : NodeInvokable {
            override fun <R : Node> R.invoke(): R = also { collection += it }
        }.apply(init)
        midBar.children.addAll(collection)
    }

    fun bottomBar(init: (@LayoutMarker NodeInvokable).() -> Unit) {
        collection.clear()
        object : NodeInvokable {
            override fun <R : Node> R.invoke(): R = also { collection += it }
        }.apply(init)
        bottomBar.children.addAll(collection)
    }

    fun mainHeader(init: (@LayoutMarker NodeInvokable).() -> Unit) {
        collection.clear()
        object : NodeInvokable {
            override fun <R : Node> R.invoke(): R = also { collection += it }
        }.apply(init)
        mainHeader.children.addAll(collection)
    }

    fun condensedHeader(init: (@LayoutMarker NodeInvokable).() -> Unit) {
        collection.clear()
        object : NodeInvokable {
            override fun <R : Node> R.invoke(): R = also { collection += it }
        }.apply(init)
        condensedHeader.children.addAll(collection)
    }
}

/** Creates a [JFXScrollPane]. */
fun jfxScrollPane(
    init: ((@LayoutMarker _JFXScrollPane).() -> Unit)? = null
): JFXScrollPane = _JFXScrollPane().also { init?.invoke(it) }

/** Creates a [JFXScrollPane] and add it to this manager. */
inline fun NodeInvokable.jfxScrollPane(
    noinline init: ((@LayoutMarker _JFXScrollPane).() -> Unit)? = null
): JFXScrollPane = ktfx.jfoenix.jfxScrollPane(init)()