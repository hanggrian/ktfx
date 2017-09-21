@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.binding.*
import javafx.beans.value.ObservableNumberValue

@PublishedApi internal const val DEFAULT_EPSILON = 0.0

inline operator fun ObservableNumberValue.plus(other: ObservableNumberValue): NumberBinding = Bindings.add(this, other)
inline operator fun ObservableNumberValue.plus(other: Double): NumberBinding = Bindings.add(this, other)
inline operator fun Double.plus(other: ObservableNumberValue): NumberBinding = Bindings.add(this, other)
inline operator fun ObservableNumberValue.plus(other: Float): NumberBinding = Bindings.add(this, other)
inline operator fun Float.plus(other: ObservableNumberValue): NumberBinding = Bindings.add(this, other)
inline operator fun ObservableNumberValue.plus(other: Long): NumberBinding = Bindings.add(this, other)
inline operator fun Long.plus(other: ObservableNumberValue): NumberBinding = Bindings.add(this, other)
inline operator fun ObservableNumberValue.plus(other: Int): NumberBinding = Bindings.add(this, other)
inline operator fun Int.plus(other: ObservableNumberValue): NumberBinding = Bindings.add(this, other)

inline operator fun ObservableNumberValue.minus(other: ObservableNumberValue): NumberBinding = Bindings.subtract(this, other)
inline operator fun ObservableNumberValue.minus(other: Double): NumberBinding = Bindings.subtract(this, other)
inline operator fun Double.minus(other: ObservableNumberValue): NumberBinding = Bindings.subtract(this, other)
inline operator fun ObservableNumberValue.minus(other: Float): NumberBinding = Bindings.subtract(this, other)
inline operator fun Float.minus(other: ObservableNumberValue): NumberBinding = Bindings.subtract(this, other)
inline operator fun ObservableNumberValue.minus(other: Long): NumberBinding = Bindings.subtract(this, other)
inline operator fun Long.minus(other: ObservableNumberValue): NumberBinding = Bindings.subtract(this, other)
inline operator fun ObservableNumberValue.minus(other: Int): NumberBinding = Bindings.subtract(this, other)
inline operator fun Int.minus(other: ObservableNumberValue): NumberBinding = Bindings.subtract(this, other)

inline operator fun ObservableNumberValue.times(other: ObservableNumberValue): NumberBinding = Bindings.multiply(this, other)
inline operator fun ObservableNumberValue.times(other: Double): NumberBinding = Bindings.multiply(this, other)
inline operator fun Double.times(other: ObservableNumberValue): NumberBinding = Bindings.multiply(this, other)
inline operator fun ObservableNumberValue.times(other: Float): NumberBinding = Bindings.multiply(this, other)
inline operator fun Float.times(other: ObservableNumberValue): NumberBinding = Bindings.multiply(this, other)
inline operator fun ObservableNumberValue.times(other: Long): NumberBinding = Bindings.multiply(this, other)
inline operator fun Long.times(other: ObservableNumberValue): NumberBinding = Bindings.multiply(this, other)
inline operator fun ObservableNumberValue.times(other: Int): NumberBinding = Bindings.multiply(this, other)
inline operator fun Int.times(other: ObservableNumberValue): NumberBinding = Bindings.multiply(this, other)

inline operator fun ObservableNumberValue.div(other: ObservableNumberValue): NumberBinding = Bindings.divide(this, other)
inline operator fun ObservableNumberValue.div(other: Double): NumberBinding = Bindings.divide(this, other)
inline operator fun Double.div(other: ObservableNumberValue): NumberBinding = Bindings.divide(this, other)
inline operator fun ObservableNumberValue.div(other: Float): NumberBinding = Bindings.divide(this, other)
inline operator fun Float.div(other: ObservableNumberValue): NumberBinding = Bindings.divide(this, other)
inline operator fun ObservableNumberValue.div(other: Long): NumberBinding = Bindings.divide(this, other)
inline operator fun Long.div(other: ObservableNumberValue): NumberBinding = Bindings.divide(this, other)
inline operator fun ObservableNumberValue.div(other: Int): NumberBinding = Bindings.divide(this, other)
inline operator fun Int.div(other: ObservableNumberValue): NumberBinding = Bindings.divide(this, other)

