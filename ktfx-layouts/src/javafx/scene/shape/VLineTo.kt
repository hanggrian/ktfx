@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.VLineTo
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [VLineTo] with initialization block. */
inline fun vlineTo(
    y: Double = 0.0,
    init: (@LayoutsDslMarker VLineTo).() -> Unit
): VLineTo {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return VLineTo(y).apply(init)
}

/** Add a [VLineTo] to this manager. */
fun PathElementManager.vlineTo(
    y: Double = 0.0
): VLineTo = addElement(VLineTo(y))

/** Add a [VLineTo] with initialization block to this manager. */
inline fun PathElementManager.vlineTo(
    y: Double = 0.0,
    init: (@LayoutsDslMarker VLineTo).() -> Unit
): VLineTo {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addElement(VLineTo(y), init)
}
