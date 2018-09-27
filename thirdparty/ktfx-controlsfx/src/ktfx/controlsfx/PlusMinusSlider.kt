@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.PlusMinusSlider

/** Creates a [PlusMinusSlider]. */
fun plusMinusSlider(
    init: ((@LayoutDsl PlusMinusSlider).() -> Unit)? = null
): PlusMinusSlider = PlusMinusSlider().also {
    init?.invoke(it)
}

/** Creates a [PlusMinusSlider] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.plusMinusSlider(
    noinline init: ((@LayoutDsl PlusMinusSlider).() -> Unit)? = null
): PlusMinusSlider = ktfx.controlsfx.plusMinusSlider(init)()