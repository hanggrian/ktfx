@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.shape.Line

/** Creates a [Line]. */
fun line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: ((@LayoutDsl Line).() -> Unit)? = null
): Line = Line(centerX, centerY, endX, endY).also {
    init?.invoke(it)
}

/** Creates a [Line] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    noinline init: ((@LayoutDsl Line).() -> Unit)? = null
): Line = ktfx.layouts.line(centerX, centerY, endX, endY, init)()