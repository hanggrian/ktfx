@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXChip
import com.jfoenix.controls.JFXChipView
import ktfx.NodeInvokable
import ktfx.LayoutDsl

/** Creates a [JFXChip]. */
fun <T> jfxChip(
    view: JFXChipView<T>,
    item: T,
    init: ((@LayoutDsl JFXChip<T>).() -> Unit)? = null
): JFXChip<T> = JFXChip<T>(view, item).also { init?.invoke(it) }

/** Creates a [JFXChip] and add it to this manager. */
inline fun <T> NodeInvokable.jfxChip(
    view: JFXChipView<T>,
    item: T,
    noinline init: ((@LayoutDsl JFXChip<T>).() -> Unit)? = null
): JFXChip<T> = ktfx.jfoenix.jfxChip(view, item, init)()