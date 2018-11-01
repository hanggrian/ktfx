@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import ktfx.NodeManager
import ktfx.LayoutDsl
import org.controlsfx.control.PlusMinusSlider
import kotlin.coroutines.CoroutineContext

fun PlusMinusSlider.onValueChanged(
    context: CoroutineContext = kotlinx.coroutines.Dispatchers.JavaFx,
    action: suspend CoroutineScope.(PlusMinusSlider.PlusMinusEvent) -> Unit
): Unit = setOnValueChanged { event -> kotlinx.coroutines.GlobalScope.launch(context) { action(event) } }

/** Creates a [PlusMinusSlider]. */
fun plusMinusSlider(
    init: ((@LayoutDsl PlusMinusSlider).() -> Unit)? = null
): PlusMinusSlider = PlusMinusSlider().also { init?.invoke(it) }

/** Creates a [PlusMinusSlider] and add it to this manager. */
inline fun NodeManager.plusMinusSlider(
    noinline init: ((@LayoutDsl PlusMinusSlider).() -> Unit)? = null
): PlusMinusSlider = ktfx.controlsfx.plusMinusSlider(init)()