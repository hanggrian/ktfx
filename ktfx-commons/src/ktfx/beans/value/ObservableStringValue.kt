@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.value

import javafx.beans.binding.Bindings.equal
import javafx.beans.binding.Bindings.equalIgnoreCase
import javafx.beans.binding.Bindings.greaterThan
import javafx.beans.binding.Bindings.greaterThanOrEqual
import javafx.beans.binding.Bindings.lessThan
import javafx.beans.binding.Bindings.lessThanOrEqual
import javafx.beans.binding.Bindings.notEqual
import javafx.beans.binding.Bindings.notEqualIgnoreCase
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableStringValue
import ktfx.beans.binding.booleanBindingOf

inline infix fun ObservableStringValue.eq(op: ObservableStringValue): BooleanBinding = equal(this, op)
inline infix fun ObservableStringValue.eq(op: String): BooleanBinding = equal(this, op)
inline infix fun String.eq(op: ObservableStringValue): BooleanBinding = equal(this, op)

inline infix fun ObservableStringValue.neq(op: ObservableStringValue): BooleanBinding = notEqual(this, op)
inline infix fun ObservableStringValue.neq(op: String): BooleanBinding = notEqual(this, op)
inline infix fun String.neq(op: ObservableStringValue): BooleanBinding = notEqual(this, op)

inline infix fun ObservableStringValue.eqIg(op: ObservableStringValue): BooleanBinding = equalIgnoreCase(this, op)
inline infix fun ObservableStringValue.eqIg(op: String): BooleanBinding = equalIgnoreCase(this, op)
inline infix fun String.eqIg(op: ObservableStringValue): BooleanBinding = equalIgnoreCase(this, op)

inline infix fun ObservableStringValue.neqIg(op: ObservableStringValue): BooleanBinding = notEqualIgnoreCase(this, op)
inline infix fun ObservableStringValue.neqIg(op: String): BooleanBinding = notEqualIgnoreCase(this, op)
inline infix fun String.neqIg(op: ObservableStringValue): BooleanBinding = notEqualIgnoreCase(this, op)

inline infix fun ObservableStringValue.greater(op: ObservableStringValue): BooleanBinding = greaterThan(this, op)
inline infix fun ObservableStringValue.greater(op: String): BooleanBinding = greaterThan(this, op)
inline infix fun String.greater(op: ObservableStringValue): BooleanBinding = greaterThan(this, op)

inline infix fun ObservableStringValue.less(op: ObservableStringValue): BooleanBinding = lessThan(this, op)
inline infix fun ObservableStringValue.less(op: String): BooleanBinding = lessThan(this, op)
inline infix fun String.less(op: ObservableStringValue): BooleanBinding = lessThan(this, op)

inline infix fun ObservableStringValue.greaterEq(op: ObservableStringValue): BooleanBinding = greaterThanOrEqual(this, op)
inline infix fun ObservableStringValue.greaterEq(op: String): BooleanBinding = greaterThanOrEqual(this, op)
inline infix fun String.greaterEq(op: ObservableStringValue): BooleanBinding = greaterThanOrEqual(this, op)

inline infix fun ObservableStringValue.lessEq(op: ObservableStringValue): BooleanBinding = lessThanOrEqual(this, op)
inline infix fun ObservableStringValue.lessEq(op: String): BooleanBinding = lessThanOrEqual(this, op)
inline infix fun String.lessEq(op: ObservableStringValue): BooleanBinding = lessThanOrEqual(this, op)

inline fun ObservableStringValue.isBlank(): BooleanBinding = booleanBindingOf(this) { get().isNullOrBlank() }

inline fun ObservableStringValue.isNotBlank(): BooleanBinding = booleanBindingOf(this) { get().isNotBlank() }