inline infix fun ObservableNumberValue.eq(other: ObservableNumberValue): BooleanBinding = Bindings.equal(this, other)
inline infix fun ObservableNumberValue.eq(other: Double): BooleanBinding = Bindings.equal(this, other, DEFAULT_EPSILON)
inline infix fun Double.eq(other: ObservableNumberValue): BooleanBinding = Bindings.equal(this, other, DEFAULT_EPSILON)
inline infix fun ObservableNumberValue.eq(other: Float): BooleanBinding = Bindings.equal(this, other, DEFAULT_EPSILON)
inline infix fun Float.eq(other: ObservableNumberValue): BooleanBinding = Bindings.equal(this, other, DEFAULT_EPSILON)
inline infix fun ObservableNumberValue.eq(other: Long): BooleanBinding = Bindings.equal(this, other)
inline infix fun Long.eq(other: ObservableNumberValue): BooleanBinding = Bindings.equal(this, other)
inline infix fun ObservableNumberValue.eq(other: Int): BooleanBinding = Bindings.equal(this, other)
inline infix fun Int.eq(other: ObservableNumberValue): BooleanBinding = Bindings.equal(this, other)

inline infix fun ObservableNumberValue.neq(other: ObservableNumberValue): BooleanBinding = Bindings.notEqual(this, other)
inline infix fun ObservableNumberValue.neq(other: Double): BooleanBinding = Bindings.notEqual(this, other, DEFAULT_EPSILON)
inline infix fun Double.neq(other: ObservableNumberValue): BooleanBinding = Bindings.notEqual(this, other, DEFAULT_EPSILON)
inline infix fun ObservableNumberValue.neq(other: Float): BooleanBinding = Bindings.notEqual(this, other, DEFAULT_EPSILON)
inline infix fun Float.neq(other: ObservableNumberValue): BooleanBinding = Bindings.notEqual(this, other, DEFAULT_EPSILON)
inline infix fun ObservableNumberValue.neq(other: Long): BooleanBinding = Bindings.notEqual(this, other)
inline infix fun Long.neq(other: ObservableNumberValue): BooleanBinding = Bindings.notEqual(this, other)
inline infix fun ObservableNumberValue.neq(other: Int): BooleanBinding = Bindings.notEqual(this, other)
inline infix fun Int.neq(other: ObservableNumberValue): BooleanBinding = Bindings.notEqual(this, other)

inline infix fun ObservableNumberValue.greater(other: ObservableNumberValue): BooleanBinding = Bindings.greaterThan(this, other)
inline infix fun ObservableNumberValue.greater(other: Double): BooleanBinding = Bindings.greaterThan(this, other)
inline infix fun Double.greater(other: ObservableNumberValue): BooleanBinding = Bindings.greaterThan(this, other)
inline infix fun ObservableNumberValue.greater(other: Float): BooleanBinding = Bindings.greaterThan(this, other)
inline infix fun Float.greater(other: ObservableNumberValue): BooleanBinding = Bindings.greaterThan(this, other)
inline infix fun ObservableNumberValue.greater(other: Long): BooleanBinding = Bindings.greaterThan(this, other)
inline infix fun Long.greater(other: ObservableNumberValue): BooleanBinding = Bindings.greaterThan(this, other)
inline infix fun ObservableNumberValue.greater(other: Int): BooleanBinding = Bindings.greaterThan(this, other)
inline infix fun Int.greater(other: ObservableNumberValue): BooleanBinding = Bindings.greaterThan(this, other)

inline infix fun ObservableNumberValue.less(other: ObservableNumberValue): BooleanBinding = Bindings.lessThan(this, other)
inline infix fun ObservableNumberValue.less(other: Double): BooleanBinding = Bindings.lessThan(this, other)
inline infix fun Double.less(other: ObservableNumberValue): BooleanBinding = Bindings.lessThan(this, other)
inline infix fun ObservableNumberValue.less(other: Float): BooleanBinding = Bindings.lessThan(this, other)
inline infix fun Float.less(other: ObservableNumberValue): BooleanBinding = Bindings.lessThan(this, other)
inline infix fun ObservableNumberValue.less(other: Long): BooleanBinding = Bindings.lessThan(this, other)
inline infix fun Long.less(other: ObservableNumberValue): BooleanBinding = Bindings.lessThan(this, other)
inline infix fun ObservableNumberValue.less(other: Int): BooleanBinding = Bindings.lessThan(this, other)
inline infix fun Int.less(other: ObservableNumberValue): BooleanBinding = Bindings.lessThan(this, other)

