@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXListCell
import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutMarker

/** Creates a [JFXListCell]. */
fun <T> jfxListCell(
    init: ((@LayoutMarker JFXListCell<T>).() -> Unit)? = null
): JFXListCell<T> = JFXListCell<T>().also { init?.invoke(it) }

/** Creates a [JFXListCell] and add it to this manager. */
inline fun <T> NodeInvokable.jfxListCell(
    noinline init: ((@LayoutMarker JFXListCell<T>).() -> Unit)? = null
): JFXListCell<T> = ktfx.jfoenix.jfxListCell(init)()