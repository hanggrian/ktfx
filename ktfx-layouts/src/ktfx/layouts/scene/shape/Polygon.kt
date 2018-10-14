@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.shape.Polygon
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [Polygon]. */
fun polygon(
    vararg points: Double,
    init: ((@LayoutDsl Polygon).() -> Unit)? = null
): Polygon = Polygon(*points).also { init?.invoke(it) }

/** Creates a [Polygon] and add it to this manager. */
inline fun NodeManager.polygon(
    vararg points: Double,
    noinline init: ((@LayoutDsl Polygon).() -> Unit)? = null
): Polygon = ktfx.layouts.polygon(*points, init = init)()