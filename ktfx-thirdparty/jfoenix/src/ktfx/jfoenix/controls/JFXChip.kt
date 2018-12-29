@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXChip
import com.jfoenix.controls.JFXChipView
import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutMarker

/** Creates a [JFXChip]. */
fun <T> jfxChip(
    view: JFXChipView<T>,
    item: T,
    init: ((@LayoutMarker JFXChip<T>).() -> Unit)? = null
): JFXChip<T> = JFXChip<T>(view, item).also { init?.invoke(it) }

/** Creates a [JFXChip] and add it to this manager. */
inline fun <T> NodeInvokable.jfxChip(
    view: JFXChipView<T>,
    item: T,
    noinline init: ((@LayoutMarker JFXChip<T>).() -> Unit)? = null
): JFXChip<T> = ktfx.jfoenix.jfxChip(view, item, init)()