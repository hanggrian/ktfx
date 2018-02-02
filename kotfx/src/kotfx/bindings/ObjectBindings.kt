@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.Bindings.*
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.value.ObservableObjectValue
import kotfx.properties.ObservableAnyValue
import java.util.concurrent.Callable

/** Helper function to create a custom [ObjectBinding]. */
inline fun <T> bindingOf(vararg dependencies: Observable, noinline func: () -> T?): ObjectBinding<T?> = createObjectBinding(Callable(func), *dependencies)

inline infix fun ObservableAnyValue<*>.eq(other: ObservableAnyValue<*>): BooleanBinding = equal(this, other)
inline infix fun ObservableAnyValue<*>.eq(other: Any): BooleanBinding = equal(this, other)
inline infix fun Any.eq(other: ObservableObjectValue<*>): BooleanBinding = equal(this, other)

inline infix fun ObservableAnyValue<*>.neq(other: ObservableAnyValue<*>): BooleanBinding = notEqual(this, other)
inline infix fun ObservableAnyValue<*>.neq(other: Any): BooleanBinding = notEqual(this, other)
inline infix fun Any.neq(other: ObservableAnyValue<*>): BooleanBinding = notEqual(this, other)