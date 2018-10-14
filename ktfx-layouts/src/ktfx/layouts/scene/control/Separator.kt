@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.control.Separator
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [Separator]. */
fun separator(
    orientation: Orientation = HORIZONTAL,
    init: ((@LayoutDsl Separator).() -> Unit)? = null
): Separator = Separator(orientation).also { init?.invoke(it) }

/** Creates a [Separator] and add it to this manager. */
inline fun NodeManager.separator(
    orientation: Orientation = HORIZONTAL,
    noinline init: ((@LayoutDsl Separator).() -> Unit)? = null
): Separator = ktfx.layouts.separator(orientation, init)()