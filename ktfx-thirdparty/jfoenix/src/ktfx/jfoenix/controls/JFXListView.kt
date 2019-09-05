@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXListView
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXListView] to this manager. */
fun <T> NodeManager.jfxListView(): JFXListView<T> =
    JFXListView<T>().add()

/** Add a [JFXListView] with initialization to this manager. */
inline fun <T> NodeManager.jfxListView(
    init: (@LayoutDslMarker JFXListView<T>).() -> Unit
): JFXListView<T> = jfxListView<T>().apply(init)
