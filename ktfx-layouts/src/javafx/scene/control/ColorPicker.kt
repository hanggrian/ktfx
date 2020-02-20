@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [ColorPicker] with configuration block. */
inline fun colorPicker(
    value: Color = Color.WHITE,
    configuration: (@LayoutDslMarker ColorPicker).() -> Unit
): ColorPicker {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ColorPicker(value).apply(configuration)
}

/** Add a [ColorPicker] to this manager. */
fun NodeManager.colorPicker(
    value: Color = Color.WHITE
): ColorPicker = addChild(ColorPicker(value))

/** Add a [ColorPicker] with configuration block to this manager. */
inline fun NodeManager.colorPicker(
    value: Color = Color.WHITE,
    configuration: (@LayoutDslMarker ColorPicker).() -> Unit
): ColorPicker {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(ColorPicker(value), configuration)
}
