@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Rectangle

/** Add a [Rectangle] to this manager. */
fun NodeManager.rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0
): Rectangle = rectangle(x, y, width, height).add()

/** Add a [Rectangle] with initialization block to this manager. */
inline fun NodeManager.rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    init: (@LayoutDslMarker Rectangle).() -> Unit
): Rectangle = rectangle(x, y, width, height).apply(init)
