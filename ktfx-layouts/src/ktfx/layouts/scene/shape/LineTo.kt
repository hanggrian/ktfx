@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.LineTo
import ktfx.PathElementInvokable
import ktfx.LayoutDsl

/** Creates a [LineTo]. */
fun lineTo(
    x: Double = 0.0,
    y: Double = 0.0,
    init: ((@LayoutDsl LineTo).() -> Unit)? = null
): LineTo = LineTo(x, y).also { init?.invoke(it) }

/** Creates a [LineTo] and add it to this manager. */
inline fun PathElementInvokable.lineTo(
    x: Double = 0.0,
    y: Double = 0.0,
    noinline init: ((@LayoutDsl LineTo).() -> Unit)? = null
): LineTo = ktfx.layouts.lineTo(x, y, init)()