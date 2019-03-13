@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Polygon

/** Creates a [Polygon]. */
fun polygon(
    vararg points: Double,
    init: ((@LayoutDslMarker Polygon).() -> Unit)? = null
): Polygon = Polygon(*points).also { init?.invoke(it) }

/** Creates a [Polygon] and add it to this manager. */
inline fun NodeManager.polygon(
    vararg points: Double,
    noinline init: ((@LayoutDslMarker Polygon).() -> Unit)? = null
): Polygon = ktfx.layouts.polygon(*points, init = init).add()