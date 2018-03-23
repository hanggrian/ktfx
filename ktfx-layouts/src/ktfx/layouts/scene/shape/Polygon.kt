@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Polygon

inline fun polygon(
    vararg points: Double,
    noinline init: ((@LayoutDsl Polygon).() -> Unit)? = null
): Polygon = Polygon(*points).also { init?.invoke(it) }

inline fun LayoutManager<Node>.polygon(
    vararg points: Double,
    noinline init: ((@LayoutDsl Polygon).() -> Unit)? = null
): Polygon = ktfx.layouts.polygon(*points, init = init).add()