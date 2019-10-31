@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Rectangle

/** Create a [Rectangle] with initialization block. */
inline fun rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    init: (@LayoutDslMarker Rectangle).() -> Unit
): Rectangle = Rectangle(x, y, width, height).apply(init)

/** Add a [Rectangle] to this manager. */
fun NodeManager.rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0
): Rectangle = addNode(Rectangle(x, y, width, height))

/** Add a [Rectangle] with initialization block to this manager. */
inline fun NodeManager.rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    init: (@LayoutDslMarker Rectangle).() -> Unit
): Rectangle = addNode(Rectangle(x, y, width, height), init)
