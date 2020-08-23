@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.control.ComboBox
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ComboBox] to this manager.
 *
 * @return the control added.
 */
fun <T> NodeManager.comboBox(items: ObservableList<T> = observableArrayList()): ComboBox<T> =
    comboBox(items = items) { }

/**
 * Create a [ComboBox] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun <T> comboBox(
    items: ObservableList<T> = observableArrayList(),
    configuration: (@KtfxLayoutDslMarker ComboBox<T>).() -> Unit
): ComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ComboBox<T>(items)
    child.configuration()
    return child
}

/**
 * Add a [ComboBox] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun <T> NodeManager.comboBox(
    items: ObservableList<T> = observableArrayList(),
    configuration: (@KtfxLayoutDslMarker ComboBox<T>).() -> Unit
): ComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ComboBox<T>(items)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [ComboBox].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun <T> styledComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): ComboBox<T> = styledComboBox(items = items, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ComboBox] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun <T> NodeManager.styledComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): ComboBox<T> = styledComboBox(items = items, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ComboBox] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun <T> styledComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ComboBox<T>).() -> Unit
): ComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ComboBox<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ComboBox] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun <T> NodeManager.styledComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ComboBox<T>).() -> Unit
): ComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ComboBox<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
