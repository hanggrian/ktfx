@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.Bindings.equal
import javafx.beans.binding.Bindings.greaterThan
import javafx.beans.binding.Bindings.greaterThanOrEqual
import javafx.beans.binding.Bindings.lessThan
import javafx.beans.binding.Bindings.lessThanOrEqual
import javafx.beans.binding.Bindings.max
import javafx.beans.binding.Bindings.min
import javafx.beans.binding.Bindings.notEqual
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

/** Operator for [add]. */
inline operator fun Double.plus(op: ObservableNumberValue): DoubleBinding = Bindings.add(this, op)

/** Operator for [add]. */
inline operator fun DoubleExpression.plus(op: ObservableNumberValue): DoubleBinding = add(op)

/** Operator for [add]. */
inline operator fun DoubleExpression.plus(op: Double): DoubleBinding = add(op)

/** Operator for [add]. */
inline operator fun DoubleExpression.plus(op: Float): DoubleBinding = add(op)

/** Operator for [add]. */
inline operator fun DoubleExpression.plus(op: Long): DoubleBinding = add(op)

/** Operator for [add]. */
inline operator fun DoubleExpression.plus(op: Int): DoubleBinding = add(op)

/** Operator for [add]. */
inline operator fun Float.plus(op: ObservableNumberValue): FloatBinding = Bindings.add(this, op) as FloatBinding

/** Operator for [add]. */
inline operator fun FloatExpression.plus(op: ObservableNumberValue): NumberBinding = add(op)

/** Operator for [add]. */
inline operator fun FloatExpression.plus(op: Double): DoubleBinding = add(op)

/** Operator for [add]. */
inline operator fun FloatExpression.plus(op: Float): FloatBinding = add(op)

/** Operator for [add]. */
inline operator fun FloatExpression.plus(op: Long): FloatBinding = add(op)

/** Operator for [add]. */
inline operator fun FloatExpression.plus(op: Int): FloatBinding = add(op)

/** Operator for [add]. */
inline operator fun Long.plus(op: ObservableNumberValue): LongBinding = Bindings.add(this, op) as LongBinding

/** Operator for [add]. */
inline operator fun LongExpression.plus(op: ObservableNumberValue): NumberBinding = add(op)

/** Operator for [add]. */
inline operator fun LongExpression.plus(op: Double): DoubleBinding = add(op)

/** Operator for [add]. */
inline operator fun LongExpression.plus(op: Float): FloatBinding = add(op)

/** Operator for [add]. */
inline operator fun LongExpression.plus(op: Long): LongBinding = add(op)

/** Operator for [add]. */
inline operator fun LongExpression.plus(op: Int): LongBinding = add(op)

/** Operator for [add]. */
inline operator fun Int.plus(op: ObservableNumberValue): IntegerBinding = Bindings.add(this, op) as IntegerBinding

/** Operator for [add]. */
inline operator fun IntegerExpression.plus(op: ObservableNumberValue): NumberBinding = add(op)

/** Operator for [add]. */
inline operator fun IntegerExpression.plus(op: Double): DoubleBinding = add(op)

/** Operator for [add]. */
inline operator fun IntegerExpression.plus(op: Float): FloatBinding = add(op)

/** Operator for [add]. */
inline operator fun IntegerExpression.plus(op: Long): LongBinding = add(op)

/** Operator for [add]. */
inline operator fun IntegerExpression.plus(op: Int): IntegerBinding = add(op)

/** Operator for [subtract]. */
inline operator fun Double.minus(op: ObservableNumberValue): DoubleBinding = Bindings.subtract(this, op)

/** Operator for [subtract]. */
inline operator fun DoubleExpression.minus(op: ObservableNumberValue): DoubleBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun DoubleExpression.minus(op: Double): DoubleBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun DoubleExpression.minus(op: Float): DoubleBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun DoubleExpression.minus(op: Long): DoubleBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun DoubleExpression.minus(op: Int): DoubleBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun Float.minus(op: ObservableNumberValue): FloatBinding = Bindings.subtract(this, op) as FloatBinding

/** Operator for [subtract]. */
inline operator fun FloatExpression.minus(op: ObservableNumberValue): NumberBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun FloatExpression.minus(op: Double): DoubleBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun FloatExpression.minus(op: Float): FloatBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun FloatExpression.minus(op: Long): FloatBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun FloatExpression.minus(op: Int): FloatBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun Long.minus(op: ObservableNumberValue): LongBinding = Bindings.subtract(this, op) as LongBinding

