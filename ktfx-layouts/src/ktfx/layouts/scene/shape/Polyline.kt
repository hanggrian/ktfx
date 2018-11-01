@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Polyline
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [Polyline]. */
fun polyline(
    vararg points: Double,
    init: ((@LayoutDsl Polyline).() -> Unit)? = null
): Polyline = Polyline(*points).also { init?.invoke(it) }

/** Creates a [Polyline] and add it to this manager. */
inline fun NodeManager.polyline(
    vararg points: Double,
    noinline init: ((@LayoutDsl Polyline).() -> Unit)? = null
): Polyline = ktfx.layouts.polyline(*points, init = init)()