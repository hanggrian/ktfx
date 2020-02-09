@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.GridView

/** Create a [GridView] with configurationialization block. */
inline fun <T> gridView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    configuration: (@LayoutDslMarker GridView<T>).() -> Unit
): GridView<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return GridView(items).apply(configuration)
}

/** Add a [GridView] to this manager. */
fun <T> NodeManager.gridView(
    items: ObservableList<T> = FXCollections.observableArrayList()
): GridView<T> = addChild(GridView(items))

/** Add a [GridView] with configurationialization block to this manager. */
inline fun <T> NodeManager.gridView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    configuration: (@LayoutDslMarker GridView<T>).() -> Unit
): GridView<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(GridView(items), configuration)
}
