@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Polygon

inline fun polygon(
    vararg points: Number
): Polygon = polygon(*points) { }

fun polygon(
    vararg points: Number,
    init: (@LayoutDsl Polygon).() -> Unit
): Polygon = Polygon(*points.map { it.toDouble() }.toDoubleArray()).apply(init)

inline fun LayoutManager<Node>.polygon(
    vararg points: Number
): Polygon = polygon(*points) { }

inline fun LayoutManager<Node>.polygon(
    vararg points: Number,
    noinline init: (@LayoutDsl Polygon).() -> Unit
): Polygon = ktfx.layouts.polygon(*points, init = init).add()