@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.controlsfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer
import org.controlsfx.control.GridView

/**
 * Add a [GridView] to this container.
 *
 * @return the control added.
 */
public fun <T> NodeContainer.gridView(items: ObservableList<T> = observableArrayList()): GridView<T>
        = gridView(items = items) { }

/**
 * Create a [GridView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun <T> gridView(items: ObservableList<T> = observableArrayList(),
        configuration: (@KtfxLayoutDslMarker GridView<T>).() -> Unit): GridView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = GridView<T>(items)
    child.configuration()
    return child
}

/**
 * Add a [GridView] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.gridView(items: ObservableList<T> = observableArrayList(),
        configuration: (@KtfxLayoutDslMarker GridView<T>).() -> Unit): GridView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = GridView<T>(items)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [GridView].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun <T> styledGridView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): GridView<T> = styledGridView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [GridView] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun <T> NodeContainer.styledGridView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): GridView<T> = styledGridView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [GridView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun <T> styledGridView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker GridView<T>).() -> Unit,
): GridView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = GridView<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [GridView] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledGridView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker GridView<T>).() -> Unit,
): GridView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = GridView<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