/** Operator for [subtract]. */
inline operator fun LongExpression.minus(op: ObservableNumberValue): NumberBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun LongExpression.minus(op: Double): DoubleBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun LongExpression.minus(op: Float): FloatBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun LongExpression.minus(op: Long): LongBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun LongExpression.minus(op: Int): LongBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun Int.minus(op: ObservableNumberValue): IntegerBinding = Bindings.subtract(this, op) as IntegerBinding

/** Operator for [subtract]. */
inline operator fun IntegerExpression.minus(op: ObservableNumberValue): NumberBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun IntegerExpression.minus(op: Double): DoubleBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun IntegerExpression.minus(op: Float): FloatBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun IntegerExpression.minus(op: Long): LongBinding = subtract(op)

/** Operator for [subtract]. */
inline operator fun IntegerExpression.minus(op: Int): IntegerBinding = subtract(op)

/** Operator for [multiply]. */
inline operator fun Double.times(op: ObservableNumberValue): DoubleBinding = Bindings.multiply(this, op)

/** Operator for [multiply]. */
inline operator fun DoubleExpression.times(op: ObservableNumberValue): DoubleBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun DoubleExpression.times(op: Double): DoubleBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun DoubleExpression.times(op: Float): DoubleBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun DoubleExpression.times(op: Long): DoubleBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun DoubleExpression.times(op: Int): DoubleBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun Float.times(op: ObservableNumberValue): FloatBinding = Bindings.multiply(this, op) as FloatBinding

/** Operator for [multiply]. */
inline operator fun FloatExpression.times(op: ObservableNumberValue): NumberBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun FloatExpression.times(op: Double): DoubleBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun FloatExpression.times(op: Float): FloatBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun FloatExpression.times(op: Long): FloatBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun FloatExpression.times(op: Int): FloatBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun Long.times(op: ObservableNumberValue): LongBinding = Bindings.multiply(this, op) as LongBinding

/** Operator for [multiply]. */
inline operator fun LongExpression.times(op: ObservableNumberValue): NumberBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun LongExpression.times(op: Double): DoubleBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun LongExpression.times(op: Float): FloatBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun LongExpression.times(op: Long): LongBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun LongExpression.times(op: Int): LongBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun Int.times(op: ObservableNumberValue): IntegerBinding = Bindings.multiply(this, op) as IntegerBinding

/** Operator for [multiply]. */
inline operator fun IntegerExpression.times(op: ObservableNumberValue): NumberBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun IntegerExpression.times(op: Double): DoubleBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun IntegerExpression.times(op: Float): FloatBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun IntegerExpression.times(op: Long): LongBinding = multiply(op)

/** Operator for [multiply]. */
inline operator fun IntegerExpression.times(op: Int): IntegerBinding = multiply(op)

/** Operator for [divide]. */
inline operator fun Double.div(op: ObservableNumberValue): DoubleBinding = Bindings.divide(this, op)

/** Operator for [divide]. */
inline operator fun DoubleExpression.div(op: ObservableNumberValue): DoubleBinding = divide(op)

/** Operator for [divide]. */
inline operator fun DoubleExpression.div(op: Double): DoubleBinding = divide(op)

/** Operator for [divide]. */
inline operator fun DoubleExpression.div(op: Float): DoubleBinding = divide(op)

/** Operator for [divide]. */
inline operator fun DoubleExpression.div(op: Long): DoubleBinding = divide(op)

/** Operator for [divide]. */
inline operator fun DoubleExpression.div(op: Int): DoubleBinding = divide(op)

/** Operator for [divide]. */
inline operator fun Float.div(op: ObservableNumberValue): FloatBinding = Bindings.divide(this, op) as FloatBinding

/** Operator for [divide]. */
inline operator fun FloatExpression.div(op: ObservableNumberValue): NumberBinding = divide(op)

/** Operator for [divide]. */
inline operator fun FloatExpression.div(op: Double): DoubleBinding = divide(op)

/** Operator for [divide]. */
inline operator fun FloatExpression.div(op: Float): FloatBinding = divide(op)

/** Operator for [divide]. */
inline operator fun FloatExpression.div(op: Long): FloatBinding = divide(op)

