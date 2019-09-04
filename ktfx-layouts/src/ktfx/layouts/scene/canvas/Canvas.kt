@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.canvas.Canvas

/** Creates a [Canvas]. */
fun canvas(
    width: Number = 0,
    height: Number = 0
): Canvas = Canvas(width.toDouble(), height.toDouble())

/** Creates a [Canvas] with initialization block. */
inline fun canvas(
    width: Number = 0,
    height: Number = 0,
    init: (@LayoutDslMarker Canvas).() -> Unit
): Canvas = canvas(width, height).apply(init)

/** Creates and add a [Canvas] to this manager. */
fun NodeManager.canvas(
    width: Number = 0,
    height: Number = 0
): Canvas = ktfx.layouts.canvas(width, height).add()

/** Creates and add a [Canvas] with initialization block to this manager. */
inline fun NodeManager.canvas(
    width: Number = 0,
    height: Number = 0,
    init: (@LayoutDslMarker Canvas).() -> Unit
): Canvas = ktfx.layouts.canvas(width, height, init).add()
