@file:Suppress("PackageDirectoryMismatch")

package ktfx.thirdparty.controlsfx.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import org.controlsfx.control.PlusMinusSlider
import kotlin.coroutines.CoroutineContext

fun PlusMinusSlider.onValueChanged(
    context: CoroutineContext = kotlinx.coroutines.Dispatchers.JavaFx,
    action: suspend CoroutineScope.(PlusMinusSlider.PlusMinusEvent) -> Unit
): Unit = setOnValueChanged { event -> kotlinx.coroutines.GlobalScope.launch(context) { action(event) } }
