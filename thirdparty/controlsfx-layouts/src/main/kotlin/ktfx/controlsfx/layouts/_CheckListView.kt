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
import org.controlsfx.control.CheckListView

/**
 * Add a [CheckListView] to this container.
 *
 * @return the control added.
 */
public fun <T> NodeContainer.checkListView(items: ObservableList<T> = observableArrayList()):
        CheckListView<T> = checkListView(items = items) { }

/**
 * Create a [CheckListView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun <T> checkListView(items: ObservableList<T> = observableArrayList(),
        configuration: (@KtfxLayoutDslMarker CheckListView<T>).() -> Unit): CheckListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckListView<T>(items)
    child.configuration()
    return child
}

/**
 * Add a [CheckListView] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.checkListView(items: ObservableList<T> = observableArrayList(),
        configuration: (@KtfxLayoutDslMarker CheckListView<T>).() -> Unit): CheckListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckListView<T>(items)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [CheckListView].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun <T> styledCheckListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): CheckListView<T> = styledCheckListView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [CheckListView] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun <T> NodeContainer.styledCheckListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): CheckListView<T> = styledCheckListView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [CheckListView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun <T> styledCheckListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CheckListView<T>).() -> Unit,
): CheckListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckListView<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [CheckListView] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledCheckListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CheckListView<T>).() -> Unit,
): CheckListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckListView<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
