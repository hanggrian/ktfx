@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Rectangle

/** Creates a [Rectangle]. */
fun rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    init: ((@LayoutMarker Rectangle).() -> Unit)? = null
): Rectangle = Rectangle(x, y, width, height).also { init?.invoke(it) }

/** Creates a [Rectangle] and add it to this manager. */
inline fun NodeInvokable.rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    noinline init: ((@LayoutMarker Rectangle).() -> Unit)? = null
): Rectangle = ktfx.layouts.rectangle(x, y, width, height, init)()