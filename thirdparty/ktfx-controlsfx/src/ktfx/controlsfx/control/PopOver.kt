@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.LayoutDsl
import ktfx.NodeManager
import org.controlsfx.control.PopOver

open class _PopOver : PopOver(), NodeManager {

    override fun <T : Node> T.invoke(): T = also { contentNode = it }
}

/** Creates a [PopOver]. */
fun popOver(
    init: ((@LayoutDsl _PopOver).() -> Unit)? = null
): PopOver = _PopOver().also { init?.invoke(it) }