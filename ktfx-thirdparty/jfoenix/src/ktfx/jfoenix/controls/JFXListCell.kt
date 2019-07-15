@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXListCell
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXListCell]. */
fun <T> jfxListCell(
    init: ((@LayoutDslMarker JFXListCell<T>).() -> Unit)? = null
): JFXListCell<T> = JFXListCell<T>().also { init?.invoke(it) }

/** Creates a [JFXListCell] and add it to this manager. */
inline fun <T> NodeManager.jfxListCell(
    noinline init: ((@LayoutDslMarker JFXListCell<T>).() -> Unit)? = null
): JFXListCell<T> = ktfx.jfoenix.jfxListCell(init).add()
