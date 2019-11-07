@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.ClosePath
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [ClosePath] with initialization block. */
inline fun closePath(
    init: (@LayoutDslMarker ClosePath).() -> Unit
): ClosePath {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return ClosePath().apply(init)
}
/** Add a [ClosePath] to this manager. */
fun PathElementManager.closePath(): ClosePath =
    addElement(ClosePath())

/** Add a [ClosePath] with initialization block to this manager. */
inline fun PathElementManager.closePath(
    init: (@LayoutDslMarker ClosePath).() -> Unit
): ClosePath {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addElement(ClosePath(), init)
}
