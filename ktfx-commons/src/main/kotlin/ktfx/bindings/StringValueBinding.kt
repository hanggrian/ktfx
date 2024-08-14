@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.StringExpression
import javafx.beans.value.ObservableStringValue

/**
 * @see StringExpression.isEqualTo
 */
public inline infix fun ObservableStringValue.eq(other: ObservableStringValue): BooleanBinding =
    Bindings.equal(this, other)

/**
 * @see StringExpression.isEqualTo
 */
public inline infix fun ObservableStringValue.eq(other: String): BooleanBinding =
    Bindings.equal(this, other)

/**
 * @see StringExpression.isNotEqualTo
 */
public inline infix fun String.eq(other: ObservableStringValue): BooleanBinding =
    Bindings.equal(this, other)

/**
 * @see StringExpression.isNotEqualTo
 */
public inline infix fun ObservableStringValue.neq(other: ObservableStringValue): BooleanBinding =
    Bindings.notEqual(this, other)

/**
 * @see StringExpression.isNotEqualTo
 */
public inline infix fun ObservableStringValue.neq(other: String): BooleanBinding =
    Bindings.notEqual(this, other)

/**
 * @see StringExpression.isNotEqualTo
 */
public inline infix fun String.neq(other: ObservableStringValue): BooleanBinding =
    Bindings.notEqual(this, other)

/**
 * @see StringExpression.isEqualToIgnoreCase
 */
public inline infix fun ObservableStringValue.eqIg(other: ObservableStringValue): BooleanBinding =
    Bindings.equalIgnoreCase(this, other)

/**
 * @see StringExpression.isEqualToIgnoreCase
 */
public inline infix fun ObservableStringValue.eqIg(other: String): BooleanBinding =
    Bindings.equalIgnoreCase(this, other)

/**
 * @see StringExpression.isEqualToIgnoreCase
 */
public inline infix fun String.eqIg(other: ObservableStringValue): BooleanBinding =
    Bindings.equalIgnoreCase(this, other)

/**
 * @see StringExpression.isNotEqualToIgnoreCase
 */
public inline infix fun ObservableStringValue.neqIg(other: ObservableStringValue): BooleanBinding =
    Bindings.notEqualIgnoreCase(this, other)

/**
 * @see StringExpression.isNotEqualToIgnoreCase
 */
public inline infix fun ObservableStringValue.neqIg(other: String): BooleanBinding =
    Bindings.notEqualIgnoreCase(this, other)

/**
 * @see StringExpression.isNotEqualToIgnoreCase
 */
public inline infix fun String.neqIg(other: ObservableStringValue): BooleanBinding =
    Bindings.notEqualIgnoreCase(this, other)

/**
 * @see StringExpression.greaterThan
 */
public inline infix fun ObservableStringValue.greater(
    other: ObservableStringValue,
): BooleanBinding = Bindings.greaterThan(this, other)

/**
 * @see StringExpression.greaterThan
 */
public inline infix fun ObservableStringValue.greater(other: String): BooleanBinding =
    Bindings.greaterThan(this, other)

/**
 * @see StringExpression.greaterThan
 */
public inline infix fun String.greater(other: ObservableStringValue): BooleanBinding =
    Bindings.greaterThan(this, other)

/**
 * @see StringExpression.lessThan
 */
public inline infix fun ObservableStringValue.less(other: ObservableStringValue): BooleanBinding =
    Bindings.lessThan(this, other)

/**
 * @see StringExpression.lessThan
 */
public inline infix fun ObservableStringValue.less(other: String): BooleanBinding =
    Bindings.lessThan(this, other)

/**
 * @see StringExpression.lessThan
 */
public inline infix fun String.less(other: ObservableStringValue): BooleanBinding =
    Bindings.lessThan(this, other)

/**
 * @see StringExpression.greaterThanOrEqualTo
 */
public inline infix fun ObservableStringValue.greaterEq(
    other: ObservableStringValue,
): BooleanBinding = Bindings.greaterThanOrEqual(this, other)

/**
 * @see StringExpression.greaterThanOrEqualTo
 */
public inline infix fun ObservableStringValue.greaterEq(other: String): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/**
 * @see StringExpression.greaterThanOrEqualTo
 */
public inline infix fun String.greaterEq(other: ObservableStringValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/**
 * @see StringExpression.lessThanOrEqualTo
 */
public inline infix fun ObservableStringValue.lessEq(other: ObservableStringValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, other)

/**
 * @see StringExpression.lessThanOrEqualTo
 */
public inline infix fun ObservableStringValue.lessEq(other: String): BooleanBinding =
    Bindings.lessThanOrEqual(this, other)

/**
 * @see StringExpression.lessThanOrEqualTo
 */
public inline infix fun String.lessEq(other: ObservableStringValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, other)

/**
 * @see StringExpression.length
 */
public inline val ObservableStringValue.sizeBinding: IntegerBinding get() = Bindings.length(this)

/**
 * @see StringExpression.isEmpty
 */
public inline val ObservableStringValue.emptyBinding: BooleanBinding get() = Bindings.isEmpty(this)

/**
 * @see StringExpression.isNotEmpty
 */
public inline val ObservableStringValue.notEmptyBinding: BooleanBinding
    get() = Bindings.isNotEmpty(this)
