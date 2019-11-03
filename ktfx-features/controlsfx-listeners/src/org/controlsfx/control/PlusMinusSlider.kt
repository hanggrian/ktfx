@file:JvmMultifileClass
@file:JvmName("ControlsFxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.listeners

import org.controlsfx.control.PlusMinusSlider

inline fun PlusMinusSlider.onValueChanged(
    noinline action: (PlusMinusSlider.PlusMinusEvent) -> Unit
): Unit = setOnValueChanged { event -> action(event) }
