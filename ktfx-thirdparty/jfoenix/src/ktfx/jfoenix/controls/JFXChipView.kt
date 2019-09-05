@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXChipView
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXChipView] to this manager. */
fun <T> NodeManager.jfxChipView(): JFXChipView<T> =
    JFXChipView<T>().add()

/** Add a [JFXChipView] with initialization block to this manager. */
inline fun <T> NodeManager.jfxChipView(
    init: (@LayoutDslMarker JFXChipView<T>).() -> Unit
): JFXChipView<T> = jfxChipView<T>().apply(init)
