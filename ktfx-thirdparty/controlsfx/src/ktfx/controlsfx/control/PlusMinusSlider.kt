@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.PlusMinusSlider

fun PlusMinusSlider.onValueChanged(
    context: CoroutineContext = kotlinx.coroutines.Dispatchers.JavaFx,
    action: suspend CoroutineScope.(PlusMinusSlider.PlusMinusEvent) -> Unit
): Unit = setOnValueChanged { event -> kotlinx.coroutines.GlobalScope.launch(context) { action(event) } }

/** Create a [PlusMinusSlider] with initialization block. */
inline fun plusMinusSlider(
    init: (@LayoutDslMarker PlusMinusSlider).() -> Unit
): PlusMinusSlider = PlusMinusSlider().apply(init)

/** Add a [PlusMinusSlider] to this manager. */
fun NodeManager.plusMinusSlider(): PlusMinusSlider =
    addNode(PlusMinusSlider())

/** Add a [PlusMinusSlider] with initialization block to this manager. */
inline fun NodeManager.plusMinusSlider(
    init: (@LayoutDslMarker PlusMinusSlider).() -> Unit
): PlusMinusSlider = addNode(PlusMinusSlider(), init)
