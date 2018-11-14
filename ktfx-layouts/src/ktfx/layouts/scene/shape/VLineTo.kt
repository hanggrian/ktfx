@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.VLineTo

/** Creates a [VLineTo]. */
fun vlineTo(
    y: Double = 0.0,
    init: ((@LayoutDsl VLineTo).() -> Unit)? = null
): VLineTo = VLineTo(y).also { init?.invoke(it) }

/** Creates a [VLineTo] and add it to this manager. */
inline fun PathElementInvokable.vlineTo(
    y: Double = 0.0,
    noinline init: ((@LayoutDsl VLineTo).() -> Unit)? = null
): VLineTo = ktfx.layouts.vlineTo(y, init)()