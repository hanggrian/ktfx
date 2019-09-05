@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXBadge
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

open class _JFXBadge : JFXBadge(), NodeManager {

    override fun <R : Node> R.add(): R = also { control = it }
}

/** Add a [JFXBadge] to this manager. */
fun NodeManager.jfxBadge(): JFXBadge =
    _JFXBadge().add()

/** Add a [JFXBadge] with initialization block to this manager. */
inline fun NodeManager.jfxBadge(
    init: (@LayoutDslMarker _JFXBadge).() -> Unit
): JFXBadge = (jfxBadge() as _JFXBadge).apply(init)
