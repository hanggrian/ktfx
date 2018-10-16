@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.PopOver

open class _PopOver : PopOver(), NodeManager by NodeManager.INVOKABLE_ONLY {

    override fun <T : Node> T.invoke(): T = also { contentNode = it }
}

/** Creates a [PopOver]. */
fun popOver(
    init: ((@LayoutDsl _PopOver).() -> Unit)? = null
): PopOver = _PopOver().also { init?.invoke(it) }