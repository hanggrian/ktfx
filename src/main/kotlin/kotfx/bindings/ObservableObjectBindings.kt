@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableObjectValue

inline infix fun ObservableObjectValue<*>.eq(other: ObservableObjectValue<*>): BooleanBinding = Bindings.equal(this, other)
inline infix fun ObservableObjectValue<*>.eq(other: Any): BooleanBinding = Bindings.equal(this, other)
inline infix fun Any.eq(other: ObservableObjectValue<*>): BooleanBinding = Bindings.equal(this, other)

inline infix fun ObservableObjectValue<*>.neq(other: ObservableObjectValue<*>): BooleanBinding = Bindings.notEqual(this, other)
inline infix fun ObservableObjectValue<*>.neq(other: Any): BooleanBinding = Bindings.notEqual(this, other)
inline infix fun Any.neq(other: ObservableObjectValue<*>): BooleanBinding = Bindings.notEqual(this, other)