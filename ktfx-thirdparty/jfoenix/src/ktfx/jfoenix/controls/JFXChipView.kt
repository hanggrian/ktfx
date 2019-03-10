@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXChipView
import ktfx.layouts.NodeManager
import ktfx.layouts.LayoutMarker

/** Creates a [JFXChipView]. */
fun <T> jfxChipView(
    init: ((@LayoutMarker JFXChipView<T>).() -> Unit)? = null
): JFXChipView<T> = JFXChipView<T>().also { init?.invoke(it) }

/** Creates a [JFXChipView] and add it to this manager. */
inline fun <T> NodeManager.jfxChipView(
    noinline init: ((@LayoutMarker JFXChipView<T>).() -> Unit)? = null
): JFXChipView<T> = ktfx.jfoenix.jfxChipView(init).add()