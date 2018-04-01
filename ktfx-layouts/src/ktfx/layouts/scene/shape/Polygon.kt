@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Polygon

inline fun polygon(
    vararg points: Double
): Polygon = polygon(*points) { }

inline fun polygon(
    vararg points: Double,
    init: (@LayoutDsl Polygon).() -> Unit
): Polygon = Polygon(*points).apply(init)

inline fun LayoutManager<Node>.polygon(
    vararg points: Double
): Polygon = polygon(*points) { }

inline fun LayoutManager<Node>.polygon(
    vararg points: Double,
    init: (@LayoutDsl Polygon).() -> Unit
): Polygon = ktfx.layouts.polygon(*points, init = init).add()