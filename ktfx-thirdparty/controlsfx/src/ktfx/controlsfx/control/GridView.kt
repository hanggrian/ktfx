@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.collections.ObservableList
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.GridView

/** Create a [GridView] with initialization block. */
inline fun <T> gridView(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDslMarker GridView<T>).() -> Unit
): GridView<T> = GridView(items).apply(init)

/** Add a [GridView] to this manager. */
fun <T> NodeManager.gridView(
    items: ObservableList<T> = mutableObservableListOf()
): GridView<T> = addNode(GridView(items))

/** Add a [GridView] with initialization block to this manager. */
inline fun <T> NodeManager.gridView(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDslMarker GridView<T>).() -> Unit
): GridView<T> = addNode(GridView(items), init)
