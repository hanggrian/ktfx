@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.value

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
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.LongBinding
import javafx.beans.binding.NumberBinding
import javafx.beans.value.ObservableNumberValue

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
inline infix fun ObservableNumberValue.greaterEq(op: ObservableNumberValue): BooleanBinding = greaterThanOrEqual(this, op)

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