@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [SplitPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxSplitPane : SplitPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { items += it }

    final override val childCount: Int get() = items.size
}

/** Create a [SplitPane] with initialization block. */
inline fun splitPane(
    init: (@LayoutsDslMarker KtfxSplitPane).() -> Unit
): SplitPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxSplitPane().apply(init)
}

/** Add a [SplitPane] to this manager. */
fun NodeManager.splitPane(): SplitPane = addChild(KtfxSplitPane())

/** Add a [SplitPane] with initialization block to this manager. */
inline fun NodeManager.splitPane(
    init: (@LayoutsDslMarker KtfxSplitPane).() -> Unit
): SplitPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxSplitPane(), init)
}
