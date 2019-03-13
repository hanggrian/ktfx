@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXChipView
import com.jfoenix.controls.JFXDefaultChip
import ktfx.layouts.NodeManager
import ktfx.layouts.LayoutDslMarker

/** Creates a [JFXDefaultChip]. */
fun <T> jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    init: ((@LayoutDslMarker JFXDefaultChip<T>).() -> Unit)? = null
): JFXDefaultChip<T> = JFXDefaultChip<T>(view, item).also { init?.invoke(it) }

/** Creates a [JFXDefaultChip] and add it to this manager. */
inline fun <T> NodeManager.jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    noinline init: ((@LayoutDslMarker JFXDefaultChip<T>).() -> Unit)? = null
): JFXDefaultChip<T> = ktfx.jfoenix.jfxDefaultChip(view, item, init).add()