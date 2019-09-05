@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.canvas.Canvas

/** Add a [Canvas] to this manager. */
fun NodeManager.canvas(
    width: Double = 0.0,
    height: Double = 0.0
): Canvas = Canvas(width, height).add()

/** Add a [Canvas] with initialization block to this manager. */
inline fun NodeManager.canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    init: (@LayoutDslMarker Canvas).() -> Unit
): Canvas = canvas(width, height).apply(init)