inline infix fun ObservableNumberValue.greaterEq(other: ObservableNumberValue): BooleanBinding = Bindings.greaterThanOrEqual(this, other)
inline infix fun ObservableNumberValue.greaterEq(other: Double): BooleanBinding = Bindings.greaterThanOrEqual(this, other)
inline infix fun Double.greaterEq(other: ObservableNumberValue): BooleanBinding = Bindings.greaterThanOrEqual(this, other)
inline infix fun ObservableNumberValue.greaterEq(other: Float): BooleanBinding = Bindings.greaterThanOrEqual(this, other)
inline infix fun Float.greaterEq(other: ObservableNumberValue): BooleanBinding = Bindings.greaterThanOrEqual(this, other)
inline infix fun ObservableNumberValue.greaterEq(other: Long): BooleanBinding = Bindings.greaterThanOrEqual(this, other)
inline infix fun Long.greaterEq(other: ObservableNumberValue): BooleanBinding = Bindings.greaterThanOrEqual(this, other)
inline infix fun ObservableNumberValue.greaterEq(other: Int): BooleanBinding = Bindings.greaterThanOrEqual(this, other)
inline infix fun Int.greaterEq(other: ObservableNumberValue): BooleanBinding = Bindings.greaterThanOrEqual(this, other)

inline infix fun ObservableNumberValue.lessEq(other: ObservableNumberValue): BooleanBinding = Bindings.lessThanOrEqual(this, other)
inline infix fun ObservableNumberValue.lessEq(other: Double): BooleanBinding = Bindings.lessThanOrEqual(this, other)
inline infix fun Double.lessEq(other: ObservableNumberValue): BooleanBinding = Bindings.lessThanOrEqual(this, other)
inline infix fun ObservableNumberValue.lessEq(other: Float): BooleanBinding = Bindings.lessThanOrEqual(this, other)
inline infix fun Float.lessEq(other: ObservableNumberValue): BooleanBinding = Bindings.lessThanOrEqual(this, other)
inline infix fun ObservableNumberValue.lessEq(other: Long): BooleanBinding = Bindings.lessThanOrEqual(this, other)
inline infix fun Long.lessEq(other: ObservableNumberValue): BooleanBinding = Bindings.lessThanOrEqual(this, other)
inline infix fun ObservableNumberValue.lessEq(other: Int): BooleanBinding = Bindings.lessThanOrEqual(this, other)
inline infix fun Int.lessEq(other: ObservableNumberValue): BooleanBinding = Bindings.lessThanOrEqual(this, other)

inline infix fun ObservableNumberValue.min(other: ObservableNumberValue): NumberBinding = Bindings.min(this, other)
inline infix fun ObservableNumberValue.min(other: Double): DoubleBinding = Bindings.min(this, other)
inline infix fun Double.min(other: ObservableNumberValue): DoubleBinding = Bindings.min(this, other)
inline infix fun ObservableNumberValue.min(other: Float): FloatBinding = Bindings.min(this, other) as FloatBinding
inline infix fun Float.min(other: ObservableNumberValue): FloatBinding = Bindings.min(this, other) as FloatBinding
inline infix fun ObservableNumberValue.min(other: Long): LongBinding = Bindings.min(this, other) as LongBinding
inline infix fun Long.min(other: ObservableNumberValue): LongBinding = Bindings.min(this, other) as LongBinding
inline infix fun ObservableNumberValue.min(other: Int): IntegerBinding = Bindings.min(this, other) as IntegerBinding
inline infix fun Int.min(other: ObservableNumberValue): IntegerBinding = Bindings.min(this, other) as IntegerBinding

inline infix fun ObservableNumberValue.max(other: ObservableNumberValue): NumberBinding = Bindings.max(this, other)
inline infix fun ObservableNumberValue.max(other: Double): DoubleBinding = Bindings.max(this, other)
inline infix fun Double.max(other: ObservableNumberValue): DoubleBinding = Bindings.max(this, other)
inline infix fun ObservableNumberValue.max(other: Float): FloatBinding = Bindings.max(this, other) as FloatBinding
inline infix fun Float.max(other: ObservableNumberValue): FloatBinding = Bindings.max(this, other) as FloatBinding
inline infix fun ObservableNumberValue.max(other: Long): LongBinding = Bindings.max(this, other) as LongBinding
inline infix fun Long.max(other: ObservableNumberValue): LongBinding = Bindings.max(this, other) as LongBinding
inline infix fun ObservableNumberValue.max(other: Int): IntegerBinding = Bindings.max(this, other) as IntegerBinding
inline infix fun Int.max(other: ObservableNumberValue): IntegerBinding = Bindings.max(this, other) as IntegerBinding