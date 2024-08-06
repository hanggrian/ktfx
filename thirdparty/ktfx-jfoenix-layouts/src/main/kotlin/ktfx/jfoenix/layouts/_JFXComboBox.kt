@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXComboBox
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

/**
 * Add a [JFXComboBox] to this container.
 *
 * @return the control added.
 */
public fun <T> NodeContainer.jfxComboBox(items: ObservableList<T> = observableArrayList()):
        JFXComboBox<T> = jfxComboBox(items = items) { }

/**
 * Create a [JFXComboBox] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun <T> jfxComboBox(items: ObservableList<T> = observableArrayList(),
        configuration: (@KtfxLayoutDslMarker JFXComboBox<T>).() -> Unit): JFXComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXComboBox<T>(items)
    child.configuration()
    return child
}

/**
 * Add a [JFXComboBox] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.jfxComboBox(items: ObservableList<T> = observableArrayList(),
        configuration: (@KtfxLayoutDslMarker JFXComboBox<T>).() -> Unit): JFXComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXComboBox<T>(items)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXComboBox].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun <T> styledJFXComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): JFXComboBox<T> = styledJFXComboBox(items = items, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXComboBox] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun <T> NodeContainer.styledJFXComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): JFXComboBox<T> = styledJFXComboBox(items = items, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXComboBox] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun <T> styledJFXComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXComboBox<T>).() -> Unit,
): JFXComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXComboBox<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXComboBox] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledJFXComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXComboBox<T>).() -> Unit,
): JFXComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXComboBox<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
