@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.HLineTo
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [HLineTo] with initialization block. */
inline fun hlineTo(
    x: Double = 0.0,
    init: (@KtfxLayoutsDslMarker HLineTo).() -> Unit
): HLineTo {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return HLineTo(x).apply(init)
}

/** Add a [HLineTo] to this manager. */
fun PathElementManager.hlineTo(
    x: Double = 0.0
): HLineTo = addElement(HLineTo(x))

/** Add a [HLineTo] with initialization block to this manager. */
inline fun PathElementManager.hlineTo(
    x: Double = 0.0,
    init: (@KtfxLayoutsDslMarker HLineTo).() -> Unit
): HLineTo {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addElement(HLineTo(x), init)
}
