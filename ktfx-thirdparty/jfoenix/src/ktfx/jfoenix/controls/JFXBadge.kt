@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXBadge
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

open class _JFXBadge : JFXBadge(), NodeManager {

    override fun <R : Node> R.add(): R = also { control = it }
}

/** Creates a [JFXBadge]. */
fun jfxBadge(
    init: ((@LayoutDslMarker _JFXBadge).() -> Unit)? = null
): JFXBadge = _JFXBadge().also { init?.invoke(it) }

/** Creates a [JFXBadge] and add it to this manager. */
inline fun NodeManager.jfxBadge(
    noinline init: ((@LayoutDslMarker _JFXBadge).() -> Unit)? = null
): JFXBadge = ktfx.jfoenix.jfxBadge(init).add()