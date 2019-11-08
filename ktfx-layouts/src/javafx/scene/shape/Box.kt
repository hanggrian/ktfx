@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Box
import javafx.scene.shape.Box.DEFAULT_SIZE
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Box] with initialization block. */
inline fun box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    init: Box.() -> Unit
): Box {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Box(width, height, depth).apply(init)
}
/** Add a [Box] to this manager. */
fun NodeManager.box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE
): Box = addNode(Box(width, height, depth))

/** Add a [Box] with initialization block to this manager. */
inline fun NodeManager.box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    init: Box.() -> Unit
): Box {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(Box(width, height, depth), init)
}
