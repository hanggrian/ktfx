@file:Suppress("NOTHING_TO_INLINE")

package kotfx.beans.property

import javafx.beans.Observable
import javafx.beans.binding.Bindings.bindBidirectional
import javafx.beans.property.Property
import javafx.beans.property.StringProperty
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import kotfx.internal.asConverter
import kotfx.util.StringConverterBuilder

inline fun <T> ObservableValue<T>.listener(
    noinline listener: (Observable, oldValue: T, value: T) -> Unit
) = addListener(ChangeListener(listener))

inline fun <T> Property<String>.bindBidirectional(
    property: Property<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = bindBidirectional(this, property, converter.asConverter())

inline fun <T> StringProperty.bindBidirectional(
    property: Property<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = bindBidirectional(property, converter.asConverter())