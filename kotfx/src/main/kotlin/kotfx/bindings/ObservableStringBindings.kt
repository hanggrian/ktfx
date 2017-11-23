@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.bindings

import javafx.beans.binding.Bindings.*
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableStringValue

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