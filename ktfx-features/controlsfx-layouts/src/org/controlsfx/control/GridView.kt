@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.GridView

/** Create a [GridView] with initialization block. */
inline fun <T> gridView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: (@LayoutsDslMarker GridView<T>).() -> Unit
): GridView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return GridView(items).apply(init)
}

/** Add a [GridView] to this manager. */
fun <T> NodeManager.gridView(
    items: ObservableList<T> = FXCollections.observableArrayList()
): GridView<T> = addNode(GridView(items))

/** Add a [GridView] with initialization block to this manager. */
inline fun <T> NodeManager.gridView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: (@LayoutsDslMarker GridView<T>).() -> Unit
): GridView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(GridView(items), init)
}
