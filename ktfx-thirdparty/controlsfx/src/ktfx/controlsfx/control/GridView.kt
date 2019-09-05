@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.collections.ObservableList
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.GridView

/** Add a [GridView] to this manager. */
fun <T> NodeManager.gridView(
    items: ObservableList<T> = mutableObservableListOf()
): GridView<T> = GridView(items).add()

/** Add a [GridView] with initialization block to this manager. */
inline fun <T> NodeManager.gridView(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDslMarker GridView<T>).() -> Unit
): GridView<T> = gridView(items).apply(init)
