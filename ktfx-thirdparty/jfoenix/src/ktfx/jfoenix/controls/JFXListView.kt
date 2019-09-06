@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXListView
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXListView] with initialization. */
inline fun <T> jfxListView(
    init: (@LayoutDslMarker JFXListView<T>).() -> Unit
): JFXListView<T> = JFXListView<T>().apply(init)

/** Add a [JFXListView] to this manager. */
fun <T> NodeManager.jfxListView(): JFXListView<T> =
    addNode(ktfx.jfoenix.jfxListView { })

/** Add a [JFXListView] with initialization to this manager. */
inline fun <T> NodeManager.jfxListView(
    init: (@LayoutDslMarker JFXListView<T>).() -> Unit
): JFXListView<T> = addNode(ktfx.jfoenix.jfxListView(init))
