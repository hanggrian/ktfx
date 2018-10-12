@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.GridView

/** Creates a [GridView]. */
fun <T> gridView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl GridView<T>).() -> Unit)? = null
): GridView<T> = GridView(items).also { init?.invoke(it) }

/** Creates a [GridView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.gridView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl GridView<T>).() -> Unit)? = null
): GridView<T> = ktfx.controlsfx.gridView(items, init)()