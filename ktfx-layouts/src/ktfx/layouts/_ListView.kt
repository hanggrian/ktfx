@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.control.ListView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [ListView] to this manager.
 */
fun <T> NodeManager.listView(items: ObservableList<T> = observableArrayList()): ListView<T> =
        listView(items = items) { }

/**
 * Create a [ListView] with configuration block.
 */
inline fun <T> listView(
    items: ObservableList<T> = observableArrayList(),
    configuration: (@LayoutDslMarker ListView<T>).() -> Unit
): ListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ListView<T>(items), configuration = configuration)
}

/**
 * Add a [ListView] with configuration block to this manager.
 */
inline fun <T> NodeManager.listView(
    items: ObservableList<T> = observableArrayList(),
    configuration: (@LayoutDslMarker ListView<T>).() -> Unit
): ListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ListView<T>(items), configuration = configuration))
}

/**
 * Create a styled [ListView].
 */
fun <T> styledListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): ListView<T> = styledListView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ListView] to this manager.
 */
fun <T> NodeManager.styledListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): ListView<T> = styledListView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ListView] with configuration block.
 */
inline fun <T> styledListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ListView<T>).() -> Unit
): ListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ListView<T>(items), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [ListView] with configuration block to this manager.
 */
inline fun <T> NodeManager.styledListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ListView<T>).() -> Unit
): ListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ListView<T>(items), styleClass = *styleClass, id = id, configuration =
            configuration))
}