/** Operator for [divide]. */
inline operator fun FloatExpression.div(op: Int): FloatBinding = divide(op)

/** Operator for [divide]. */
inline operator fun Long.div(op: ObservableNumberValue): LongBinding = Bindings.divide(this, op) as LongBinding

/** Operator for [divide]. */
inline operator fun LongExpression.div(op: ObservableNumberValue): NumberBinding = divide(op)

/** Operator for [divide]. */
inline operator fun LongExpression.div(op: Double): DoubleBinding = divide(op)

/** Operator for [divide]. */
inline operator fun LongExpression.div(op: Float): FloatBinding = divide(op)

/** Operator for [divide]. */
inline operator fun LongExpression.div(op: Long): LongBinding = divide(op)

/** Operator for [divide]. */
inline operator fun LongExpression.div(op: Int): LongBinding = divide(op)

/** Operator for [divide]. */
inline operator fun Int.div(op: ObservableNumberValue): IntegerBinding = Bindings.divide(this, op) as IntegerBinding

/** Operator for [divide]. */
inline operator fun IntegerExpression.div(op: ObservableNumberValue): NumberBinding = divide(op)

/** Operator for [divide]. */
inline operator fun IntegerExpression.div(op: Double): DoubleBinding = divide(op)

/** Operator for [divide]. */
inline operator fun IntegerExpression.div(op: Float): FloatBinding = divide(op)

/** Operator for [divide]. */
inline operator fun IntegerExpression.div(op: Long): LongBinding = divide(op)

/** Operator for [divide]. */
inline operator fun IntegerExpression.div(op: Int): IntegerBinding = divide(op)

/** Infix typing for [equal]. */
inline infix fun ObservableNumberValue.eq(op: ObservableNumberValue): BooleanBinding = equal(this, op)

/** Infix typing for [equal]. */
inline infix fun ObservableNumberValue.eq(op: Double): BooleanBinding = equal(this, op, 0.0)

/** Infix typing for [equal]. */
inline infix fun Double.eq(op: ObservableNumberValue): BooleanBinding = equal(this, op, 0.0)

/** Infix typing for [equal]. */
inline infix fun ObservableNumberValue.eq(op: Float): BooleanBinding = equal(this, op, 0.0)

/** Infix typing for [equal]. */
inline infix fun Float.eq(op: ObservableNumberValue): BooleanBinding = equal(this, op, 0.0)

/** Infix typing for [equal]. */
inline infix fun ObservableNumberValue.eq(op: Long): BooleanBinding = equal(this, op)

/** Infix typing for [equal]. */
inline infix fun Long.eq(op: ObservableNumberValue): BooleanBinding = equal(this, op)

/** Infix typing for [equal]. */
inline infix fun ObservableNumberValue.eq(op: Int): BooleanBinding = equal(this, op)

/** Infix typing for [equal]. */
inline infix fun Int.eq(op: ObservableNumberValue): BooleanBinding = equal(this, op)

/** Infix typing for [notEqual]. */
inline infix fun ObservableNumberValue.neq(op: ObservableNumberValue): BooleanBinding = notEqual(this, op)

/** Infix typing for [notEqual]. */
inline infix fun ObservableNumberValue.neq(op: Double): BooleanBinding = notEqual(this, op, 0.0)

/** Infix typing for [notEqual]. */
inline infix fun Double.neq(op: ObservableNumberValue): BooleanBinding = notEqual(this, op, 0.0)

/** Infix typing for [notEqual]. */
inline infix fun ObservableNumberValue.neq(op: Float): BooleanBinding = notEqual(this, op, 0.0)

/** Infix typing for [notEqual]. */
inline infix fun Float.neq(op: ObservableNumberValue): BooleanBinding = notEqual(this, op, 0.0)

/** Infix typing for [notEqual]. */
inline infix fun ObservableNumberValue.neq(op: Long): BooleanBinding = notEqual(this, op)

/** Infix typing for [notEqual]. */
inline infix fun Long.neq(op: ObservableNumberValue): BooleanBinding = notEqual(this, op)

/** Infix typing for [notEqual]. */
inline infix fun ObservableNumberValue.neq(op: Int): BooleanBinding = notEqual(this, op)

/** Infix typing for [notEqual]. */
inline infix fun Int.neq(op: ObservableNumberValue): BooleanBinding = notEqual(this, op)

