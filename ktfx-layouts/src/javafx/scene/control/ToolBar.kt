@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToolBar
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [ToolBar] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxToolBar : ToolBar(), NodeManager {

    final override fun <T : Node> addNode(node: T): T = node.also { items += it }
}

/** Create a [ToolBar] with initialization block. */
inline fun toolBar(
    init: (@LayoutsDslMarker KtfxToolBar).() -> Unit
): ToolBar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxToolBar().apply(init)
}

/** Add a [ToolBar] to this manager. */
fun NodeManager.toolBar(): ToolBar =
    addNode(KtfxToolBar())

/** Add a [ToolBar] with initialization block to this manager. */
inline fun NodeManager.toolBar(
    init: (@LayoutsDslMarker KtfxToolBar).() -> Unit
): ToolBar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxToolBar(), init)
}
