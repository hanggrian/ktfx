@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Polyline

inline fun polyline(
    vararg points: Double
): Polyline = polyline(*points) { }

inline fun polyline(
    vararg points: Double,
    init: (@LayoutDsl Polyline).() -> Unit
): Polyline = Polyline(*points).apply(init)

inline fun LayoutManager<Node>.polyline(
    vararg points: Double
): Polyline = polyline(*points) { }

inline fun LayoutManager<Node>.polyline(
    vararg points: Double,
    init: (@LayoutDsl Polyline).() -> Unit
): Polyline = ktfx.layouts.polyline(*points, init = init).add()