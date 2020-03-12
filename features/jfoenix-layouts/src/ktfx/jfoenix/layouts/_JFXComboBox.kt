@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXComboBox
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

/**
 * Add a [JFXComboBox] to this manager.
 */
fun <T> NodeManager.jfxComboBox(items: ObservableList<T> = observableArrayList()): JFXComboBox<T> =
        jfxComboBox(items = items) { }

/**
 * Create a [JFXComboBox] with configuration block.
 */
inline fun <T> jfxComboBox(
    items: ObservableList<T> = observableArrayList(),
    configuration: (@LayoutDslMarker JFXComboBox<T>).() -> Unit
): JFXComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXComboBox<T>(items), configuration = configuration)
}

/**
 * Add a [JFXComboBox] with configuration block to this manager.
 */
inline fun <T> NodeManager.jfxComboBox(
    items: ObservableList<T> = observableArrayList(),
    configuration: (@LayoutDslMarker JFXComboBox<T>).() -> Unit
): JFXComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXComboBox<T>(items), configuration = configuration))
}

/**
 * Create a styled [JFXComboBox].
 */
fun <T> styledJFXComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): JFXComboBox<T> = styledJFXComboBox(items = items, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXComboBox] to this manager.
 */
fun <T> NodeManager.styledJFXComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): JFXComboBox<T> = styledJFXComboBox(items = items, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXComboBox] with configuration block.
 */
inline fun <T> styledJFXComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXComboBox<T>).() -> Unit
): JFXComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXComboBox<T>(items), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [JFXComboBox] with configuration block to this manager.
 */
inline fun <T> NodeManager.styledJFXComboBox(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXComboBox<T>).() -> Unit
): JFXComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXComboBox<T>(items), styleClass = *styleClass, id = id, configuration =
            configuration))
}
