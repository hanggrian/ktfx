@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.MoveTo

/** Add a [MoveTo] to this manager. */
fun PathElementManager.moveTo(
    x: Double = 0.0,
    y: Double = 0.0
): MoveTo = MoveTo(x, y).add()

/** Add a [MoveTo] with initialization block to this manager. */
inline fun PathElementManager.moveTo(
    x: Double = 0.0,
    y: Double = 0.0,
    init: (@LayoutDslMarker MoveTo).() -> Unit
): MoveTo = moveTo(x, y).apply(init)
