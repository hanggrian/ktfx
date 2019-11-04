@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.control.Separator
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Separator] with initialization block. */
inline fun separator(
    orientation: Orientation = HORIZONTAL,
    init: (@LayoutDslMarker Separator).() -> Unit
): Separator {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return Separator(orientation).apply(init)
}
/** Add a [Separator] to this manager. */
fun NodeManager.separator(
    orientation: Orientation = HORIZONTAL
): Separator = addNode(Separator(orientation))

/** Add a [Separator] with initialization block to this manager. */
inline fun NodeManager.separator(
    orientation: Orientation = HORIZONTAL,
    init: (@LayoutDslMarker Separator).() -> Unit
): Separator {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(Separator(orientation), init)
}
