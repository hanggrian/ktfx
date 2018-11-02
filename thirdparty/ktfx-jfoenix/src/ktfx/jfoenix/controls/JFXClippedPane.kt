@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXClippedPane
import javafx.scene.Node
import ktfx.LayoutDsl
import ktfx.NodeInvokable

open class _JFXClippedPane : JFXClippedPane(), NodeInvokable {

    override fun <R : Node> R.invoke(): R = also { children += it }
}

/** Creates a [JFXClippedPane]. */
fun jfxClippedPane(
    init: ((@LayoutDsl _JFXClippedPane).() -> Unit)? = null
): JFXClippedPane = _JFXClippedPane().also { init?.invoke(it) }

/** Creates a [JFXClippedPane] and add it to this manager. */
inline fun NodeInvokable.jfxClippedPane(
    noinline init: ((@LayoutDsl _JFXClippedPane).() -> Unit)? = null
): JFXClippedPane = ktfx.jfoenix.jfxClippedPane(init)()