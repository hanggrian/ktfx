@file:JvmMultifileClass
@file:JvmName("ObservableStringBindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.StringExpression
import javafx.beans.value.ObservableStringValue

/** @see StringExpression.isEqualTo */
inline infix fun ObservableStringValue.eq(other: ObservableStringValue): BooleanBinding = Bindings.equal(this, other)

/** @see StringExpression.isEqualTo */
inline infix fun ObservableStringValue.eq(other: String): BooleanBinding = Bindings.equal(this, other)

/** @see StringExpression.isNotEqualTo */
inline infix fun String.eq(other: ObservableStringValue): BooleanBinding = Bindings.equal(this, other)

/** @see StringExpression.isNotEqualTo */
inline infix fun ObservableStringValue.neq(other: ObservableStringValue): BooleanBinding =
    Bindings.notEqual(this, other)

/** @see StringExpression.isNotEqualTo */
inline infix fun ObservableStringValue.neq(other: String): BooleanBinding = Bindings.notEqual(this, other)

/** @see StringExpression.isNotEqualTo */
inline infix fun String.neq(other: ObservableStringValue): BooleanBinding = Bindings.notEqual(this, other)

/** @see StringExpression.isEqualToIgnoreCase */
inline infix fun ObservableStringValue.eqIg(other: ObservableStringValue): BooleanBinding =
    Bindings.equalIgnoreCase(this, other)

/** @see StringExpression.isEqualToIgnoreCase */
inline infix fun ObservableStringValue.eqIg(other: String): BooleanBinding = Bindings.equalIgnoreCase(this, other)

/** @see StringExpression.isEqualToIgnoreCase */
inline infix fun String.eqIg(other: ObservableStringValue): BooleanBinding = Bindings.equalIgnoreCase(this, other)

/** @see StringExpression.isNotEqualToIgnoreCase */
inline infix fun ObservableStringValue.neqIg(other: ObservableStringValue): BooleanBinding =
    Bindings.notEqualIgnoreCase(this, other)

/** @see StringExpression.isNotEqualToIgnoreCase */
inline infix fun ObservableStringValue.neqIg(other: String): BooleanBinding = Bindings.notEqualIgnoreCase(this, other)

/** @see StringExpression.isNotEqualToIgnoreCase */
inline infix fun String.neqIg(other: ObservableStringValue): BooleanBinding = Bindings.notEqualIgnoreCase(this, other)

/** @see StringExpression.greaterThan */
inline infix fun ObservableStringValue.greater(other: ObservableStringValue): BooleanBinding =
    Bindings.greaterThan(this, other)

/** @see StringExpression.greaterThan */
inline infix fun ObservableStringValue.greater(other: String): BooleanBinding = Bindings.greaterThan(this, other)

/** @see StringExpression.greaterThan */
inline infix fun String.greater(other: ObservableStringValue): BooleanBinding = Bindings.greaterThan(this, other)

/** @see StringExpression.lessThan */
inline infix fun ObservableStringValue.less(other: ObservableStringValue): BooleanBinding =
    Bindings.lessThan(this, other)

/** @see StringExpression.lessThan */
inline infix fun ObservableStringValue.less(other: String): BooleanBinding = Bindings.lessThan(this, other)

/** @see StringExpression.lessThan */
inline infix fun String.less(other: ObservableStringValue): BooleanBinding = Bindings.lessThan(this, other)

/** @see StringExpression.greaterThanOrEqualTo */
inline infix fun ObservableStringValue.greaterEq(other: ObservableStringValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/** @see StringExpression.greaterThanOrEqualTo */
inline infix fun ObservableStringValue.greaterEq(other: String): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/** @see StringExpression.greaterThanOrEqualTo */
inline infix fun String.greaterEq(other: ObservableStringValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/** @see StringExpression.lessThanOrEqualTo */
inline infix fun ObservableStringValue.lessEq(other: ObservableStringValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, other)

/** @see StringExpression.lessThanOrEqualTo */
inline infix fun ObservableStringValue.lessEq(other: String): BooleanBinding = Bindings.lessThanOrEqual(this, other)

/** @see StringExpression.lessThanOrEqualTo */
inline infix fun String.lessEq(other: ObservableStringValue): BooleanBinding = Bindings.lessThanOrEqual(this, other)

/** @see StringExpression.length */
inline fun ObservableStringValue.length(): IntegerBinding = Bindings.length(this)

/** @see StringExpression.isEmpty */
inline fun ObservableStringValue.isEmpty(): BooleanBinding = Bindings.isEmpty(this)

/** @see StringExpression.isNotEmpty */
inline fun ObservableStringValue.isNotEmpty(): BooleanBinding = Bindings.isNotEmpty(this)
