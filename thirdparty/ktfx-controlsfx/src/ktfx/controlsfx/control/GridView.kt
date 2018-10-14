@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.GridView

/** Creates a [GridView]. */
fun <T> gridView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl GridView<T>).() -> Unit)? = null
): GridView<T> = GridView(items).also { init?.invoke(it) }

/** Creates a [GridView] and add it to this manager. */
inline fun <T> NodeManager.gridView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl GridView<T>).() -> Unit)? = null
): GridView<T> = ktfx.controlsfx.gridView(items, init)()