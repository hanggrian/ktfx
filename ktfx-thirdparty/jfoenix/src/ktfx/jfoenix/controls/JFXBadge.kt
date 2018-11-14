@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXBadge
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.NodeInvokable

open class _JFXBadge : JFXBadge(), NodeInvokable {

    override fun <R : Node> R.invoke(): R = also { control = it }
}

/** Creates a [JFXBadge]. */
fun jfxBadge(
    init: ((@LayoutDsl _JFXBadge).() -> Unit)? = null
): JFXBadge = _JFXBadge().also { init?.invoke(it) }

/** Creates a [JFXBadge] and add it to this manager. */
inline fun NodeInvokable.jfxBadge(
    noinline init: ((@LayoutDsl _JFXBadge).() -> Unit)? = null
): JFXBadge = ktfx.jfoenix.jfxBadge(init)()