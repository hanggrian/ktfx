@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.collections.ObservableList
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.CheckListView

/** Add a [CheckListView] to this manager. */
fun <T> NodeManager.checkListView(
    items: ObservableList<T> = mutableObservableListOf()
): CheckListView<T> = CheckListView(items).add()

/** Add a [CheckListView] with initialization block to this manager. */
inline fun <T> NodeManager.checkListView(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDslMarker CheckListView<T>).() -> Unit
): CheckListView<T> = checkListView(items).apply(init)
