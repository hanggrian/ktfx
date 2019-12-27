@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Box
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Box] with initialization block. */
inline fun box(
    width: Double = Box.DEFAULT_SIZE,
    height: Double = Box.DEFAULT_SIZE,
    depth: Double = Box.DEFAULT_SIZE,
    configuration: (@LayoutsDslMarker Box).() -> Unit
): Box {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Box(width, height, depth).apply(configuration)
}

/** Add a [Box] to this manager. */
fun NodeManager.box(
    width: Double = Box.DEFAULT_SIZE,
    height: Double = Box.DEFAULT_SIZE,
    depth: Double = Box.DEFAULT_SIZE
): Box = addChild(Box(width, height, depth))

/** Add a [Box] with initialization block to this manager. */
inline fun NodeManager.box(
    width: Double = Box.DEFAULT_SIZE,
    height: Double = Box.DEFAULT_SIZE,
    depth: Double = Box.DEFAULT_SIZE,
    configuration: (@LayoutsDslMarker Box).() -> Unit
): Box {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Box(width, height, depth), configuration)
}
