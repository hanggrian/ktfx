@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.PopOver

open class _PopOver : PopOver(), NodeManager {

    override fun <T : Node> T.add(): T = also { contentNode = it }
}

/** Creates a [PopOver]. */
fun popOver(
    init: ((@LayoutDslMarker _PopOver).() -> Unit)? = null
): PopOver = _PopOver().also { init?.invoke(it) }
