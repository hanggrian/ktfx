@file:JvmMultifileClass
@file:JvmName("ControlsFxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.listeners

import org.controlsfx.control.PlusMinusSlider
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see PlusMinusSlider.setOnValueChanged
 */
public inline fun PlusMinusSlider.onValueChanged(
    noinline
    action: (PlusMinusSlider.PlusMinusEvent) -> Unit
) {
    return setOnValueChanged(action)
}
