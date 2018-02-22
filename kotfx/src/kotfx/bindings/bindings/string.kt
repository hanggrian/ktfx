@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.Bindings.createStringBinding
import javafx.beans.binding.Bindings.equal
import javafx.beans.binding.Bindings.equalIgnoreCase
import javafx.beans.binding.Bindings.greaterThan
import javafx.beans.binding.Bindings.greaterThanOrEqual
import javafx.beans.binding.Bindings.lessThan
import javafx.beans.binding.Bindings.lessThanOrEqual
import javafx.beans.binding.Bindings.notEqual
import javafx.beans.binding.Bindings.notEqualIgnoreCase
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.StringBinding
import javafx.beans.property.Property
import javafx.beans.property.StringProperty
import javafx.beans.value.ObservableStringValue
import kotfx._StringConverter
import kotfx.internal.asConverter
import java.util.concurrent.Callable

/** Helper function to create a custom [StringBinding]. */
inline fun stringBindingOf(vararg dependencies: Observable, noinline func: () -> String): StringBinding = createStringBinding(Callable(func), *dependencies)

fun <T> Property<String>.bindBidirectional(
    property: Property<T>,
    converter: _StringConverter<T>.() -> Unit
) = Bindings.bindBidirectional(this, property, converter.asConverter())

fun <T> StringProperty.bindBidirectional(
    property: Property<T>,
    converter: _StringConverter<T>.() -> Unit
) = bindBidirectional(property, converter.asConverter())

inline infix fun ObservableStringValue.eq(other: ObservableStringValue): BooleanBinding = equal(this, other)
inline infix fun ObservableStringValue.eq(other: String): BooleanBinding = equal(this, other)
inline infix fun String.eq(other: ObservableStringValue): BooleanBinding = equal(this, other)

inline infix fun ObservableStringValue.neq(other: ObservableStringValue): BooleanBinding = notEqual(this, other)
inline infix fun ObservableStringValue.neq(other: String): BooleanBinding = notEqual(this, other)
inline infix fun String.neq(other: ObservableStringValue): BooleanBinding = notEqual(this, other)

inline infix fun ObservableStringValue.eqIg(other: ObservableStringValue): BooleanBinding = equalIgnoreCase(this, other)
inline infix fun ObservableStringValue.eqIg(other: String): BooleanBinding = equalIgnoreCase(this, other)
inline infix fun String.eqIg(other: ObservableStringValue): BooleanBinding = equalIgnoreCase(this, other)

inline infix fun ObservableStringValue.neqIg(other: ObservableStringValue): BooleanBinding = notEqualIgnoreCase(this, other)
inline infix fun ObservableStringValue.neqIg(other: String): BooleanBinding = notEqualIgnoreCase(this, other)
inline infix fun String.neqIg(other: ObservableStringValue): BooleanBinding = notEqualIgnoreCase(this, other)

inline infix fun ObservableStringValue.greater(other: ObservableStringValue): BooleanBinding = greaterThan(this, other)
inline infix fun ObservableStringValue.greater(other: String): BooleanBinding = greaterThan(this, other)
inline infix fun String.greater(other: ObservableStringValue): BooleanBinding = greaterThan(this, other)

inline infix fun ObservableStringValue.less(other: ObservableStringValue): BooleanBinding = lessThan(this, other)
inline infix fun ObservableStringValue.less(other: String): BooleanBinding = lessThan(this, other)
inline infix fun String.less(other: ObservableStringValue): BooleanBinding = lessThan(this, other)

inline infix fun ObservableStringValue.greaterEq(other: ObservableStringValue): BooleanBinding = greaterThanOrEqual(this, other)
inline infix fun ObservableStringValue.greaterEq(other: String): BooleanBinding = greaterThanOrEqual(this, other)
inline infix fun String.greaterEq(other: ObservableStringValue): BooleanBinding = greaterThanOrEqual(this, other)

inline infix fun ObservableStringValue.lessEq(other: ObservableStringValue): BooleanBinding = lessThanOrEqual(this, other)
inline infix fun ObservableStringValue.lessEq(other: String): BooleanBinding = lessThanOrEqual(this, other)
inline infix fun String.lessEq(other: ObservableStringValue): BooleanBinding = lessThanOrEqual(this, other)