@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.SidesNodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.HiddenSidesPane

/**
 * Invoking layout DSL will only set content.
 * To set other sides, explicitly use `top`, `left`, `bottom`, or `right`.
 */
open class KtfxHiddenSidesPane : HiddenSidesPane(), SidesNodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { content = it }

    final override fun <T : Node> addTopNode(node: T): T =
        node.also { top = it }

    final override fun <T : Node> addRightNode(node: T): T =
        node.also { right = it }

    final override fun <T : Node> addBottomNode(node: T): T =
        node.also { bottom = it }

    final override fun <T : Node> addLeftNode(node: T): T =
        node.also { left = it }
}

/** Create a [HiddenSidesPane] with initialization block. */
inline fun hiddenSidesPane(
    init: (@LayoutDslMarker KtfxHiddenSidesPane).() -> Unit
): HiddenSidesPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxHiddenSidesPane().apply(init) }

/** Add a [HiddenSidesPane] to this manager. */
fun NodeManager.hiddenSidesPane(): HiddenSidesPane =
    addNode(KtfxHiddenSidesPane())

/** Add a [HiddenSidesPane] with initialization block to this manager. */
inline fun NodeManager.hiddenSidesPane(
    init: (@LayoutDslMarker KtfxHiddenSidesPane).() -> Unit
): HiddenSidesPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxHiddenSidesPane(), init) }
