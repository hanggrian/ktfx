@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXScrollPane
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

open class _JFXScrollPane : JFXScrollPane(), NodeManager {

    override fun <R : Node> R.add(): R = also { content = it }

    val collection: MutableCollection<Node> = mutableListOf()

    fun topBar(init: (@LayoutDslMarker NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.add(): R = also { collection += it }
        }.apply(init)
        topBar.children.addAll(collection)
    }

    fun midBar(init: (@LayoutDslMarker NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.add(): R = also { collection += it }
        }.apply(init)
        midBar.children.addAll(collection)
    }

    fun bottomBar(init: (@LayoutDslMarker NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.add(): R = also { collection += it }
        }.apply(init)
        bottomBar.children.addAll(collection)
    }

    fun mainHeader(init: (@LayoutDslMarker NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.add(): R = also { collection += it }
        }.apply(init)
        mainHeader.children.addAll(collection)
    }

    fun condensedHeader(init: (@LayoutDslMarker NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.add(): R = also { collection += it }
        }.apply(init)
        condensedHeader.children.addAll(collection)
    }
}

/** Add a [JFXScrollPane] to this manager. */
fun NodeManager.jfxScrollPane(): JFXScrollPane =
    _JFXScrollPane().add()

/** Add a [JFXScrollPane] with initialization to this manager. */
inline fun NodeManager.jfxScrollPane(
    init: (@LayoutDslMarker _JFXScrollPane).() -> Unit
): JFXScrollPane = (jfxScrollPane() as _JFXScrollPane).apply(init)