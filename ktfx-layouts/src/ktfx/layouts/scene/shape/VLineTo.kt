@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.VLineTo

/** Add a [VLineTo] to this manager. */
fun PathElementManager.vlineTo(
    y: Double = 0.0
): VLineTo = VLineTo(y).add()

/** Add a [VLineTo] with initialization block to this manager. */
inline fun PathElementManager.vlineTo(
    y: Double = 0.0,
    init: (@LayoutDslMarker VLineTo).() -> Unit
): VLineTo = vlineTo(y).apply(init)
