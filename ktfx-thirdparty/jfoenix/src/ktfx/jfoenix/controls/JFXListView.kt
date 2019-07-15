@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXListView
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXListView]. */
fun <T> jfxListView(
    init: ((@LayoutDslMarker JFXListView<T>).() -> Unit)? = null
): JFXListView<T> = JFXListView<T>().also { init?.invoke(it) }

/** Creates a [JFXListView] and add it to this manager. */
inline fun <T> NodeManager.jfxListView(
    noinline init: ((@LayoutDslMarker JFXListView<T>).() -> Unit)? = null
): JFXListView<T> = ktfx.jfoenix.jfxListView(init).add()
