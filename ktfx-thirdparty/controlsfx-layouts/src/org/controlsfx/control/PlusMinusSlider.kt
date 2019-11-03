@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")

package ktfx.thirdparty.controlsfx.layouts

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.PlusMinusSlider

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
