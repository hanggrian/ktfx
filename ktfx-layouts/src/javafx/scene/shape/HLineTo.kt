@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.HLineTo
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [HLineTo] with configuration block. */
inline fun hlineTo(
    x: Double = 0.0,
    configuration: (@LayoutDslMarker HLineTo).() -> Unit
): HLineTo {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return HLineTo(x).apply(configuration)
}

/** Add a [HLineTo] to this manager. */
fun PathElementManager.hlineTo(
    x: Double = 0.0
): HLineTo = addChild(HLineTo(x))

/** Add a [HLineTo] with configuration block to this manager. */
inline fun PathElementManager.hlineTo(
    x: Double = 0.0,
    configuration: (@LayoutDslMarker HLineTo).() -> Unit
): HLineTo {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(HLineTo(x), configuration)
}
