@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.RangeSlider

/** Creates a [RangeSlider]. */
fun rangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    init: ((@LayoutDsl RangeSlider).() -> Unit)? = null
): RangeSlider = RangeSlider(min, max, lowValue, highValue).also {
    init?.invoke(it)
}

/** Creates a [RangeSlider] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.rangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    noinline init: ((@LayoutDsl RangeSlider).() -> Unit)? = null
): RangeSlider = javafxx.layouts.controlsfx.rangeSlider(min, max, lowValue, highValue, init)()

/** Create a styled [RangeSlider]. */
fun styledRangeSlider(
    styleClass: String,
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    init: ((@LayoutDsl RangeSlider).() -> Unit)? = null
): RangeSlider = RangeSlider(min, max, lowValue, highValue).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [RangeSlider] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledRangeSlider(
    styleClass: String,
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    noinline init: ((@LayoutDsl RangeSlider).() -> Unit)? = null
): RangeSlider = javafxx.layouts.controlsfx.styledRangeSlider(styleClass, min, max, lowValue, highValue, init)()