@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXRippler
import javafx.scene.Node
import ktfx.LayoutDsl
import ktfx.NodeManager

// TODO: should include mask & pos in constructor?
open class _JFXRippler : JFXRippler(), NodeManager {

    override fun <R : Node> R.invoke(): R = also { control = it }
}

/** Creates a [JFXRippler]. */
fun jfxRippler(
    init: ((@LayoutDsl _JFXRippler).() -> Unit)? = null
): JFXRippler = _JFXRippler().also { init?.invoke(it) }

/** Creates a [JFXRippler] and add it to this manager. */
inline fun NodeManager.jfxRippler(
    noinline init: ((@LayoutDsl _JFXRippler).() -> Unit)? = null
): JFXRippler = ktfx.jfoenix.jfxRippler(init)()