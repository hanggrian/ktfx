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

    override fun <T : Node> addNode(node: T): T = node.also { content = it }
}

/** Create a [HiddenSidesPane] with initialization block. */
inline fun hiddenSidesPane(
    init: (@LayoutDslMarker _HiddenSidesPane).() -> Unit
): HiddenSidesPane = _HiddenSidesPane().apply(init)

/** Add a [HiddenSidesPane] to this manager. */
fun NodeManager.hiddenSidesPane(): HiddenSidesPane =
    addNode(ktfx.controlsfx.hiddenSidesPane { })

/** Add a [HiddenSidesPane] with initialization block to this manager. */
inline fun NodeManager.hiddenSidesPane(
    init: (@LayoutDslMarker _HiddenSidesPane).() -> Unit
): HiddenSidesPane = addNode(ktfx.controlsfx.hiddenSidesPane(init))
