@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXRippler
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

// TODO: should include mask & pos in constructor?
open class _JFXRippler : JFXRippler(), NodeManager {

    override fun <R : Node> R.add(): R = also { control = it }
}

/** Add a [JFXRippler] to this manager. */
fun NodeManager.jfxRippler(): JFXRippler =
    _JFXRippler().add()

/** Add a [JFXRippler] with initialization to this manager. */
inline fun NodeManager.jfxRippler(
    init: (@LayoutDslMarker _JFXRippler).() -> Unit
): JFXRippler = (jfxRippler() as _JFXRippler).apply(init)
