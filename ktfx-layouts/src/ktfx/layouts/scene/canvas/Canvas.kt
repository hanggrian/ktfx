@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.canvas.Canvas

/** Creates a [Canvas]. */
fun canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    init: ((@LayoutDslMarker Canvas).() -> Unit)? = null
): Canvas = Canvas(width, height).also { init?.invoke(it) }

/** Creates a [Canvas] and add it to this manager. */
inline fun NodeManager.canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    noinline init: ((@LayoutDslMarker Canvas).() -> Unit)? = null
): Canvas = ktfx.layouts.canvas(width, height, init).add()