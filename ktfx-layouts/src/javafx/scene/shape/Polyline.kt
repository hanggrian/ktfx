@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Polyline
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Polyline] with initialization block. */
inline fun polyline(
    vararg points: Double,
    init: (@LayoutDslMarker Polyline).() -> Unit
): Polyline {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return Polyline(*points).apply(init)
}
/** Add a [Polyline] to this manager. */
fun NodeManager.polyline(
    vararg points: Double
): Polyline = addNode(Polyline(*points))

/** Add a [Polyline] with initialization block to this manager. */
inline fun NodeManager.polyline(
    vararg points: Double,
    init: (@LayoutDslMarker Polyline).() -> Unit
): Polyline {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(Polyline(*points), init)
}
