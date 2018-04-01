@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Slider

inline fun slider(
    min: Double,
    max: Double,
    value: Double
): Slider = slider(min, max, value) { }

inline fun slider(
    min: Double,
    max: Double,
    value: Double,
    init: (@LayoutDsl Slider).() -> Unit
): Slider = Slider(min, max, value).apply(init)

inline fun LayoutManager<Node>.slider(
    min: Double,
    max: Double,
    value: Double
): Slider = slider(min, max, value) { }

inline fun LayoutManager<Node>.slider(
    min: Double,
    max: Double,
    value: Double,
    init: (@LayoutDsl Slider).() -> Unit
): Slider = ktfx.layouts.slider(min, max, value, init).add()