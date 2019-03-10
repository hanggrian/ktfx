@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.HiddenSidesPane

/**
 * Invoking layout DSL will only set content.
 * To set other sides, explicitly use `top`, `left`, `bottom`, or `right`.
 */
open class _HiddenSidesPane : HiddenSidesPane(), NodeManager {

    override fun <R : Node> R.add(): R = also { content = it }
}

/** Creates a [HiddenSidesPane]. */
fun hiddenSidesPane(
    init: ((@LayoutMarker _HiddenSidesPane).() -> Unit)? = null
): HiddenSidesPane = _HiddenSidesPane().also { init?.invoke(it) }

/** Creates a [HiddenSidesPane] and add it to this manager. */
inline fun NodeManager.hiddenSidesPane(
    noinline init: ((@LayoutMarker _HiddenSidesPane).() -> Unit)? = null
): HiddenSidesPane = ktfx.controlsfx.hiddenSidesPane(init).add()