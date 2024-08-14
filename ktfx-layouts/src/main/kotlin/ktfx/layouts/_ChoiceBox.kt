@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ChoiceBox] to this container.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.choiceBox(items: ObservableList<T> = observableArrayList()):
        ChoiceBox<T> = choiceBox(items = items) { }

/**
 * Create a [ChoiceBox] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun <T> choiceBox(items: ObservableList<T> = observableArrayList(),
        configuration: (@KtfxLayoutDslMarker ChoiceBox<T>).() -> Unit): ChoiceBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ChoiceBox<T>(items)
    child.configuration()
    return child
}

/**
 * Add a [ChoiceBox] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun <T> NodeContainer.choiceBox(items: ObservableList<T> = observableArrayList(),
        configuration: (@KtfxLayoutDslMarker ChoiceBox<T>).() -> Unit): ChoiceBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ChoiceBox<T>(items)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [ChoiceBox].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun <T> styledChoiceBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): ChoiceBox<T> = styledChoiceBox(items = items, styleClass = styleClass, id = id) { }

/**
 * Add a styled [ChoiceBox] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledChoiceBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): ChoiceBox<T> = styledChoiceBox(items = items, styleClass = styleClass, id = id) { }

/**
 * Create a styled [ChoiceBox] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun <T> styledChoiceBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ChoiceBox<T>).() -> Unit,
): ChoiceBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ChoiceBox<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ChoiceBox] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun <T> NodeContainer.styledChoiceBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ChoiceBox<T>).() -> Unit,
): ChoiceBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ChoiceBox<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
