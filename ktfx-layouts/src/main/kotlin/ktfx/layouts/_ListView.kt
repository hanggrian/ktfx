@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.control.ListView
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ListView] to this container.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.listView(items: ObservableList<T> = observableArrayList()):
        ListView<T> = listView(items = items) { }

/**
 * Create a [ListView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun <T> listView(items: ObservableList<T> = observableArrayList(),
        configuration: (@KtfxLayoutDslMarker ListView<T>).() -> Unit): ListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ListView<T>(items)
    child.configuration()
    return child
}

/**
 * Add a [ListView] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.listView(items: ObservableList<T> = observableArrayList(),
        configuration: (@KtfxLayoutDslMarker ListView<T>).() -> Unit): ListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ListView<T>(items)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [ListView].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun <T> styledListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): ListView<T> = styledListView(items = items, styleClass = styleClass, id = id) { }

/**
 * Add a styled [ListView] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): ListView<T> = styledListView(items = items, styleClass = styleClass, id = id) { }

/**
 * Create a styled [ListView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun <T> styledListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ListView<T>).() -> Unit,
): ListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ListView<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ListView] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ListView<T>).() -> Unit,
): ListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ListView<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
