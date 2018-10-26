@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.PopOver

open class _PopOver : PopOver(), NodeManager by NodeManager.invokableOnly() {

    override fun <T : Node> T.invoke(): T = also { contentNode = it }
}

/** Creates a [PopOver]. */
fun popOver(
    init: ((@LayoutDsl _PopOver).() -> Unit)? = null
): PopOver = _PopOver().also { init?.invoke(it) }