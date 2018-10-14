@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXChipView
import com.jfoenix.controls.JFXDefaultChip
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [JFXDefaultChip]. */
fun <T> jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    init: ((@LayoutDsl JFXDefaultChip<T>).() -> Unit)? = null
): JFXDefaultChip<T> = JFXDefaultChip<T>(view, item).also { init?.invoke(it) }

/** Creates a [JFXDefaultChip] and add it to this manager. */
inline fun <T> NodeManager.jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    noinline init: ((@LayoutDsl JFXDefaultChip<T>).() -> Unit)? = null
): JFXDefaultChip<T> = ktfx.jfoenix.jfxDefaultChip(view, item, init)()