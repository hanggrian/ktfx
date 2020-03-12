@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.GridView

/**
 * Add a [GridView] to this manager.
 */
fun <T> NodeManager.gridView(items: ObservableList<T> = observableArrayList()): GridView<T> =
        gridView(items = items) { }

/**
 * Create a [GridView] with configuration block.
 */
inline fun <T> gridView(
    items: ObservableList<T> = observableArrayList(),
    configuration: (@LayoutDslMarker GridView<T>).() -> Unit
): GridView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(GridView<T>(items), configuration = configuration)
}

/**
 * Add a [GridView] with configuration block to this manager.
 */
inline fun <T> NodeManager.gridView(
    items: ObservableList<T> = observableArrayList(),
    configuration: (@LayoutDslMarker GridView<T>).() -> Unit
): GridView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(GridView<T>(items), configuration = configuration))
}

/**
 * Create a styled [GridView].
 */
fun <T> styledGridView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): GridView<T> = styledGridView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [GridView] to this manager.
 */
fun <T> NodeManager.styledGridView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): GridView<T> = styledGridView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [GridView] with configuration block.
 */
inline fun <T> styledGridView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker GridView<T>).() -> Unit
): GridView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(GridView<T>(items), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [GridView] with configuration block to this manager.
 */
inline fun <T> NodeManager.styledGridView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker GridView<T>).() -> Unit
): GridView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(GridView<T>(items), styleClass = *styleClass, id = id, configuration =
            configuration))
}