@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.RangeSlider

/** Create a [RangeSlider] with initialization block. */
inline fun rangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    init: (@LayoutDslMarker RangeSlider).() -> Unit
): RangeSlider = RangeSlider(min, max, lowValue, highValue).apply(init)

/** Add a [RangeSlider] to this manager. */
fun NodeManager.rangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75
): RangeSlider = addNode(RangeSlider(min, max, lowValue, highValue))

/** Add a [RangeSlider] with initialization block to this manager. */
inline fun NodeManager.rangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    init: (@LayoutDslMarker RangeSlider).() -> Unit
): RangeSlider = addNode(RangeSlider(min, max, lowValue, highValue), init)
