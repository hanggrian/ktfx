@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTreeCell
import ktfx.layouts.LayoutMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXTreeCell]. */
fun <T> jfxTreeCell(
    init: ((@LayoutMarker JFXTreeCell<T>).() -> Unit)? = null
): JFXTreeCell<T> = JFXTreeCell<T>().also { init?.invoke(it) }

/** Creates a [JFXTreeCell] and add it to this manager. */
inline fun <T> NodeManager.jfxTreeCell(
    noinline init: ((@LayoutMarker JFXTreeCell<T>).() -> Unit)? = null
): JFXTreeCell<T> = ktfx.jfoenix.jfxTreeCell(init).add()