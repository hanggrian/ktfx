@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Spinner
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Spinner] with initialization block. */
inline fun <T> spinner(
    init: (@LayoutsDslMarker Spinner<T>).() -> Unit
): Spinner<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Spinner<T>().apply(init)
}

/** Add a [Spinner] to this manager. */
fun <T> NodeManager.spinner(): Spinner<T> = addChild(Spinner())

/** Add a [Spinner] with initialization block to this manager. */
inline fun <T> NodeManager.spinner(
    init: (@LayoutsDslMarker Spinner<T>).() -> Unit
): Spinner<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(Spinner(), init)
}