/** Infix typing for [greaterThan]. */
inline infix fun ObservableNumberValue.greater(op: ObservableNumberValue): BooleanBinding = greaterThan(this, op)

/** Infix typing for [greaterThan]. */
inline infix fun ObservableNumberValue.greater(op: Double): BooleanBinding = greaterThan(this, op)

/** Infix typing for [greaterThan]. */
inline infix fun Double.greater(op: ObservableNumberValue): BooleanBinding = greaterThan(this, op)

/** Infix typing for [greaterThan]. */
inline infix fun ObservableNumberValue.greater(op: Float): BooleanBinding = greaterThan(this, op)

/** Infix typing for [greaterThan]. */
inline infix fun Float.greater(op: ObservableNumberValue): BooleanBinding = greaterThan(this, op)

/** Infix typing for [greaterThan]. */
inline infix fun ObservableNumberValue.greater(op: Long): BooleanBinding = greaterThan(this, op)

/** Infix typing for [greaterThan]. */
inline infix fun Long.greater(op: ObservableNumberValue): BooleanBinding = greaterThan(this, op)

/** Infix typing for [greaterThan]. */
inline infix fun ObservableNumberValue.greater(op: Int): BooleanBinding = greaterThan(this, op)

/** Infix typing for [greaterThan]. */
inline infix fun Int.greater(op: ObservableNumberValue): BooleanBinding = greaterThan(this, op)

/** Infix typing for [lessThan]. */
inline infix fun ObservableNumberValue.less(op: ObservableNumberValue): BooleanBinding = lessThan(this, op)

/** Infix typing for [lessThan]. */
inline infix fun ObservableNumberValue.less(op: Double): BooleanBinding = lessThan(this, op)

/** Infix typing for [lessThan]. */
inline infix fun Double.less(op: ObservableNumberValue): BooleanBinding = lessThan(this, op)

/** Infix typing for [lessThan]. */
inline infix fun ObservableNumberValue.less(op: Float): BooleanBinding = lessThan(this, op)

/** Infix typing for [lessThan]. */
inline infix fun Float.less(op: ObservableNumberValue): BooleanBinding = lessThan(this, op)

/** Infix typing for [lessThan]. */
inline infix fun ObservableNumberValue.less(op: Long): BooleanBinding = lessThan(this, op)

/** Infix typing for [lessThan]. */
inline infix fun Long.less(op: ObservableNumberValue): BooleanBinding = lessThan(this, op)

/** Infix typing for [lessThan]. */
inline infix fun ObservableNumberValue.less(op: Int): BooleanBinding = lessThan(this, op)

/** Infix typing for [lessThan]. */
inline infix fun Int.less(op: ObservableNumberValue): BooleanBinding = lessThan(this, op)

/** Infix typing for [greaterThanOrEqual]. */
inline infix fun ObservableNumberValue.greaterEq(op: ObservableNumberValue): BooleanBinding =
    greaterThanOrEqual(this, op)

/** Infix typing for [greaterThanOrEqual]. */
inline infix fun ObservableNumberValue.greaterEq(op: Double): BooleanBinding = greaterThanOrEqual(this, op)

/** Infix typing for [greaterThanOrEqual]. */
inline infix fun Double.greaterEq(op: ObservableNumberValue): BooleanBinding = greaterThanOrEqual(this, op)

/** Infix typing for [greaterThanOrEqual]. */
inline infix fun ObservableNumberValue.greaterEq(op: Float): BooleanBinding = greaterThanOrEqual(this, op)

/** Infix typing for [greaterThanOrEqual]. */
inline infix fun Float.greaterEq(op: ObservableNumberValue): BooleanBinding = greaterThanOrEqual(this, op)

/** Infix typing for [greaterThanOrEqual]. */
inline infix fun ObservableNumberValue.greaterEq(op: Long): BooleanBinding = greaterThanOrEqual(this, op)

/** Infix typing for [greaterThanOrEqual]. */
inline infix fun Long.greaterEq(op: ObservableNumberValue): BooleanBinding = greaterThanOrEqual(this, op)

/** Infix typing for [greaterThanOrEqual]. */
inline infix fun ObservableNumberValue.greaterEq(op: Int): BooleanBinding = greaterThanOrEqual(this, op)

