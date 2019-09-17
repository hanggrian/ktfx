@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXChipView
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXChipView] with initialization block. */
inline fun <T> jfxChipView(
    init: (@LayoutDslMarker JFXChipView<T>).() -> Unit
): JFXChipView<T> = JFXChipView<T>().apply(init)

/** Add a [JFXChipView] to this manager. */
fun <T> NodeManager.jfxChipView(): JFXChipView<T> =
    addNode(ktfx.jfoenix.jfxChipView { })

/** Add a [JFXChipView] with initialization block to this manager. */
inline fun <T> NodeManager.jfxChipView(
    init: (@LayoutDslMarker JFXChipView<T>).() -> Unit
): JFXChipView<T> = addNode(ktfx.jfoenix.jfxChipView(init))