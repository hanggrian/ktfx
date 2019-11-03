@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXListView
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXListView] with initialization. */
inline fun <T> jfxListView(
    init: (@LayoutDslMarker JFXListView<T>).() -> Unit
): JFXListView<T> = JFXListView<T>().apply(init)

/** Add a [JFXListView] to this manager. */
fun <T> NodeManager.jfxListView(): JFXListView<T> =
    addNode(JFXListView())

/** Add a [JFXListView] with initialization to this manager. */
inline fun <T> NodeManager.jfxListView(
    init: (@LayoutDslMarker JFXListView<T>).() -> Unit
): JFXListView<T> = addNode(JFXListView(), init)
