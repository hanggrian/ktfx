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
import org.controlsfx.control.CheckComboBox

/**
 * Add a [CheckComboBox] to this manager.
 */
fun <T> NodeManager.checkComboBox(items: ObservableList<T> = observableArrayList()):
        CheckComboBox<T> = checkComboBox(items = items) { }

/**
 * Create a [CheckComboBox] with configuration block.
 */
inline fun <T> checkComboBox(
    items: ObservableList<T> = observableArrayList(),
    configuration: (@LayoutDslMarker CheckComboBox<T>).() -> Unit
): CheckComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(CheckComboBox<T>(items), configuration = configuration)
}

/**
 * Add a [CheckComboBox] with configuration block to this manager.
 */
inline fun <T> NodeManager.checkComboBox(
    items: ObservableList<T> = observableArrayList(),
    configuration: (@LayoutDslMarker CheckComboBox<T>).() -> Unit
): CheckComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(CheckComboBox<T>(items), configuration = configuration))
}

/**
 * Create a styled [CheckComboBox].
 */
fun <T> styledCheckComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): CheckComboBox<T> = styledCheckComboBox(items = items, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [CheckComboBox] to this manager.
 */
fun <T> NodeManager.styledCheckComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): CheckComboBox<T> = styledCheckComboBox(items = items, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [CheckComboBox] with configuration block.
 */
inline fun <T> styledCheckComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CheckComboBox<T>).() -> Unit
): CheckComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(CheckComboBox<T>(items), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [CheckComboBox] with configuration block to this manager.
 */
inline fun <T> NodeManager.styledCheckComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CheckComboBox<T>).() -> Unit
): CheckComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(CheckComboBox<T>(items), styleClass = *styleClass, id = id,
            configuration = configuration))
}
