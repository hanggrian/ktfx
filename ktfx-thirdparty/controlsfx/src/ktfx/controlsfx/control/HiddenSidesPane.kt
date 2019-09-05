@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.HiddenSidesPane

/**
 * Invoking layout DSL will only set content.
 * To set other sides, explicitly use `top`, `left`, `bottom`, or `right`.
 */
open class _HiddenSidesPane : HiddenSidesPane(), NodeManager {

    override fun <R : Node> R.add(): R = also { content = it }
}

/** Add a [HiddenSidesPane] to this manager. */
fun NodeManager.hiddenSidesPane(): HiddenSidesPane =
    _HiddenSidesPane().add()

/** Add a [HiddenSidesPane] with initialization block to this manager. */
inline fun NodeManager.hiddenSidesPane(
    init: (@LayoutDslMarker _HiddenSidesPane).() -> Unit
): HiddenSidesPane = (hiddenSidesPane() as _HiddenSidesPane).apply(init)
