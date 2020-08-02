@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.LongBinding
import javafx.beans.binding.NumberBinding
import javafx.beans.value.ObservableNumberValue

/** Infix alias of [Bindings.equal]. */
inline infix fun ObservableNumberValue.eq(op: ObservableNumberValue): BooleanBinding = Bindings.equal(this, op)

/** Infix alias of [Bindings.equal]. */
inline infix fun ObservableNumberValue.eq(op: Double): BooleanBinding = Bindings.equal(this, op, 0.0)

/** Infix alias of [Bindings.equal]. */
inline infix fun Double.eq(op: ObservableNumberValue): BooleanBinding = Bindings.equal(this, op, 0.0)

/** Infix alias of [Bindings.equal]. */
inline infix fun ObservableNumberValue.eq(op: Float): BooleanBinding = Bindings.equal(this, op, 0.0)

/** Infix alias of [Bindings.equal]. */
inline infix fun Float.eq(op: ObservableNumberValue): BooleanBinding = Bindings.equal(this, op, 0.0)

/** Infix alias of [Bindings.equal]. */
inline infix fun ObservableNumberValue.eq(op: Long): BooleanBinding = Bindings.equal(this, op)

/** Infix alias of [Bindings.equal]. */
inline infix fun Long.eq(op: ObservableNumberValue): BooleanBinding = Bindings.equal(this, op)

/** Infix alias of [Bindings.equal]. */
inline infix fun ObservableNumberValue.eq(op: Int): BooleanBinding = Bindings.equal(this, op)

/** Infix alias of [Bindings.equal]. */
inline infix fun Int.eq(op: ObservableNumberValue): BooleanBinding = Bindings.equal(this, op)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun ObservableNumberValue.neq(op: ObservableNumberValue): BooleanBinding = Bindings.notEqual(this, op)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun ObservableNumberValue.neq(op: Double): BooleanBinding = Bindings.notEqual(this, op, 0.0)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun Double.neq(op: ObservableNumberValue): BooleanBinding = Bindings.notEqual(this, op, 0.0)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun ObservableNumberValue.neq(op: Float): BooleanBinding = Bindings.notEqual(this, op, 0.0)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun Float.neq(op: ObservableNumberValue): BooleanBinding = Bindings.notEqual(this, op, 0.0)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun ObservableNumberValue.neq(op: Long): BooleanBinding = Bindings.notEqual(this, op)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun Long.neq(op: ObservableNumberValue): BooleanBinding = Bindings.notEqual(this, op)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun ObservableNumberValue.neq(op: Int): BooleanBinding = Bindings.notEqual(this, op)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun Int.neq(op: ObservableNumberValue): BooleanBinding = Bindings.notEqual(this, op)

