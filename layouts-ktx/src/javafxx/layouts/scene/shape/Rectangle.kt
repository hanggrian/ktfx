@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.layouts

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
): Rectangle = javafxx.layouts.rectangle(x, y, width, height, init)()

/** Create a styled [Rectangle]. */
fun styledRectangle(
    styleClass: String,
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    init: ((@LayoutDsl Rectangle).() -> Unit)? = null
): Rectangle = Rectangle(x, y, width, height).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Rectangle] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledRectangle(
    styleClass: String,
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    noinline init: ((@LayoutDsl Rectangle).() -> Unit)? = null
): Rectangle = javafxx.layouts.styledRectangle(styleClass, x, y, width, height, init)()