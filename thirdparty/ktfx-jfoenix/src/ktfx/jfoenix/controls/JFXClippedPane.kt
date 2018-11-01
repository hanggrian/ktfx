@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXClippedPane
import javafx.scene.Node
import ktfx.NodeManager
import ktfx.LayoutDsl

open class _JFXClippedPane : JFXClippedPane(), NodeManager {

    override val collection: MutableCollection<Node> get() = children
}

/** Creates a [JFXClippedPane]. */
fun jfxClippedPane(
    init: ((@LayoutDsl _JFXClippedPane).() -> Unit)? = null
): JFXClippedPane = _JFXClippedPane().also { init?.invoke(it) }

/** Creates a [JFXClippedPane] and add it to this manager. */
inline fun NodeManager.jfxClippedPane(
    noinline init: ((@LayoutDsl _JFXClippedPane).() -> Unit)? = null
): JFXClippedPane = ktfx.jfoenix.jfxClippedPane(init)()