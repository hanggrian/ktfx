@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.shape.Rectangle

/** Creates a [Rectangle]. */
fun rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    init: ((@LayoutDsl Rectangle).() -> Unit)? = null
): Rectangle = Rectangle(x, y, width, height).also {
    init?.invoke(it)
}

/** Creates a [Rectangle] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    noinline init: ((@LayoutDsl Rectangle).() -> Unit)? = null
): Rectangle = ktfx.layouts.rectangle(x, y, width, height, init)()