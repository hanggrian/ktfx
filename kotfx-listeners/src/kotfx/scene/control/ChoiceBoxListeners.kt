@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.event.EventHandler
import javafx.scene.control.ChoiceBox
import kotfx.internal.asConverter
import kotfx.util.StringConverterBuilder

inline fun ChoiceBox<*>.onAction(noinline action: (ActionEvent) -> Unit) = setOnAction(EventHandler(action))

inline fun ChoiceBox<*>.onHidden(noinline action: (Event) -> Unit) = setOnHidden(EventHandler(action))

inline fun ChoiceBox<*>.onHiding(noinline action: (Event) -> Unit) = setOnHiding(EventHandler(action))

inline fun ChoiceBox<*>.onShowing(noinline action: (Event) -> Unit) = setOnShowing(EventHandler(action))

inline fun ChoiceBox<*>.onShown(noinline action: (Event) -> Unit) = setOnShown(EventHandler(action))

inline fun <T> ChoiceBox<T>.converter(converter: StringConverterBuilder<T>.() -> Unit) = setConverter(converter.asConverter())