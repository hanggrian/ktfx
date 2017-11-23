@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.bindings

import javafx.beans.binding.Bindings.equal
import javafx.beans.binding.Bindings.notEqual
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableObjectValue

inline infix fun ObservableObjectValue<*>.eq(other: ObservableObjectValue<*>): BooleanBinding = equal(this, other)
inline infix fun ObservableObjectValue<*>.eq(other: Any): BooleanBinding = equal(this, other)
inline infix fun Any.eq(other: ObservableObjectValue<*>): BooleanBinding = equal(this, other)

inline infix fun ObservableObjectValue<*>.neq(other: ObservableObjectValue<*>): BooleanBinding = notEqual(this, other)
inline infix fun ObservableObjectValue<*>.neq(other: Any): BooleanBinding = notEqual(this, other)
inline infix fun Any.neq(other: ObservableObjectValue<*>): BooleanBinding = notEqual(this, other)