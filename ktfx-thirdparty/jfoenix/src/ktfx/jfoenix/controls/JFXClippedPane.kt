@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXClippedPane
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

open class _JFXClippedPane : JFXClippedPane(), NodeManager {

    override fun <R : Node> R.add(): R = also { children += it }
}

/** Add a [JFXClippedPane] to this manager. */
fun NodeManager.jfxClippedPane(): JFXClippedPane =
    _JFXClippedPane().add()

/** Add a [JFXClippedPane] with initialization block to this manager. */
inline fun NodeManager.jfxClippedPane(
    init: (@LayoutDslMarker _JFXClippedPane).() -> Unit
): JFXClippedPane = (jfxClippedPane() as _JFXClippedPane).apply(init)
