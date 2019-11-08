@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.ListView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [ListView] with initialization block. */
inline fun <T> listView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: ListView<T>.() -> Unit
): ListView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return ListView(items).apply(init)
}
/** Add a [ListView] to this manager. */
fun <T> NodeManager.listView(
    items: ObservableList<T> = FXCollections.observableArrayList()
): ListView<T> = addNode(ListView(items))

/** Add a [ListView] with initialization block to this manager. */
inline fun <T> NodeManager.listView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: ListView<T>.() -> Unit
): ListView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(ListView(items), init)
}
