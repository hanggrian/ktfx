@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.CheckListView

/** Creates a [CheckListView]. */
fun <T> checkListView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl CheckListView<T>).() -> Unit)? = null
): CheckListView<T> = CheckListView(items).also { init?.invoke(it) }

/** Creates a [CheckListView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.checkListView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl CheckListView<T>).() -> Unit)? = null
): CheckListView<T> = ktfx.controlsfx.checkListView(items, init)()