@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class KtfxSplitPane : SplitPane(), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { items += it }
}

/** Create a [SplitPane] with initialization block. */
inline fun splitPane(
    init: (@LayoutDslMarker KtfxSplitPane).() -> Unit
): SplitPane {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return KtfxSplitPane().apply(init)
}
/** Add a [SplitPane] to this manager. */
fun NodeManager.splitPane(): SplitPane =
    addNode(KtfxSplitPane())

/** Add a [SplitPane] with initialization block to this manager. */
inline fun NodeManager.splitPane(
    init: (@LayoutDslMarker KtfxSplitPane).() -> Unit
): SplitPane {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(KtfxSplitPane(), init)
}
