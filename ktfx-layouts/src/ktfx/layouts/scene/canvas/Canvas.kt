@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.canvas.Canvas

/** Creates a [Canvas]. */
fun canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    init: ((@LayoutDsl Canvas).() -> Unit)? = null
): Canvas = Canvas(width, height).also { init?.invoke(it) }

/** Creates a [Canvas] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    noinline init: ((@LayoutDsl Canvas).() -> Unit)? = null
): Canvas = ktfx.layouts.canvas(width, height, init)()