@file:JvmMultifileClass
@file:JvmName("ControlsfxCoroutinesKt")

package ktfx.controlsfx.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import org.controlsfx.control.PlusMinusSlider
import kotlin.coroutines.CoroutineContext

/** Sets an event handler that will receive plus minus events when the user moves the adjuster's thumb. */
fun PlusMinusSlider.onValueChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(PlusMinusSlider.PlusMinusEvent) -> Unit
): Unit = setOnValueChanged { event -> GlobalScope.launch(context) { action(event) } }
