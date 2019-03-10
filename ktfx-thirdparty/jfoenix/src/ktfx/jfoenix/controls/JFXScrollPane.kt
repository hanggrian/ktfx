@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXScrollPane
import javafx.scene.Node
import ktfx.layouts.LayoutMarker
import ktfx.layouts.NodeManager

open class _JFXScrollPane : JFXScrollPane(), NodeManager {

    override fun <R : Node> R.add(): R = also { content = it }

    val collection: MutableCollection<Node> = mutableListOf()

    fun topBar(init: (@LayoutMarker NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.add(): R = also { collection += it }
        }.apply(init)
        topBar.children.addAll(collection)
    }

    fun midBar(init: (@LayoutMarker NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.add(): R = also { collection += it }
        }.apply(init)
        midBar.children.addAll(collection)
    }

    fun bottomBar(init: (@LayoutMarker NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.add(): R = also { collection += it }
        }.apply(init)
        bottomBar.children.addAll(collection)
    }

    fun mainHeader(init: (@LayoutMarker NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.add(): R = also { collection += it }
        }.apply(init)
        mainHeader.children.addAll(collection)
    }

    fun condensedHeader(init: (@LayoutMarker NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.add(): R = also { collection += it }
        }.apply(init)
        condensedHeader.children.addAll(collection)
    }
}

/** Creates a [JFXScrollPane]. */
fun jfxScrollPane(
    init: ((@LayoutMarker _JFXScrollPane).() -> Unit)? = null
): JFXScrollPane = _JFXScrollPane().also { init?.invoke(it) }

/** Creates a [JFXScrollPane] and add it to this manager. */
inline fun NodeManager.jfxScrollPane(
    noinline init: ((@LayoutMarker _JFXScrollPane).() -> Unit)? = null
): JFXScrollPane = ktfx.jfoenix.jfxScrollPane(init).add()