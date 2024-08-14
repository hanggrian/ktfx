@file:JvmMultifileClass
@file:JvmName("NumberValueBindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.NumberBinding
import javafx.beans.binding.NumberExpressionBase
import javafx.beans.value.ObservableNumberValue

/**
 * @see NumberExpressionBase.add
 */
public inline operator fun ObservableNumberValue.plus(other: ObservableNumberValue): NumberBinding =
    Bindings.add(this, other)

/**
 * @see NumberExpressionBase.subtract
 */
public inline operator fun ObservableNumberValue.minus(
    other: ObservableNumberValue,
): NumberBinding = Bindings.subtract(this, other)

/**
 * @see NumberExpressionBase.multiply
 */
public inline operator fun ObservableNumberValue.times(
    other: ObservableNumberValue,
): NumberBinding = Bindings.multiply(this, other)

/**
 * @see NumberExpressionBase.divide
 */
public inline operator fun ObservableNumberValue.div(other: ObservableNumberValue): NumberBinding =
    Bindings.divide(this, other)

/**
 * @see NumberExpressionBase.isEqualTo
 */
public inline infix fun ObservableNumberValue.eq(other: ObservableNumberValue): BooleanBinding =
    Bindings.equal(this, other)

/**
 * @see NumberExpressionBase.isEqualTo
 */
public inline fun ObservableNumberValue.eq(
    other: ObservableNumberValue,
    epsilon: Double,
): BooleanBinding = Bindings.equal(this, other, epsilon)

/** This function is weirdly not inherited by [NumberExpressionBase]. */
public inline infix fun ObservableNumberValue.eq(other: Double): BooleanBinding =
    Bindings.equal(this, other, 0.0)

/** This function is weirdly not inherited by [NumberExpressionBase]. */
public inline infix fun Double.eq(other: ObservableNumberValue): BooleanBinding =
    Bindings.equal(this, other, 0.0)

/**
 * @see NumberExpressionBase.isEqualTo
 */
public inline fun ObservableNumberValue.eq(other: Double, epsilon: Double): BooleanBinding =
    Bindings.equal(this, other, epsilon)

/**
 * @see NumberExpressionBase.isEqualTo
 */
public inline fun Double.eq(other: ObservableNumberValue, epsilon: Double): BooleanBinding =
    Bindings.equal(this, other, epsilon)

/** This function is weirdly not inherited by [NumberExpressionBase]. */
public inline infix fun ObservableNumberValue.eq(other: Float): BooleanBinding =
    Bindings.equal(this, other, 0.0)

/** This function is weirdly not inherited by [NumberExpressionBase]. */
public inline infix fun Float.eq(other: ObservableNumberValue): BooleanBinding =
    Bindings.equal(this, other, 0.0)

/**
 * @see NumberExpressionBase.isEqualTo
 */
public inline fun ObservableNumberValue.eq(other: Float, epsilon: Double): BooleanBinding =
    Bindings.equal(this, other, epsilon)

/**
 * @see NumberExpressionBase.isEqualTo
 */
public inline fun Float.eq(other: ObservableNumberValue, epsilon: Double): BooleanBinding =
    Bindings.equal(this, other, epsilon)

/**
 * @see NumberExpressionBase.isEqualTo
 */
public inline infix fun ObservableNumberValue.eq(other: Long): BooleanBinding =
    Bindings.equal(this, other)

/**
 * @see NumberExpressionBase.isEqualTo
 */
public inline infix fun Long.eq(other: ObservableNumberValue): BooleanBinding =
    Bindings.equal(this, other)

/**
 * @see NumberExpressionBase.isEqualTo
 */
public inline fun ObservableNumberValue.eq(other: Long, epsilon: Double): BooleanBinding =
    Bindings.equal(this, other, epsilon)

/**
 * @see NumberExpressionBase.isEqualTo
 */
public inline fun Long.eq(other: ObservableNumberValue, epsilon: Double): BooleanBinding =
    Bindings.equal(this, other, epsilon)

/**
 * @see NumberExpressionBase.isEqualTo
 */
public inline infix fun ObservableNumberValue.eq(other: Int): BooleanBinding =
    Bindings.equal(this, other)

/**
 * @see NumberExpressionBase.isEqualTo
 */
public inline infix fun Int.eq(other: ObservableNumberValue): BooleanBinding =
    Bindings.equal(this, other)

/**
 * @see NumberExpressionBase.isEqualTo
 */
public inline fun ObservableNumberValue.eq(other: Int, epsilon: Double): BooleanBinding =
    Bindings.equal(this, other, epsilon)

/**
 * @see NumberExpressionBase.isEqualTo
 */
public inline fun Int.eq(other: ObservableNumberValue, epsilon: Double): BooleanBinding =
    Bindings.equal(this, other, epsilon)

/**
 * @see NumberExpressionBase.isNotEqualTo
 */
public inline infix fun ObservableNumberValue.neq(other: ObservableNumberValue): BooleanBinding =
    Bindings.notEqual(this, other)

/**
 * @see NumberExpressionBase.isNotEqualTo
 */
public inline fun ObservableNumberValue.neq(
    other: ObservableNumberValue,
    epsilon: Double,
): BooleanBinding = Bindings.notEqual(this, other, epsilon)

/** This function is weirdly not inherited by [NumberExpressionBase]. */
public inline infix fun ObservableNumberValue.neq(other: Double): BooleanBinding =
    Bindings.notEqual(this, other, 0.0)

/** This function is weirdly not inherited by [NumberExpressionBase]. */
public inline infix fun Double.neq(other: ObservableNumberValue): BooleanBinding =
    Bindings.notEqual(this, other, 0.0)

/**
 * @see NumberExpressionBase.isNotEqualTo
 */
public inline fun ObservableNumberValue.neq(other: Double, epsilon: Double): BooleanBinding =
    Bindings.notEqual(this, other, epsilon)

/**
 * @see NumberExpressionBase.isNotEqualTo
 */
public inline fun Double.neq(other: ObservableNumberValue, epsilon: Double): BooleanBinding =
    Bindings.notEqual(this, other, epsilon)

/** This function is weirdly not inherited by [NumberExpressionBase]. */
public inline infix fun ObservableNumberValue.neq(other: Float): BooleanBinding =
    Bindings.notEqual(this, other, 0.0)

/** This function is weirdly not inherited by [NumberExpressionBase]. */
public inline infix fun Float.neq(other: ObservableNumberValue): BooleanBinding =
    Bindings.notEqual(this, other, 0.0)

/**
 * @see NumberExpressionBase.isNotEqualTo
 */
public inline fun ObservableNumberValue.neq(other: Float, epsilon: Double): BooleanBinding =
    Bindings.notEqual(this, other, epsilon)

/**
 * @see NumberExpressionBase.isNotEqualTo
 */
public inline fun Float.neq(other: ObservableNumberValue, epsilon: Double): BooleanBinding =
    Bindings.notEqual(this, other, epsilon)

/**
 * @see NumberExpressionBase.isNotEqualTo
 */
public inline infix fun ObservableNumberValue.neq(other: Long): BooleanBinding =
    Bindings.notEqual(this, other)

/**
 * @see NumberExpressionBase.isNotEqualTo
 */
public inline infix fun Long.neq(other: ObservableNumberValue): BooleanBinding =
    Bindings.notEqual(this, other)

/**
 * @see NumberExpressionBase.isNotEqualTo
 */
public inline fun ObservableNumberValue.neq(other: Long, epsilon: Double): BooleanBinding =
    Bindings.notEqual(this, other, epsilon)

/**
 * @see NumberExpressionBase.isNotEqualTo
 */
public inline fun Long.neq(other: ObservableNumberValue, epsilon: Double): BooleanBinding =
    Bindings.notEqual(this, other, epsilon)

/**
 * @see NumberExpressionBase.isNotEqualTo
 */
public inline infix fun ObservableNumberValue.neq(other: Int): BooleanBinding =
    Bindings.notEqual(this, other)

/**
 * @see NumberExpressionBase.isNotEqualTo
 */
public inline infix fun Int.neq(other: ObservableNumberValue): BooleanBinding =
    Bindings.notEqual(this, other)

/**
 * @see NumberExpressionBase.isNotEqualTo
 */
public inline fun ObservableNumberValue.neq(other: Int, epsilon: Double): BooleanBinding =
    Bindings.notEqual(this, other, epsilon)

/**
 * @see NumberExpressionBase.isNotEqualTo
 */
public inline fun Int.neq(other: ObservableNumberValue, epsilon: Double): BooleanBinding =
    Bindings.notEqual(this, other, epsilon)

/**
 * @see NumberExpressionBase.greaterThan
 */
public inline infix fun ObservableNumberValue.greater(
    other: ObservableNumberValue,
): BooleanBinding = Bindings.greaterThan(this, other)

/**
 * @see NumberExpressionBase.greaterThan
 */
public inline infix fun ObservableNumberValue.greater(other: Double): BooleanBinding =
    Bindings.greaterThan(this, other)

/**
 * @see NumberExpressionBase.greaterThan
 */
public inline infix fun Double.greater(other: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThan(this, other)

/**
 * @see NumberExpressionBase.greaterThan
 */
public inline infix fun ObservableNumberValue.greater(other: Float): BooleanBinding =
    Bindings.greaterThan(this, other)

/**
 * @see NumberExpressionBase.greaterThan
 */
public inline infix fun Float.greater(other: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThan(this, other)

/**
 * @see NumberExpressionBase.greaterThan
 */
public inline infix fun ObservableNumberValue.greater(other: Long): BooleanBinding =
    Bindings.greaterThan(this, other)

/**
 * @see NumberExpressionBase.greaterThan
 */
public inline infix fun Long.greater(other: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThan(this, other)

/**
 * @see NumberExpressionBase.greaterThan
 */
public inline infix fun ObservableNumberValue.greater(other: Int): BooleanBinding =
    Bindings.greaterThan(this, other)

/**
 * @see NumberExpressionBase.greaterThan
 */
public inline infix fun Int.greater(other: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThan(this, other)

/**
 * @see NumberExpressionBase.lessThan
 */
public inline infix fun ObservableNumberValue.less(other: ObservableNumberValue): BooleanBinding =
    Bindings.lessThan(this, other)

/**
 * @see NumberExpressionBase.lessThan
 */
public inline infix fun ObservableNumberValue.less(other: Double): BooleanBinding =
    Bindings.lessThan(this, other)

/**
 * @see NumberExpressionBase.lessThan
 */
public inline infix fun Double.less(other: ObservableNumberValue): BooleanBinding =
    Bindings.lessThan(this, other)

/**
 * @see NumberExpressionBase.lessThan
 */
public inline infix fun ObservableNumberValue.less(other: Float): BooleanBinding =
    Bindings.lessThan(this, other)

/**
 * @see NumberExpressionBase.lessThan
 */
public inline infix fun Float.less(other: ObservableNumberValue): BooleanBinding =
    Bindings.lessThan(this, other)

/**
 * @see NumberExpressionBase.lessThan
 */
public inline infix fun ObservableNumberValue.less(other: Long): BooleanBinding =
    Bindings.lessThan(this, other)

/**
 * @see NumberExpressionBase.lessThan
 */
public inline infix fun Long.less(other: ObservableNumberValue): BooleanBinding =
    Bindings.lessThan(this, other)

/**
 * @see NumberExpressionBase.lessThan
 */
public inline infix fun ObservableNumberValue.less(other: Int): BooleanBinding =
    Bindings.lessThan(this, other)

/**
 * @see NumberExpressionBase.lessThan
 */
public inline infix fun Int.less(other: ObservableNumberValue): BooleanBinding =
    Bindings.lessThan(this, other)

/**
 * @see NumberExpressionBase.greaterThanOrEqualTo
 */
public inline infix fun ObservableNumberValue.greaterEq(
    other: ObservableNumberValue,
): BooleanBinding = Bindings.greaterThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.greaterThanOrEqualTo
 */
public inline infix fun ObservableNumberValue.greaterEq(other: Double): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.greaterThanOrEqualTo
 */
public inline infix fun Double.greaterEq(other: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.greaterThanOrEqualTo
 */
public inline infix fun ObservableNumberValue.greaterEq(other: Float): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.greaterThanOrEqualTo
 */
public inline infix fun Float.greaterEq(other: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.greaterThanOrEqualTo
 */
public inline infix fun ObservableNumberValue.greaterEq(other: Long): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.greaterThanOrEqualTo
 */
public inline infix fun Long.greaterEq(other: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.greaterThanOrEqualTo
 */
public inline infix fun ObservableNumberValue.greaterEq(other: Int): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.greaterThanOrEqualTo
 */
public inline infix fun Int.greaterEq(other: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.lessThanOrEqualTo
 */
public inline infix fun ObservableNumberValue.lessEq(other: ObservableNumberValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.lessThanOrEqualTo
 */
public inline infix fun ObservableNumberValue.lessEq(other: Double): BooleanBinding =
    Bindings.lessThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.lessThanOrEqualTo
 */
public inline infix fun Double.lessEq(other: ObservableNumberValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.lessThanOrEqualTo
 */
public inline infix fun ObservableNumberValue.lessEq(other: Float): BooleanBinding =
    Bindings.lessThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.lessThanOrEqualTo
 */
public inline infix fun Float.lessEq(other: ObservableNumberValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.lessThanOrEqualTo
 */
public inline infix fun ObservableNumberValue.lessEq(other: Long): BooleanBinding =
    Bindings.lessThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.lessThanOrEqualTo
 */
public inline infix fun Long.lessEq(other: ObservableNumberValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.lessThanOrEqualTo
 */
public inline infix fun ObservableNumberValue.lessEq(other: Int): BooleanBinding =
    Bindings.lessThanOrEqual(this, other)

/**
 * @see NumberExpressionBase.lessThanOrEqualTo
 */
public inline infix fun Int.lessEq(other: ObservableNumberValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, other)
