@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXChipView
import com.jfoenix.controls.JFXDefaultChip
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXDefaultChip] with initialization block. */
inline fun <T> jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    init: (@LayoutDslMarker JFXDefaultChip<T>).() -> Unit
): JFXDefaultChip<T> = JFXDefaultChip(view, item).apply(init)

/** Add a [JFXDefaultChip] to this manager. */
fun <T> NodeManager.jfxDefaultChip(
    view: JFXChipView<T>,
    item: T
): JFXDefaultChip<T> = addNode(ktfx.jfoenix.jfxDefaultChip(view, item) { })

/** Add a [JFXDefaultChip] with initialization block to this manager. */
inline fun <T> NodeManager.jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    init: (@LayoutDslMarker JFXDefaultChip<T>).() -> Unit
): JFXDefaultChip<T> = addNode(ktfx.jfoenix.jfxDefaultChip(view, item, init))
