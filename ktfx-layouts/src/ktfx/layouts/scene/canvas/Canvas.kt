@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.canvas.Canvas

/** Create a [Canvas] with initialization block. */
inline fun canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    init: (@LayoutDslMarker Canvas).() -> Unit
): Canvas = Canvas(width, height).apply(init)

/** Add a [Canvas] to this manager. */
fun NodeManager.canvas(
    width: Double = 0.0,
    height: Double = 0.0
): Canvas = addNode(Canvas(width, height))

/** Add a [Canvas] with initialization block to this manager. */
inline fun NodeManager.canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    init: (@LayoutDslMarker Canvas).() -> Unit
): Canvas = addNode(Canvas(width, height), init)
