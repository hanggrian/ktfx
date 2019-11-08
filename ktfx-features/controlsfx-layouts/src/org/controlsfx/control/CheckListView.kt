@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.CheckListView

/** Create a [CheckListView] with initialization block. */
inline fun <T> checkListView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: CheckListView<T>.() -> Unit
): CheckListView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return CheckListView(items).apply(init)
}

/** Add a [CheckListView] to this manager. */
fun <T> NodeManager.checkListView(
    items: ObservableList<T> = FXCollections.observableArrayList()
): CheckListView<T> = addNode(CheckListView(items))

/** Add a [CheckListView] with initialization block to this manager. */
inline fun <T> NodeManager.checkListView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: CheckListView<T>.() -> Unit
): CheckListView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(CheckListView(items), init)
}
