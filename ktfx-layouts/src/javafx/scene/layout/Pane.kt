@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Pane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [Pane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxPane : Pane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    final override val childCount: Int get() = childrenUnmodifiable.size
}

/** Create a [Pane] with initialization block. */
inline fun pane(
    init: (@LayoutsDslMarker KtfxPane).() -> Unit
): Pane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxPane().apply(init)
}

/** Add a [Pane] to this manager. */
fun NodeManager.pane(): Pane = addChild(KtfxPane())

/** Add a [Pane] with initialization block to this manager. */
inline fun NodeManager.pane(
    init: (@LayoutsDslMarker KtfxPane).() -> Unit
): Pane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxPane(), init)
}
