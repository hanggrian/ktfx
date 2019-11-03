@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")

package ktfx.thirdparty.controlsfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.GridView

/** Create a [GridView] with initialization block. */
inline fun <T> gridView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker GridView<T>).() -> Unit
): GridView<T> = GridView(items).apply(init)

/** Add a [GridView] to this manager. */
fun <T> NodeManager.gridView(
    items: ObservableList<T> = FXCollections.observableArrayList()
): GridView<T> = addNode(GridView(items))

/** Add a [GridView] with initialization block to this manager. */
inline fun <T> NodeManager.gridView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker GridView<T>).() -> Unit
): GridView<T> = addNode(GridView(items), init)
