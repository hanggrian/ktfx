@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Polyline

/** Creates a [Polyline]. */
fun polyline(
    vararg points: Double,
    init: ((@LayoutMarker Polyline).() -> Unit)? = null
): Polyline = Polyline(*points).also { init?.invoke(it) }

/** Creates a [Polyline] and add it to this manager. */
inline fun NodeManager.polyline(
    vararg points: Double,
    noinline init: ((@LayoutMarker Polyline).() -> Unit)? = null
): Polyline = ktfx.layouts.polyline(*points, init = init).add()