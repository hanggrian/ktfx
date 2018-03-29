@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Polyline

inline fun polyline(
    vararg points: Number
): Polyline = polyline(*points) { }

fun polyline(
    vararg points: Number,
    init: (@LayoutDsl Polyline).() -> Unit
): Polyline = Polyline(*points.map { it.toDouble() }.toDoubleArray()).apply(init)

inline fun LayoutManager<Node>.polyline(
    vararg points: Number
): Polyline = polyline(*points) { }

inline fun LayoutManager<Node>.polyline(
    vararg points: Number,
    noinline init: (@LayoutDsl Polyline).() -> Unit
): Polyline = ktfx.layouts.polyline(*points, init = init).add()