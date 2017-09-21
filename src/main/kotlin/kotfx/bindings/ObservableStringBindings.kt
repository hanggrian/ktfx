@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableStringValue

inline infix fun ObservableStringValue.eq(other: ObservableStringValue): BooleanBinding = Bindings.equal(this, other)
inline infix fun ObservableStringValue.eq(other: String): BooleanBinding = Bindings.equal(this, other)
inline infix fun String.eq(other: ObservableStringValue): BooleanBinding = Bindings.equal(this, other)

inline infix fun ObservableStringValue.neq(other: ObservableStringValue): BooleanBinding = Bindings.notEqual(this, other)
inline infix fun ObservableStringValue.neq(other: String): BooleanBinding = Bindings.notEqual(this, other)
inline infix fun String.neq(other: ObservableStringValue): BooleanBinding = Bindings.notEqual(this, other)

inline infix fun ObservableStringValue.eqIg(other: ObservableStringValue): BooleanBinding = Bindings.equalIgnoreCase(this, other)
inline infix fun ObservableStringValue.eqIg(other: String): BooleanBinding = Bindings.equalIgnoreCase(this, other)
inline infix fun String.eqIg(other: ObservableStringValue): BooleanBinding = Bindings.equalIgnoreCase(this, other)

inline infix fun ObservableStringValue.neqIg(other: ObservableStringValue): BooleanBinding = Bindings.notEqualIgnoreCase(this, other)
inline infix fun ObservableStringValue.neqIg(other: String): BooleanBinding = Bindings.notEqualIgnoreCase(this, other)
inline infix fun String.neqIg(other: ObservableStringValue): BooleanBinding = Bindings.notEqualIgnoreCase(this, other)

inline infix fun ObservableStringValue.greater(other: ObservableStringValue): BooleanBinding = Bindings.greaterThan(this, other)
inline infix fun ObservableStringValue.greater(other: String): BooleanBinding = Bindings.greaterThan(this, other)
inline infix fun String.greater(other: ObservableStringValue): BooleanBinding = Bindings.greaterThan(this, other)

inline infix fun ObservableStringValue.less(other: ObservableStringValue): BooleanBinding = Bindings.lessThan(this, other)
inline infix fun ObservableStringValue.less(other: String): BooleanBinding = Bindings.lessThan(this, other)
inline infix fun String.less(other: ObservableStringValue): BooleanBinding = Bindings.lessThan(this, other)

inline infix fun ObservableStringValue.greaterEq(other: ObservableStringValue): BooleanBinding = Bindings.greaterThanOrEqual(this, other)
inline infix fun ObservableStringValue.greaterEq(other: String): BooleanBinding = Bindings.greaterThanOrEqual(this, other)
inline infix fun String.greaterEq(other: ObservableStringValue): BooleanBinding = Bindings.greaterThanOrEqual(this, other)

inline infix fun ObservableStringValue.lessEq(other: ObservableStringValue): BooleanBinding = Bindings.lessThanOrEqual(this, other)
inline infix fun ObservableStringValue.lessEq(other: String): BooleanBinding = Bindings.lessThanOrEqual(this, other)
inline infix fun String.lessEq(other: ObservableStringValue): BooleanBinding = Bindings.lessThanOrEqual(this, other)