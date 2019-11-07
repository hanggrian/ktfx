@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Pane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class KtfxPane : Pane(), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }
}

/** Create a [Pane] with initialization block. */
inline fun pane(
    init: (@LayoutDslMarker KtfxPane).() -> Unit
): Pane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxPane().apply(init)
}
/** Add a [Pane] to this manager. */
fun NodeManager.pane(): Pane =
    addNode(KtfxPane())

/** Add a [Pane] with initialization block to this manager. */
inline fun NodeManager.pane(
    init: (@LayoutDslMarker KtfxPane).() -> Unit
): Pane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxPane(), init)
}
