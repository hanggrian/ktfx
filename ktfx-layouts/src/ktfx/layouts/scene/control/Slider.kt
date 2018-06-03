@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Slider

/** Creates a [Slider]. */
fun slider(
    min: Double,
    max: Double,
    value: Double,
    init: ((@LayoutDsl Slider).() -> Unit)? = null
): Slider = Slider(min, max, value).also {
    init?.invoke(it)
}

/** Creates a [Slider] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.slider(
    min: Double,
    max: Double,
    value: Double,
    noinline init: ((@LayoutDsl Slider).() -> Unit)? = null
): Slider = ktfx.layouts.slider(min, max, value, init)()

/** Create a styled [Slider]. */
fun styledSlider(
    styleClass: String,
    min: Double,
    max: Double,
    value: Double,
    init: ((@LayoutDsl Slider).() -> Unit)? = null
): Slider = Slider(min, max, value).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Slider] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledSlider(
    styleClass: String,
    min: Double,
    max: Double,
    value: Double,
    noinline init: ((@LayoutDsl Slider).() -> Unit)? = null
): Slider = ktfx.layouts.styledSlider(styleClass, min, max, value, init)()