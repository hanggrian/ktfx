@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.shape.VLineTo
import ktfx.PathElementManager
import ktfx.annotations.LayoutDsl

/** Creates a [VLineTo]. */
fun vlineTo(
    y: Double = 0.0,
    init: ((@LayoutDsl VLineTo).() -> Unit)? = null
): VLineTo = VLineTo(y).also { init?.invoke(it) }

/** Creates a [VLineTo] and add it to this manager. */
inline fun PathElementManager.vlineTo(
    y: Double = 0.0,
    noinline init: ((@LayoutDsl VLineTo).() -> Unit)? = null
): VLineTo = ktfx.layouts.vlineTo(y, init)()