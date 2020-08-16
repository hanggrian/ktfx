@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.CheckListView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [CheckListView] to this manager.
 *
 * @return the control added.
 */
fun <T> NodeManager.checkListView(items: ObservableList<T> = observableArrayList()):
    CheckListView<T> = checkListView(items = items) { }

/**
 * Create a [CheckListView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun <T> checkListView(
    items: ObservableList<T> = observableArrayList(),
    configuration: (@LayoutDslMarker CheckListView<T>).() -> Unit
): CheckListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckListView<T>(items)
    child.configuration()
    return child
}

/**
 * Add a [CheckListView] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun <T> NodeManager.checkListView(
    items: ObservableList<T> = observableArrayList(),
    configuration: (@LayoutDslMarker CheckListView<T>).() -> Unit
): CheckListView<T> {
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
fun <T> styledCheckListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): CheckListView<T> = styledCheckListView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [CheckListView] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun <T> NodeManager.styledCheckListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): CheckListView<T> = styledCheckListView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [CheckListView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun <T> styledCheckListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CheckListView<T>).() -> Unit
): CheckListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckListView<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [CheckListView] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun <T> NodeManager.styledCheckListView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CheckListView<T>).() -> Unit
): CheckListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckListView<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