/** Infix typing for [greaterThanOrEqual]. */
inline infix fun Int.greaterEq(op: ObservableNumberValue): BooleanBinding = greaterThanOrEqual(this, op)

/** Infix typing for [lessThanOrEqual]. */
inline infix fun ObservableNumberValue.lessEq(op: ObservableNumberValue): BooleanBinding = lessThanOrEqual(this, op)

/** Infix typing for [lessThanOrEqual]. */
inline infix fun ObservableNumberValue.lessEq(op: Double): BooleanBinding = lessThanOrEqual(this, op)

/** Infix typing for [lessThanOrEqual]. */
inline infix fun Double.lessEq(op: ObservableNumberValue): BooleanBinding = lessThanOrEqual(this, op)

/** Infix typing for [lessThanOrEqual]. */
inline infix fun ObservableNumberValue.lessEq(op: Float): BooleanBinding = lessThanOrEqual(this, op)

/** Infix typing for [lessThanOrEqual]. */
inline infix fun Float.lessEq(op: ObservableNumberValue): BooleanBinding = lessThanOrEqual(this, op)

/** Infix typing for [lessThanOrEqual]. */
inline infix fun ObservableNumberValue.lessEq(op: Long): BooleanBinding = lessThanOrEqual(this, op)

/** Infix typing for [lessThanOrEqual]. */
inline infix fun Long.lessEq(op: ObservableNumberValue): BooleanBinding = lessThanOrEqual(this, op)

/** Infix typing for [lessThanOrEqual]. */
inline infix fun ObservableNumberValue.lessEq(op: Int): BooleanBinding = lessThanOrEqual(this, op)

/** Infix typing for [lessThanOrEqual]. */
inline infix fun Int.lessEq(op: ObservableNumberValue): BooleanBinding = lessThanOrEqual(this, op)

/** Infix typing for [min]. */
inline infix fun ObservableNumberValue.min(op: ObservableNumberValue): NumberBinding = min(this, op)

/** Infix typing for [min]. */
inline infix fun ObservableNumberValue.min(op: Double): DoubleBinding = min(this, op)

/** Infix typing for [min]. */
inline infix fun Double.min(op: ObservableNumberValue): DoubleBinding = min(this, op)

/** Infix typing for [min]. */
inline infix fun ObservableNumberValue.min(op: Float): FloatBinding = min(this, op) as FloatBinding

/** Infix typing for [min]. */
inline infix fun Float.min(op: ObservableNumberValue): FloatBinding = min(this, op) as FloatBinding

/** Infix typing for [min]. */
inline infix fun ObservableNumberValue.min(op: Long): LongBinding = min(this, op) as LongBinding

/** Infix typing for [min]. */
inline infix fun Long.min(op: ObservableNumberValue): LongBinding = min(this, op) as LongBinding

/** Infix typing for [min]. */
inline infix fun ObservableNumberValue.min(op: Int): IntegerBinding = min(this, op) as IntegerBinding

/** Infix typing for [min]. */
inline infix fun Int.min(op: ObservableNumberValue): IntegerBinding = min(this, op) as IntegerBinding

/** Infix typing for [max]. */
inline infix fun ObservableNumberValue.max(op: ObservableNumberValue): NumberBinding = max(this, op)

/** Infix typing for [max]. */
inline infix fun ObservableNumberValue.max(op: Double): DoubleBinding = max(this, op)

/** Infix typing for [max]. */
inline infix fun Double.max(op: ObservableNumberValue): DoubleBinding = max(this, op)

/** Infix typing for [max]. */
inline infix fun ObservableNumberValue.max(op: Float): FloatBinding = max(this, op) as FloatBinding

/** Infix typing for [max]. */
inline infix fun Float.max(op: ObservableNumberValue): FloatBinding = max(this, op) as FloatBinding

/** Infix typing for [max]. */
inline infix fun ObservableNumberValue.max(op: Long): LongBinding = max(this, op) as LongBinding

/** Infix typing for [max]. */
inline infix fun Long.max(op: ObservableNumberValue): LongBinding = max(this, op) as LongBinding

/** Infix typing for [max]. */
inline infix fun ObservableNumberValue.max(op: Int): IntegerBinding = max(this, op) as IntegerBinding

/** Infix typing for [max]. */
inline infix fun Int.max(op: ObservableNumberValue): IntegerBinding = max(this, op) as IntegerBinding
