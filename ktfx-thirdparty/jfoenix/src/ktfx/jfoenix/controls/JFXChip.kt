@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXChip
import com.jfoenix.controls.JFXChipView
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXChip] to this manager. */
fun <T> NodeManager.jfxChip(
    view: JFXChipView<T>,
    item: T
): JFXChip<T> = JFXChip(view, item).add()

/** Add a [JFXChip] with initialization block to this manager. */
inline fun <T> NodeManager.jfxChip(
    view: JFXChipView<T>,
    item: T,
    init: (@LayoutDslMarker JFXChip<T>).() -> Unit
): JFXChip<T> = jfxChip(view, item).apply(init)
