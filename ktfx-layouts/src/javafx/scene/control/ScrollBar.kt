@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ScrollBar
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [ScrollBar] with initialization block. */
inline fun scrollBar(
    init: (@LayoutsDslMarker ScrollBar).() -> Unit
): ScrollBar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return ScrollBar().apply(init)
}

/** Add a [ScrollBar] to this manager. */
fun NodeManager.scrollBar(): ScrollBar =
    addNode(ScrollBar())

/** Add a [ScrollBar] with initialization block to this manager. */
inline fun NodeManager.scrollBar(
    init: (@LayoutsDslMarker ScrollBar).() -> Unit
): ScrollBar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(ScrollBar(), init)
}
