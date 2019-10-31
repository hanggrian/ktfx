@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.MoveTo

/** Create a [MoveTo] with initialization block. */
inline fun moveTo(
    x: Double = 0.0,
    y: Double = 0.0,
    init: (@LayoutDslMarker MoveTo).() -> Unit
): MoveTo = MoveTo(x, y).apply(init)

/** Add a [MoveTo] to this manager. */
fun PathElementManager.moveTo(
    x: Double = 0.0,
    y: Double = 0.0
): MoveTo = addElement(MoveTo(x, y))

/** Add a [MoveTo] with initialization block to this manager. */
inline fun PathElementManager.moveTo(
    x: Double = 0.0,
    y: Double = 0.0,
    init: (@LayoutDslMarker MoveTo).() -> Unit
): MoveTo = addElement(MoveTo(x, y), init)
