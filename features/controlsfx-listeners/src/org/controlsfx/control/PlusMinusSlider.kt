@file:JvmMultifileClass
@file:JvmName("ControlsFxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.listeners

import org.controlsfx.control.PlusMinusSlider

/** Sets an event handler that will receive plus minus events when the user moves the adjuster's thumb. */
inline fun PlusMinusSlider.onValueChanged(
    noinline action: (PlusMinusSlider.PlusMinusEvent) -> Unit
): Unit = setOnValueChanged { event -> action(event) }
