@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXChipView
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXChipView]. */
fun <T> jfxChipView(
    init: ((@LayoutDslMarker JFXChipView<T>).() -> Unit)? = null
): JFXChipView<T> = JFXChipView<T>().also { init?.invoke(it) }

/** Creates a [JFXChipView] and add it to this manager. */
inline fun <T> NodeManager.jfxChipView(
    noinline init: ((@LayoutDslMarker JFXChipView<T>).() -> Unit)? = null
): JFXChipView<T> = ktfx.jfoenix.jfxChipView(init).add()
