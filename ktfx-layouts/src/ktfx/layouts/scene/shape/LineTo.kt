@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.LineTo

/** Create a [LineTo] with initialization block. */
inline fun lineTo(
    x: Double = 0.0,
    y: Double = 0.0,
    init: (@LayoutDslMarker LineTo).() -> Unit
): LineTo = LineTo(x, y).apply(init)

/** Add a [LineTo] to this manager. */
fun PathElementManager.lineTo(
    x: Double = 0.0,
    y: Double = 0.0
): LineTo = addElement(ktfx.layouts.lineTo(x, y) { })

/** Add a [LineTo] with initialization block to this manager. */
inline fun PathElementManager.lineTo(
    x: Double = 0.0,
    y: Double = 0.0,
    init: (@LayoutDslMarker LineTo).() -> Unit
): LineTo = addElement(ktfx.layouts.lineTo(x, y, init))