/** Infix alias of [Bindings.greaterThan]. */
inline infix fun ObservableNumberValue.greater(op: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThan(this, op)

/** Infix alias of [Bindings.greaterThan]. */
inline infix fun ObservableNumberValue.greater(op: Double): BooleanBinding = Bindings.greaterThan(this, op)

/** Infix alias of [Bindings.greaterThan]. */
inline infix fun Double.greater(op: ObservableNumberValue): BooleanBinding = Bindings.greaterThan(this, op)

/** Infix alias of [Bindings.greaterThan]. */
inline infix fun ObservableNumberValue.greater(op: Float): BooleanBinding = Bindings.greaterThan(this, op)

/** Infix alias of [Bindings.greaterThan]. */
inline infix fun Float.greater(op: ObservableNumberValue): BooleanBinding = Bindings.greaterThan(this, op)

/** Infix alias of [Bindings.greaterThan]. */
inline infix fun ObservableNumberValue.greater(op: Long): BooleanBinding = Bindings.greaterThan(this, op)

/** Infix alias of [Bindings.greaterThan]. */
inline infix fun Long.greater(op: ObservableNumberValue): BooleanBinding = Bindings.greaterThan(this, op)

/** Infix alias of [Bindings.greaterThan]. */
inline infix fun ObservableNumberValue.greater(op: Int): BooleanBinding = Bindings.greaterThan(this, op)

/** Infix alias of [Bindings.greaterThan]. */
inline infix fun Int.greater(op: ObservableNumberValue): BooleanBinding = Bindings.greaterThan(this, op)

/** Infix alias of [Bindings.lessThan]. */
inline infix fun ObservableNumberValue.less(op: ObservableNumberValue): BooleanBinding = Bindings.lessThan(this, op)

/** Infix alias of [Bindings.lessThan]. */
inline infix fun ObservableNumberValue.less(op: Double): BooleanBinding = Bindings.lessThan(this, op)

/** Infix alias of [Bindings.lessThan]. */
inline infix fun Double.less(op: ObservableNumberValue): BooleanBinding = Bindings.lessThan(this, op)

/** Infix alias of [Bindings.lessThan]. */
inline infix fun ObservableNumberValue.less(op: Float): BooleanBinding = Bindings.lessThan(this, op)

/** Infix alias of [Bindings.lessThan]. */
inline infix fun Float.less(op: ObservableNumberValue): BooleanBinding = Bindings.lessThan(this, op)

/** Infix alias of [Bindings.lessThan]. */
inline infix fun ObservableNumberValue.less(op: Long): BooleanBinding = Bindings.lessThan(this, op)

/** Infix alias of [Bindings.lessThan]. */
inline infix fun Long.less(op: ObservableNumberValue): BooleanBinding = Bindings.lessThan(this, op)

/** Infix alias of [Bindings.lessThan]. */
inline infix fun ObservableNumberValue.less(op: Int): BooleanBinding = Bindings.lessThan(this, op)

/** Infix alias of [Bindings.lessThan]. */
inline infix fun Int.less(op: ObservableNumberValue): BooleanBinding = Bindings.lessThan(this, op)

/** Infix alias of [Bindings.greaterThanOrEqual]. */
inline infix fun ObservableNumberValue.greaterEq(op: ObservableNumberValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, op)

/** Infix alias of [Bindings.greaterThanOrEqual]. */
inline infix fun ObservableNumberValue.greaterEq(op: Double): BooleanBinding = Bindings.greaterThanOrEqual(this, op)

/** Infix alias of [Bindings.greaterThanOrEqual]. */
inline infix fun Double.greaterEq(op: ObservableNumberValue): BooleanBinding = Bindings.greaterThanOrEqual(this, op)

/** Infix alias of [Bindings.greaterThanOrEqual]. */
inline infix fun ObservableNumberValue.greaterEq(op: Float): BooleanBinding = Bindings.greaterThanOrEqual(this, op)

/** Infix alias of [Bindings.greaterThanOrEqual]. */
inline infix fun Float.greaterEq(op: ObservableNumberValue): BooleanBinding = Bindings.greaterThanOrEqual(this, op)

/** Infix alias of [Bindings.greaterThanOrEqual]. */
inline infix fun ObservableNumberValue.greaterEq(op: Long): BooleanBinding = Bindings.greaterThanOrEqual(this, op)

/** Infix alias of [Bindings.greaterThanOrEqual]. */
inline infix fun Long.greaterEq(op: ObservableNumberValue): BooleanBinding = Bindings.greaterThanOrEqual(this, op)

/** Infix alias of [Bindings.greaterThanOrEqual]. */
inline infix fun ObservableNumberValue.greaterEq(op: Int): BooleanBinding = Bindings.greaterThanOrEqual(this, op)

/** Infix alias of [Bindings.greaterThanOrEqual]. */
inline infix fun Int.greaterEq(op: ObservableNumberValue): BooleanBinding = Bindings.greaterThanOrEqual(this, op)

/** Infix alias of [Bindings.lessThanOrEqual]. */
inline infix fun ObservableNumberValue.lessEq(op: ObservableNumberValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, op)

/** Infix alias of [Bindings.lessThanOrEqual]. */
inline infix fun ObservableNumberValue.lessEq(op: Double): BooleanBinding = Bindings.lessThanOrEqual(this, op)

/** Infix alias of [Bindings.lessThanOrEqual]. */
inline infix fun Double.lessEq(op: ObservableNumberValue): BooleanBinding = Bindings.lessThanOrEqual(this, op)

/** Infix alias of [Bindings.lessThanOrEqual]. */
inline infix fun ObservableNumberValue.lessEq(op: Float): BooleanBinding = Bindings.lessThanOrEqual(this, op)

/** Infix alias of [Bindings.lessThanOrEqual]. */
inline infix fun Float.lessEq(op: ObservableNumberValue): BooleanBinding = Bindings.lessThanOrEqual(this, op)

/** Infix alias of [Bindings.lessThanOrEqual]. */
inline infix fun ObservableNumberValue.lessEq(op: Long): BooleanBinding = Bindings.lessThanOrEqual(this, op)

/** Infix alias of [Bindings.lessThanOrEqual]. */
inline infix fun Long.lessEq(op: ObservableNumberValue): BooleanBinding = Bindings.lessThanOrEqual(this, op)

/** Infix alias of [Bindings.lessThanOrEqual]. */
inline infix fun ObservableNumberValue.lessEq(op: Int): BooleanBinding = Bindings.lessThanOrEqual(this, op)

/** Infix alias of [Bindings.lessThanOrEqual]. */
inline infix fun Int.lessEq(op: ObservableNumberValue): BooleanBinding = Bindings.lessThanOrEqual(this, op)

/** Infix alias of [Bindings.min]. */
inline infix fun ObservableNumberValue.min(op: ObservableNumberValue): NumberBinding = Bindings.min(this, op)

/** Infix alias of [Bindings.min]. */
inline infix fun ObservableNumberValue.min(op: Double): DoubleBinding = Bindings.min(this, op)

/** Infix alias of [Bindings.min]. */
inline infix fun Double.min(op: ObservableNumberValue): DoubleBinding = Bindings.min(this, op)

/** Infix alias of [Bindings.min]. */
inline infix fun ObservableNumberValue.min(op: Float): FloatBinding = Bindings.min(this, op) as FloatBinding

/** Infix alias of [Bindings.min]. */
inline infix fun Float.min(op: ObservableNumberValue): FloatBinding = Bindings.min(this, op) as FloatBinding

/** Infix alias of [Bindings.min]. */
inline infix fun ObservableNumberValue.min(op: Long): LongBinding = Bindings.min(this, op) as LongBinding

/** Infix alias of [Bindings.min]. */
inline infix fun Long.min(op: ObservableNumberValue): LongBinding = Bindings.min(this, op) as LongBinding

/** Infix alias of [Bindings.min]. */
inline infix fun ObservableNumberValue.min(op: Int): IntegerBinding = Bindings.min(this, op) as IntegerBinding

/** Infix alias of [Bindings.min]. */
inline infix fun Int.min(op: ObservableNumberValue): IntegerBinding = Bindings.min(this, op) as IntegerBinding

/** Infix alias of [Bindings.max]. */
inline infix fun ObservableNumberValue.max(op: ObservableNumberValue): NumberBinding = Bindings.max(this, op)

/** Infix alias of [Bindings.max]. */
inline infix fun ObservableNumberValue.max(op: Double): DoubleBinding = Bindings.max(this, op)

/** Infix alias of [Bindings.max]. */
inline infix fun Double.max(op: ObservableNumberValue): DoubleBinding = Bindings.max(this, op)

/** Infix alias of [Bindings.max]. */
inline infix fun ObservableNumberValue.max(op: Float): FloatBinding = Bindings.max(this, op) as FloatBinding

/** Infix alias of [Bindings.max]. */
inline infix fun Float.max(op: ObservableNumberValue): FloatBinding = Bindings.max(this, op) as FloatBinding

/** Infix alias of [Bindings.max]. */
inline infix fun ObservableNumberValue.max(op: Long): LongBinding = Bindings.max(this, op) as LongBinding

/** Infix alias of [Bindings.max]. */
inline infix fun Long.max(op: ObservableNumberValue): LongBinding = Bindings.max(this, op) as LongBinding

/** Infix alias of [Bindings.max]. */
inline infix fun ObservableNumberValue.max(op: Int): IntegerBinding = Bindings.max(this, op) as IntegerBinding

/** Infix alias of [Bindings.max]. */
inline infix fun Int.max(op: ObservableNumberValue): IntegerBinding = Bindings.max(this, op) as IntegerBinding
