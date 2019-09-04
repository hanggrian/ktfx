@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.HLineTo

/** Add a [HLineTo] to this manager. */
fun PathElementManager.hlineTo(
    x: Double = 0.0
): HLineTo = HLineTo(x).add()

/** Add a [HLineTo] to this manager. */
inline fun PathElementManager.hlineTo(
    x: Double = 0.0,
    init: (@LayoutDslMarker HLineTo).() -> Unit
): HLineTo = hlineTo(x).apply(init)
