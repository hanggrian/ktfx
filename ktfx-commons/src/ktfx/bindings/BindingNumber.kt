@file:JvmMultifileClass
@file:JvmName("BindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.DoubleExpression
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.FloatExpression
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.IntegerExpression
import javafx.beans.binding.LongBinding
import javafx.beans.binding.LongExpression
import javafx.beans.binding.NumberBinding
import javafx.beans.value.ObservableNumberValue

/** Operator for [Bindings.add]. */
operator fun Double.plus(op: ObservableNumberValue): DoubleBinding =
    Bindings.add(this, op)

/** Operator for [Bindings.add]. */
inline operator fun DoubleExpression.plus(op: ObservableNumberValue): DoubleBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun DoubleExpression.plus(op: Double): DoubleBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun DoubleExpression.plus(op: Float): DoubleBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun DoubleExpression.plus(op: Long): DoubleBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun DoubleExpression.plus(op: Int): DoubleBinding =
    add(op)

/** Operator for [Bindings.add]. */
operator fun Float.plus(op: ObservableNumberValue): FloatBinding =
    Bindings.add(this, op) as FloatBinding

/** Operator for [Bindings.add]. */
inline operator fun FloatExpression.plus(op: ObservableNumberValue): NumberBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun FloatExpression.plus(op: Double): DoubleBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun FloatExpression.plus(op: Float): FloatBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun FloatExpression.plus(op: Long): FloatBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun FloatExpression.plus(op: Int): FloatBinding =
    add(op)

/** Operator for [Bindings.add]. */
operator fun Long.plus(op: ObservableNumberValue): LongBinding =
    Bindings.add(this, op) as LongBinding

/** Operator for [Bindings.add]. */
inline operator fun LongExpression.plus(op: ObservableNumberValue): NumberBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun LongExpression.plus(op: Double): DoubleBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun LongExpression.plus(op: Float): FloatBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun LongExpression.plus(op: Long): LongBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun LongExpression.plus(op: Int): LongBinding =
    add(op)

/** Operator for [Bindings.add]. */
operator fun Int.plus(op: ObservableNumberValue): IntegerBinding =
    Bindings.add(this, op) as IntegerBinding

/** Operator for [Bindings.add]. */
inline operator fun IntegerExpression.plus(op: ObservableNumberValue): NumberBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun IntegerExpression.plus(op: Double): DoubleBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun IntegerExpression.plus(op: Float): FloatBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun IntegerExpression.plus(op: Long): LongBinding =
    add(op)

/** Operator for [Bindings.add]. */
inline operator fun IntegerExpression.plus(op: Int): IntegerBinding =
    add(op)

/** Operator for [Bindings.subtract]. */
operator fun Double.minus(op: ObservableNumberValue): DoubleBinding =
    Bindings.subtract(this, op)

/** Operator for [Bindings.subtract]. */
inline operator fun DoubleExpression.minus(op: ObservableNumberValue): DoubleBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun DoubleExpression.minus(op: Double): DoubleBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun DoubleExpression.minus(op: Float): DoubleBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun DoubleExpression.minus(op: Long): DoubleBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun DoubleExpression.minus(op: Int): DoubleBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
operator fun Float.minus(op: ObservableNumberValue): FloatBinding =
    Bindings.subtract(this, op) as FloatBinding

/** Operator for [Bindings.subtract]. */
inline operator fun FloatExpression.minus(op: ObservableNumberValue): NumberBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun FloatExpression.minus(op: Double): DoubleBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun FloatExpression.minus(op: Float): FloatBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun FloatExpression.minus(op: Long): FloatBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun FloatExpression.minus(op: Int): FloatBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
operator fun Long.minus(op: ObservableNumberValue): LongBinding =
    Bindings.subtract(this, op) as LongBinding

/** Operator for [Bindings.subtract]. */
inline operator fun LongExpression.minus(op: ObservableNumberValue): NumberBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun LongExpression.minus(op: Double): DoubleBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun LongExpression.minus(op: Float): FloatBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun LongExpression.minus(op: Long): LongBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun LongExpression.minus(op: Int): LongBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
operator fun Int.minus(op: ObservableNumberValue): IntegerBinding =
    Bindings.subtract(this, op) as IntegerBinding

/** Operator for [Bindings.subtract]. */
inline operator fun IntegerExpression.minus(op: ObservableNumberValue): NumberBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun IntegerExpression.minus(op: Double): DoubleBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun IntegerExpression.minus(op: Float): FloatBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun IntegerExpression.minus(op: Long): LongBinding =
    subtract(op)

/** Operator for [Bindings.subtract]. */
inline operator fun IntegerExpression.minus(op: Int): IntegerBinding =
    subtract(op)

/** Operator for [Bindings.multiply]. */
operator fun Double.times(op: ObservableNumberValue): DoubleBinding =
    Bindings.multiply(this, op)

/** Operator for [Bindings.multiply]. */
inline operator fun DoubleExpression.times(op: ObservableNumberValue): DoubleBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun DoubleExpression.times(op: Double): DoubleBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun DoubleExpression.times(op: Float): DoubleBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun DoubleExpression.times(op: Long): DoubleBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun DoubleExpression.times(op: Int): DoubleBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
operator fun Float.times(op: ObservableNumberValue): FloatBinding =
    Bindings.multiply(this, op) as FloatBinding

/** Operator for [Bindings.multiply]. */
inline operator fun FloatExpression.times(op: ObservableNumberValue): NumberBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun FloatExpression.times(op: Double): DoubleBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun FloatExpression.times(op: Float): FloatBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun FloatExpression.times(op: Long): FloatBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun FloatExpression.times(op: Int): FloatBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
operator fun Long.times(op: ObservableNumberValue): LongBinding =
    Bindings.multiply(this, op) as LongBinding

/** Operator for [Bindings.multiply]. */
inline operator fun LongExpression.times(op: ObservableNumberValue): NumberBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun LongExpression.times(op: Double): DoubleBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun LongExpression.times(op: Float): FloatBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun LongExpression.times(op: Long): LongBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun LongExpression.times(op: Int): LongBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
operator fun Int.times(op: ObservableNumberValue): IntegerBinding =
    Bindings.multiply(this, op) as IntegerBinding

/** Operator for [Bindings.multiply]. */
inline operator fun IntegerExpression.times(op: ObservableNumberValue): NumberBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun IntegerExpression.times(op: Double): DoubleBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun IntegerExpression.times(op: Float): FloatBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun IntegerExpression.times(op: Long): LongBinding =
    multiply(op)

/** Operator for [Bindings.multiply]. */
inline operator fun IntegerExpression.times(op: Int): IntegerBinding =
    multiply(op)

/** Operator for [Bindings.divide]. */
operator fun Double.div(op: ObservableNumberValue): DoubleBinding =
    Bindings.divide(this, op)

/** Operator for [Bindings.divide]. */
inline operator fun DoubleExpression.div(op: ObservableNumberValue): DoubleBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun DoubleExpression.div(op: Double): DoubleBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun DoubleExpression.div(op: Float): DoubleBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun DoubleExpression.div(op: Long): DoubleBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun DoubleExpression.div(op: Int): DoubleBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
operator fun Float.div(op: ObservableNumberValue): FloatBinding =
    Bindings.divide(this, op) as FloatBinding

/** Operator for [Bindings.divide]. */
inline operator fun FloatExpression.div(op: ObservableNumberValue): NumberBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun FloatExpression.div(op: Double): DoubleBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun FloatExpression.div(op: Float): FloatBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun FloatExpression.div(op: Long): FloatBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun FloatExpression.div(op: Int): FloatBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
operator fun Long.div(op: ObservableNumberValue): LongBinding =
    Bindings.divide(this, op) as LongBinding

/** Operator for [Bindings.divide]. */
inline operator fun LongExpression.div(op: ObservableNumberValue): NumberBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun LongExpression.div(op: Double): DoubleBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun LongExpression.div(op: Float): FloatBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun LongExpression.div(op: Long): LongBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun LongExpression.div(op: Int): LongBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
operator fun Int.div(op: ObservableNumberValue): IntegerBinding =
    Bindings.divide(this, op) as IntegerBinding

/** Operator for [Bindings.divide]. */
inline operator fun IntegerExpression.div(op: ObservableNumberValue): NumberBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun IntegerExpression.div(op: Double): DoubleBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun IntegerExpression.div(op: Float): FloatBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun IntegerExpression.div(op: Long): LongBinding =
    divide(op)

/** Operator for [Bindings.divide]. */
inline operator fun IntegerExpression.div(op: Int): IntegerBinding =
    divide(op)

/** Infix typing for [Bindings.equal]. */
infix fun ObservableNumberValue.eq(op: ObservableNumberValue): BooleanBinding =
    Bindings.equal(this, op)

/** Infix typing for [Bindings.equal]. */
inline infix fun ObservableNumberValue.eq(op: Double): BooleanBinding =
    Bindings.equal(this, op, 0.0)

/** Infix typing for [Bindings.equal]. */
inline infix fun Double.eq(op: ObservableNumberValue): BooleanBinding =
    Bindings.equal(this, op, 0.0)

/** Infix typing for [Bindings.equal]. */
inline infix fun ObservableNumberValue.eq(op: Float): BooleanBinding =
    Bindings.equal(this, op, 0.0)

/** Infix typing for [Bindings.equal]. */
inline infix fun Float.eq(op: ObservableNumberValue): BooleanBinding =
    Bindings.equal(this, op, 0.0)

/** Infix typing for [Bindings.equal]. */
inline infix fun ObservableNumberValue.eq(op: Long): BooleanBinding =
    Bindings.equal(this, op)

/** Infix typing for [Bindings.equal]. */
inline infix fun Long.eq(op: ObservableNumberValue): BooleanBinding =
    Bindings.equal(this, op)

/** Infix typing for [Bindings.equal]. */
inline infix fun ObservableNumberValue.eq(op: Int): BooleanBinding =
    Bindings.equal(this, op)

/** Infix typing for [Bindings.equal]. */
inline infix fun Int.eq(op: ObservableNumberValue): BooleanBinding =
    Bindings.equal(this, op)

/** Infix typing for [Bindings.notEqual]. */
inline infix fun ObservableNumberValue.neq(op: ObservableNumberValue): BooleanBinding =
    Bindings.notEqual(this, op)

/** Infix typing for [Bindings.notEqual]. */
inline infix fun ObservableNumberValue.neq(op: Double): BooleanBinding =
    Bindings.notEqual(this, op, 0.0)

/** Infix typing for [Bindings.notEqual]. */
inline infix fun Double.neq(op: ObservableNumberValue): BooleanBinding =
    Bindings.notEqual(this, op, 0.0)

/** Infix typing for [Bindings.notEqual]. */
inline infix fun ObservableNumberValue.neq(op: Float): BooleanBinding =
    Bindings.notEqual(this, op, 0.0)

/** Infix typing for [Bindings.notEqual]. */
inline infix fun Float.neq(op: ObservableNumberValue): BooleanBinding =
    Bindings.notEqual(this, op, 0.0)

/** Infix typing for [Bindings.notEqual]. */
inline infix fun ObservableNumberValue.neq(op: Long): BooleanBinding =
    Bindings.notEqual(this, op)

/** Infix typing for [Bindings.notEqual]. */
inline infix fun Long.neq(op: ObservableNumberValue): BooleanBinding =
    Bindings.notEqual(this, op)

/** Infix typing for [Bindings.notEqual]. */
inline infix fun ObservableNumberValue.neq(op: Int): BooleanBinding =
    Bindings.notEqual(this, op)

/** Infix typing for [Bindings.notEqual]. */
inline infix fun Int.neq(op: ObservableNumberValue): BooleanBinding =
    Bindings.notEqual(this, op)

/** Infix typing for [Bindings.greaterThan]. */
inline infix fun ObservableNumberValue.greater(op: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThan(this, op)

/** Infix typing for [Bindings.greaterThan]. */
inline infix fun ObservableNumberValue.greater(op: Double): BooleanBinding =
    Bindings.greaterThan(this, op)

/** Infix typing for [Bindings.greaterThan]. */
inline infix fun Double.greater(op: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThan(this, op)

/** Infix typing for [Bindings.greaterThan]. */
inline infix fun ObservableNumberValue.greater(op: Float): BooleanBinding =
    Bindings.greaterThan(this, op)

/** Infix typing for [Bindings.greaterThan]. */
inline infix fun Float.greater(op: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThan(this, op)

/** Infix typing for [Bindings.greaterThan]. */
inline infix fun ObservableNumberValue.greater(op: Long): BooleanBinding =
    Bindings.greaterThan(this, op)

/** Infix typing for [Bindings.greaterThan]. */
inline infix fun Long.greater(op: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThan(this, op)

/** Infix typing for [Bindings.greaterThan]. */
inline infix fun ObservableNumberValue.greater(op: Int): BooleanBinding =
    Bindings.greaterThan(this, op)

/** Infix typing for [Bindings.greaterThan]. */
inline infix fun Int.greater(op: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThan(this, op)

/** Infix typing for [Bindings.lessThan]. */
inline infix fun ObservableNumberValue.less(op: ObservableNumberValue): BooleanBinding =
    Bindings.lessThan(this, op)

/** Infix typing for [Bindings.lessThan]. */
inline infix fun ObservableNumberValue.less(op: Double): BooleanBinding =
    Bindings.lessThan(this, op)

/** Infix typing for [Bindings.lessThan]. */
inline infix fun Double.less(op: ObservableNumberValue): BooleanBinding =
    Bindings.lessThan(this, op)

/** Infix typing for [Bindings.lessThan]. */
inline infix fun ObservableNumberValue.less(op: Float): BooleanBinding =
    Bindings.lessThan(this, op)

/** Infix typing for [Bindings.lessThan]. */
inline infix fun Float.less(op: ObservableNumberValue): BooleanBinding =
    Bindings.lessThan(this, op)

/** Infix typing for [Bindings.lessThan]. */
inline infix fun ObservableNumberValue.less(op: Long): BooleanBinding =
    Bindings.lessThan(this, op)

/** Infix typing for [Bindings.lessThan]. */
inline infix fun Long.less(op: ObservableNumberValue): BooleanBinding =
    Bindings.lessThan(this, op)

/** Infix typing for [Bindings.lessThan]. */
inline infix fun ObservableNumberValue.less(op: Int): BooleanBinding =
    Bindings.lessThan(this, op)

/** Infix typing for [Bindings.lessThan]. */
inline infix fun Int.less(op: ObservableNumberValue): BooleanBinding =
    Bindings.lessThan(this, op)

/** Infix typing for [Bindings.greaterThanOrEqual]. */
inline infix fun ObservableNumberValue.greaterEq(op: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, op)

/** Infix typing for [Bindings.greaterThanOrEqual]. */
inline infix fun ObservableNumberValue.greaterEq(op: Double): BooleanBinding =
    Bindings.greaterThanOrEqual(this, op)

/** Infix typing for [Bindings.greaterThanOrEqual]. */
inline infix fun Double.greaterEq(op: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, op)

/** Infix typing for [Bindings.greaterThanOrEqual]. */
inline infix fun ObservableNumberValue.greaterEq(op: Float): BooleanBinding =
    Bindings.greaterThanOrEqual(this, op)

/** Infix typing for [Bindings.greaterThanOrEqual]. */
inline infix fun Float.greaterEq(op: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, op)

/** Infix typing for [Bindings.greaterThanOrEqual]. */
inline infix fun ObservableNumberValue.greaterEq(op: Long): BooleanBinding =
    Bindings.greaterThanOrEqual(this, op)

/** Infix typing for [Bindings.greaterThanOrEqual]. */
inline infix fun Long.greaterEq(op: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, op)

/** Infix typing for [Bindings.greaterThanOrEqual]. */
inline infix fun ObservableNumberValue.greaterEq(op: Int): BooleanBinding =
    Bindings.greaterThanOrEqual(this, op)

/** Infix typing for [Bindings.greaterThanOrEqual]. */
inline infix fun Int.greaterEq(op: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, op)

/** Infix typing for [Bindings.lessThanOrEqual]. */
inline infix fun ObservableNumberValue.lessEq(op: ObservableNumberValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, op)

/** Infix typing for [Bindings.lessThanOrEqual]. */
inline infix fun ObservableNumberValue.lessEq(op: Double): BooleanBinding =
    Bindings.lessThanOrEqual(this, op)

/** Infix typing for [Bindings.lessThanOrEqual]. */
inline infix fun Double.lessEq(op: ObservableNumberValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, op)

/** Infix typing for [Bindings.lessThanOrEqual]. */
inline infix fun ObservableNumberValue.lessEq(op: Float): BooleanBinding =
    Bindings.lessThanOrEqual(this, op)

/** Infix typing for [Bindings.lessThanOrEqual]. */
inline infix fun Float.lessEq(op: ObservableNumberValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, op)

/** Infix typing for [Bindings.lessThanOrEqual]. */
inline infix fun ObservableNumberValue.lessEq(op: Long): BooleanBinding =
    Bindings.lessThanOrEqual(this, op)

/** Infix typing for [Bindings.lessThanOrEqual]. */
inline infix fun Long.lessEq(op: ObservableNumberValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, op)

/** Infix typing for [Bindings.lessThanOrEqual]. */
inline infix fun ObservableNumberValue.lessEq(op: Int): BooleanBinding =
    Bindings.lessThanOrEqual(this, op)

/** Infix typing for [Bindings.lessThanOrEqual]. */
inline infix fun Int.lessEq(op: ObservableNumberValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, op)

/** Infix typing for [Bindings.min]. */
inline infix fun ObservableNumberValue.min(op: ObservableNumberValue): NumberBinding =
    Bindings.min(this, op)

/** Infix typing for [Bindings.min]. */
inline infix fun ObservableNumberValue.min(op: Double): DoubleBinding =
    Bindings.min(this, op)

/** Infix typing for [Bindings.min]. */
inline infix fun Double.min(op: ObservableNumberValue): DoubleBinding =
    Bindings.min(this, op)

/** Infix typing for [Bindings.min]. */
inline infix fun ObservableNumberValue.min(op: Float): FloatBinding =
    Bindings.min(this, op) as FloatBinding

/** Infix typing for [Bindings.min]. */
inline infix fun Float.min(op: ObservableNumberValue): FloatBinding =
    Bindings.min(this, op) as FloatBinding

/** Infix typing for [Bindings.min]. */
inline infix fun ObservableNumberValue.min(op: Long): LongBinding =
    Bindings.min(this, op) as LongBinding

/** Infix typing for [Bindings.min]. */
inline infix fun Long.min(op: ObservableNumberValue): LongBinding =
    Bindings.min(this, op) as LongBinding

/** Infix typing for [Bindings.min]. */
inline infix fun ObservableNumberValue.min(op: Int): IntegerBinding =
    Bindings.min(this, op) as IntegerBinding

/** Infix typing for [Bindings.min]. */
inline infix fun Int.min(op: ObservableNumberValue): IntegerBinding =
    Bindings.min(this, op) as IntegerBinding

/** Infix typing for [Bindings.max]. */
inline infix fun ObservableNumberValue.max(op: ObservableNumberValue): NumberBinding =
    Bindings.max(this, op)

/** Infix typing for [Bindings.max]. */
inline infix fun ObservableNumberValue.max(op: Double): DoubleBinding =
    Bindings.max(this, op)

/** Infix typing for [Bindings.max]. */
inline infix fun Double.max(op: ObservableNumberValue): DoubleBinding =
    Bindings.max(this, op)

/** Infix typing for [Bindings.max]. */
inline infix fun ObservableNumberValue.max(op: Float): FloatBinding =
    Bindings.max(this, op) as FloatBinding

/** Infix typing for [Bindings.max]. */
inline infix fun Float.max(op: ObservableNumberValue): FloatBinding =
    Bindings.max(this, op) as FloatBinding

/** Infix typing for [Bindings.max]. */
inline infix fun ObservableNumberValue.max(op: Long): LongBinding =
    Bindings.max(this, op) as LongBinding

/** Infix typing for [Bindings.max]. */
inline infix fun Long.max(op: ObservableNumberValue): LongBinding =
    Bindings.max(this, op) as LongBinding

/** Infix typing for [Bindings.max]. */
inline infix fun ObservableNumberValue.max(op: Int): IntegerBinding =
    Bindings.max(this, op) as IntegerBinding

/** Infix typing for [Bindings.max]. */
inline infix fun Int.max(op: ObservableNumberValue): IntegerBinding =
    Bindings.max(this, op) as IntegerBinding
