@file:JvmMultifileClass
@file:JvmName("ControlsfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

package ktfx.controlsfx.listeners

import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import org.controlsfx.control.PlusMinusSlider

/**
 * @see PlusMinusSlider.setOnValueChanged
 */
public inline fun PlusMinusSlider.onValueChanged(noinline
        action: (PlusMinusSlider.PlusMinusEvent) -> Unit): Unit = setOnValueChanged(action)
