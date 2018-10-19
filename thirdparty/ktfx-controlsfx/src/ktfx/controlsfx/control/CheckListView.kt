@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.CheckListView

/** Creates a [CheckListView]. */
fun <T> checkListView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl CheckListView<T>).() -> Unit)? = null
): CheckListView<T> = CheckListView(items).also { init?.invoke(it) }

/** Creates a [CheckListView] and add it to this manager. */
inline fun <T> NodeManager.checkListView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl CheckListView<T>).() -> Unit)? = null
): CheckListView<T> = ktfx.controlsfx.checkListView(items, init)()