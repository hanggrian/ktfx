@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.RangeSlider

/** Add a [RangeSlider] to this manager. */
fun NodeManager.rangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75
): RangeSlider = RangeSlider(min, max, lowValue, highValue).add()

/** Add a [RangeSlider] with initialization block to this manager. */
inline fun NodeManager.rangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    init: (@LayoutDslMarker RangeSlider).() -> Unit
): RangeSlider = rangeSlider(min, max, lowValue, highValue).apply(init)
