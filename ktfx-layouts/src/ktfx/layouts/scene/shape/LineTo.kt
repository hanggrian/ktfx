@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.LineTo

/** Add a [LineTo] to this manager. */
fun PathElementManager.lineTo(
    x: Double = 0.0,
    y: Double = 0.0
): LineTo = LineTo(x, y).add()

/** Add a [LineTo] with initialization block to this manager. */
inline fun PathElementManager.lineTo(
    x: Double = 0.0,
    y: Double = 0.0,
    init: (@LayoutDslMarker LineTo).() -> Unit
): LineTo = lineTo(x, y).apply(init)
