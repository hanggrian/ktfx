@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXScrollPane
import javafx.scene.Node
import ktfx.LayoutDsl
import ktfx.NodeManager

open class _JFXScrollPane : JFXScrollPane() {

    val collection: MutableCollection<Node> = mutableListOf()

    fun topBar(init: (@LayoutDsl NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.invoke(): R = also { collection += it }
        }.apply(init)
        topBar.children.addAll(collection)
    }

    fun midBar(init: (@LayoutDsl NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.invoke(): R = also { collection += it }
        }.apply(init)
        midBar.children.addAll(collection)
    }

    fun bottomBar(init: (@LayoutDsl NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.invoke(): R = also { collection += it }
        }.apply(init)
        bottomBar.children.addAll(collection)
    }

    fun mainHeader(init: (@LayoutDsl NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.invoke(): R = also { collection += it }
        }.apply(init)
        mainHeader.children.addAll(collection)
    }

    fun condensedHeader(init: (@LayoutDsl NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.invoke(): R = also { collection += it }
        }.apply(init)
        condensedHeader.children.addAll(collection)
    }
}

/** Creates a [JFXScrollPane]. */
fun jfxScrollPane(
    init: ((@LayoutDsl _JFXScrollPane).() -> Unit)? = null
): JFXScrollPane = _JFXScrollPane().also { init?.invoke(it) }

/** Creates a [JFXScrollPane] and add it to this manager. */
inline fun NodeManager.jfxScrollPane(
    noinline init: ((@LayoutDsl _JFXScrollPane).() -> Unit)? = null
): JFXScrollPane = ktfx.jfoenix.jfxScrollPane(init)()