@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXToolbar
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

open class _JFXToolbar : JFXToolbar() {

    fun leftItems(init: (@LayoutDsl NodeManager).() -> Unit) {
        leftItems.addAll(NodeManager.empty().apply(init).collection)
    }

    fun rightItems(init: (@LayoutDsl NodeManager).() -> Unit) {
        rightItems.addAll(NodeManager.empty().apply(init).collection)
    }
}

/** Creates a [JFXToolbar]. */
fun jfxToolbar(
    init: ((@LayoutDsl _JFXToolbar).() -> Unit)? = null
): JFXToolbar = _JFXToolbar().also { init?.invoke(it) }

/** Creates a [JFXToolbar] and add it to this manager. */
inline fun NodeManager.jfxToolbar(
    noinline init: ((@LayoutDsl _JFXToolbar).() -> Unit)? = null
): JFXToolbar = ktfx.jfoenix.jfxToolbar(init)()