@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.shape.Polyline

/** Creates a [Polyline]. */
fun polyline(
    vararg points: Double,
    init: ((@LayoutDsl Polyline).() -> Unit)? = null
): Polyline = Polyline(*points).also {
    init?.invoke(it)
}

/** Creates a [Polyline] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.polyline(
    vararg points: Double,
    noinline init: ((@LayoutDsl Polyline).() -> Unit)? = null
): Polyline = ktfx.layouts.polyline(*points, init = init)()

/** Create a styled [Polyline]. */
fun styledPolyline(
    styleClass: String,
    vararg points: Double,
    init: ((@LayoutDsl Polyline).() -> Unit)? = null
): Polyline = Polyline(*points).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Polyline] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledPolyline(
    styleClass: String,
    vararg points: Double,
    noinline init: ((@LayoutDsl Polyline).() -> Unit)? = null
): Polyline = ktfx.layouts.styledPolyline(styleClass, *points, init = init)()