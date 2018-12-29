@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXListView
import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutMarker

/** Creates a [JFXListView]. */
fun <T> jfxListView(
    init: ((@LayoutMarker JFXListView<T>).() -> Unit)? = null
): JFXListView<T> = JFXListView<T>().also { init?.invoke(it) }

/** Creates a [JFXListView] and add it to this manager. */
inline fun <T> NodeInvokable.jfxListView(
    noinline init: ((@LayoutMarker JFXListView<T>).() -> Unit)? = null
): JFXListView<T> = ktfx.jfoenix.jfxListView(init)()