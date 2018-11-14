@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.NodeInvokable
import org.controlsfx.control.PopOver

open class _PopOver : PopOver(), NodeInvokable {

    override fun <T : Node> T.invoke(): T = also { contentNode = it }
}

/** Creates a [PopOver]. */
fun popOver(
    init: ((@LayoutDsl _PopOver).() -> Unit)? = null
): PopOver = _PopOver().also { init?.invoke(it) }