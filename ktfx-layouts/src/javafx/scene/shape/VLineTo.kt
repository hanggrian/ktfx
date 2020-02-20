@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.VLineTo
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [VLineTo] with configuration block. */
inline fun vlineTo(
    y: Double = 0.0,
    configuration: (@LayoutDslMarker VLineTo).() -> Unit
): VLineTo {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return VLineTo(y).apply(configuration)
}

/** Add a [VLineTo] to this manager. */
fun PathElementManager.vlineTo(
    y: Double = 0.0
): VLineTo = addChild(VLineTo(y))

/** Add a [VLineTo] with configuration block to this manager. */
inline fun PathElementManager.vlineTo(
    y: Double = 0.0,
    configuration: (@LayoutDslMarker VLineTo).() -> Unit
): VLineTo {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(VLineTo(y), configuration)
}
