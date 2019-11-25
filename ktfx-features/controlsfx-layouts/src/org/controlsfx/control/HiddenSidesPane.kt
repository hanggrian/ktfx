@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.KtfxLayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.HiddenSidesPane

/**
 * [HiddenSidesPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxHiddenSidesPane : HiddenSidesPane(), NodeManager {

    final override fun <T : Node> addNode(node: T): T = node.also { content = it }
}

/** Create a [HiddenSidesPane] with initialization block. */
inline fun hiddenSidesPane(
    init: (@KtfxLayoutsDslMarker KtfxHiddenSidesPane).() -> Unit
): HiddenSidesPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxHiddenSidesPane().apply(init)
}

/** Add a [HiddenSidesPane] to this manager. */
fun NodeManager.hiddenSidesPane(): HiddenSidesPane =
    addNode(KtfxHiddenSidesPane())

/** Add a [HiddenSidesPane] with initialization block to this manager. */
inline fun NodeManager.hiddenSidesPane(
    init: (@KtfxLayoutsDslMarker KtfxHiddenSidesPane).() -> Unit
): HiddenSidesPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxHiddenSidesPane(), init)
}
