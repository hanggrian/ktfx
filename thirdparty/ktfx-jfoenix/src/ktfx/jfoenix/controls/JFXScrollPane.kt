@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXScrollPane
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

open class _JFXScrollPane : JFXScrollPane() {

    fun topBar(init: (@LayoutDsl NodeManager).() -> Unit) {
        topBar.children.addAll(NodeManager.empty().apply(init).collection)
    }

    fun midBar(init: (@LayoutDsl NodeManager).() -> Unit) {
        midBar.children.addAll(NodeManager.empty().apply(init).collection)
    }

    fun bottomBar(init: (@LayoutDsl NodeManager).() -> Unit) {
        bottomBar.children.addAll(NodeManager.empty().apply(init).collection)
    }

    fun mainHeader(init: (@LayoutDsl NodeManager).() -> Unit) {
        mainHeader.children.addAll(NodeManager.empty().apply(init).collection)
    }

    fun condensedHeader(init: (@LayoutDsl NodeManager).() -> Unit) {
        condensedHeader.children.addAll(NodeManager.empty().apply(init).collection)
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