@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Slider

inline fun slider(
    min: Number,
    max: Number,
    value: Number
): Slider = slider(min, max, value) { }

fun slider(
    min: Number,
    max: Number,
    value: Number,
    init: (@LayoutDsl Slider).() -> Unit
): Slider = Slider(min.toDouble(), max.toDouble(), value.toDouble()).apply(init)

inline fun LayoutManager<Node>.slider(
    min: Number,
    max: Number,
    value: Number
): Slider = slider(min, max, value) { }

inline fun LayoutManager<Node>.slider(
    min: Number,
    max: Number,
    value: Number,
    noinline init: (@LayoutDsl Slider).() -> Unit
): Slider = ktfx.layouts.slider(min, max, value, init).add()