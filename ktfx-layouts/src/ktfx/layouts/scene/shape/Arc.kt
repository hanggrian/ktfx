@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.shape.Arc

/** Creates a [Arc]. */
fun arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    init: ((@LayoutDsl Arc).() -> Unit)? = null
): Arc = Arc(centerX, centerY, radiusX, radiusY, startAngle, length).also { init?.invoke(it) }

/** Creates a [Arc] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    noinline init: ((@LayoutDsl Arc).() -> Unit)? = null
): Arc = ktfx.layouts.arc(centerX, centerY, radiusX, radiusY, startAngle, length, init)()