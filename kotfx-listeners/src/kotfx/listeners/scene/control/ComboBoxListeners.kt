@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.event.EventHandler
import javafx.scene.control.ComboBox
import javafx.scene.control.ComboBoxBase
import javafx.scene.control.ListCell
import javafx.scene.control.ListView
import kotfx.listeners.internal.asConverter

inline fun ComboBoxBase<*>.onAction(noinline action: (ActionEvent) -> Unit) = setOnAction(EventHandler(action))

inline fun ComboBoxBase<*>.onHidden(noinline action: (Event) -> Unit) = setOnHidden(EventHandler(action))

inline fun ComboBoxBase<*>.onHiding(noinline action: (Event) -> Unit) = setOnHiding(EventHandler(action))

inline fun ComboBoxBase<*>.onShowing(noinline action: (Event) -> Unit) = setOnShowing(EventHandler(action))

inline fun ComboBoxBase<*>.onShown(noinline action: (Event) -> Unit) = setOnShown(EventHandler(action))

inline fun <T> ComboBox<T>.converter(converter: StringConverterBuilder<T>.() -> Unit) = setConverter(converter.asConverter())

inline fun <T> ComboBox<T>.cellFactory(noinline callback: (ListView<T>) -> ListCell<T>) = setCellFactory(callback)