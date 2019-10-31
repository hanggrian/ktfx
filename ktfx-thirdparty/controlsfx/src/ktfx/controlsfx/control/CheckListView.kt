@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.collections.ObservableList
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.CheckListView

/** Create a [CheckListView] with initialization block. */
inline fun <T> checkListView(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDslMarker CheckListView<T>).() -> Unit
): CheckListView<T> = CheckListView(items).apply(init)

/** Add a [CheckListView] to this manager. */
fun <T> NodeManager.checkListView(
    items: ObservableList<T> = mutableObservableListOf()
): CheckListView<T> = addNode(CheckListView(items))

/** Add a [CheckListView] with initialization block to this manager. */
inline fun <T> NodeManager.checkListView(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDslMarker CheckListView<T>).() -> Unit
): CheckListView<T> = addNode(CheckListView(items), init)
