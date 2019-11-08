@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [ColorPicker] with initialization block. */
inline fun colorPicker(
    color: Color = WHITE,
    init: ColorPicker.() -> Unit
): ColorPicker {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return ColorPicker(color).apply(init)
}
/** Add a [ColorPicker] to this manager. */
fun NodeManager.colorPicker(
    color: Color = WHITE
): ColorPicker = addNode(ColorPicker(color))

/** Add a [ColorPicker] with initialization block to this manager. */
inline fun NodeManager.colorPicker(
    color: Color = WHITE,
    init: ColorPicker.() -> Unit
): ColorPicker {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(ColorPicker(color), init)
}
