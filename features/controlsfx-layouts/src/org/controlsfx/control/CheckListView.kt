@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.CheckListView

/** Create a [CheckListView] with configuration block. */
inline fun <T> checkListView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    configuration: (@LayoutDslMarker CheckListView<T>).() -> Unit
): CheckListView<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return CheckListView(items).apply(configuration)
}

/** Add a [CheckListView] to this manager. */
fun <T> NodeManager.checkListView(
    items: ObservableList<T> = FXCollections.observableArrayList()
): CheckListView<T> = addChild(CheckListView(items))

/** Add a [CheckListView] with configuration block to this manager. */
inline fun <T> NodeManager.checkListView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    configuration: (@LayoutDslMarker CheckListView<T>).() -> Unit
): CheckListView<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(CheckListView(items), configuration)
}
