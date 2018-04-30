@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Polygon

/** Creates a [Polygon]. */
fun polygon(
    vararg points: Double,
    init: ((@LayoutDsl Polygon).() -> Unit)? = null
): Polygon = Polygon(*points).also {
    init?.invoke(it)
}

/** Creates a [Polygon] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.polygon(
    vararg points: Double,
    noinline init: ((@LayoutDsl Polygon).() -> Unit)? = null
): Polygon = ktfx.layouts.polygon(*points, init = init).add()

/** Create a styled [Polygon]. */
fun styledPolygon(
    styleClass: String,
    vararg points: Double,
    init: ((@LayoutDsl Polygon).() -> Unit)? = null
): Polygon = Polygon(*points).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Polygon] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledPolygon(
    styleClass: String,
    vararg points: Double,
    noinline init: ((@LayoutDsl Polygon).() -> Unit)? = null
): Polygon = ktfx.layouts.styledPolygon(styleClass, *points, init = init).add()