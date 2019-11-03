@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.thirdparty.controlsfx.layouts

import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.HiddenSidesPane

/**
 * Invoking layout DSL will only set content.
 * To set other sides, explicitly use `top`, `left`, `bottom`, or `right`.
 */
open class KtfxHiddenSidesPane : HiddenSidesPane(), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { content = it }
}

/** Create a [HiddenSidesPane] with initialization block. */
inline fun hiddenSidesPane(
    init: (@LayoutDslMarker KtfxHiddenSidesPane).() -> Unit
): HiddenSidesPane = KtfxHiddenSidesPane().apply(init)

/** Add a [HiddenSidesPane] to this manager. */
fun NodeManager.hiddenSidesPane(): HiddenSidesPane =
    addNode(KtfxHiddenSidesPane())

/** Add a [HiddenSidesPane] with initialization block to this manager. */
inline fun NodeManager.hiddenSidesPane(
    init: (@LayoutDslMarker KtfxHiddenSidesPane).() -> Unit
): HiddenSidesPane = addNode(KtfxHiddenSidesPane(), init)
