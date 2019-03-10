@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.HLineTo

/** Creates a [HLineTo]. */
fun hlineTo(
    x: Double = 0.0,
    init: ((@LayoutMarker HLineTo).() -> Unit)? = null
): HLineTo = HLineTo(x).also { init?.invoke(it) }

/** Creates a [HLineTo] and add it to this manager. */
inline fun PathElementManager.hlineTo(
    x: Double = 0.0,
    noinline init: ((@LayoutMarker HLineTo).() -> Unit)? = null
): HLineTo = ktfx.layouts.hlineTo(x, init).add()