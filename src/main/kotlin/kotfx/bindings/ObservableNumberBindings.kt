@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.binding.*
import javafx.beans.value.ObservableNumberValue

@PublishedApi internal const val DEFAULT_EPSILON = 0.0

inline operator fun Double.plus(other: ObservableNumberValue): DoubleBinding = Bindings.add(this, other)
inline operator fun DoubleExpression.plus(other: ObservableNumberValue): DoubleBinding = this.add(other)
inline operator fun DoubleExpression.plus(other: Double): DoubleBinding = this.add(other)
inline operator fun DoubleExpression.plus(other: Float): DoubleBinding = this.add(other)
inline operator fun DoubleExpression.plus(other: Long): DoubleBinding = this.add(other)
inline operator fun DoubleExpression.plus(other: Int): DoubleBinding = this.add(other)

inline operator fun Float.plus(other: ObservableNumberValue): FloatBinding = Bindings.add(this, other) as FloatBinding
inline operator fun FloatExpression.plus(other: ObservableNumberValue): NumberBinding = this.add(other)
inline operator fun FloatExpression.plus(other: Double): DoubleBinding = this.add(other)
inline operator fun FloatExpression.plus(other: Float): FloatBinding = this.add(other)
inline operator fun FloatExpression.plus(other: Long): FloatBinding = this.add(other)
inline operator fun FloatExpression.plus(other: Int): FloatBinding = this.add(other)

inline operator fun Long.plus(other: ObservableNumberValue): LongBinding = Bindings.add(this, other) as LongBinding
inline operator fun LongExpression.plus(other: ObservableNumberValue): NumberBinding = this.add(other)
inline operator fun LongExpression.plus(other: Double): DoubleBinding = this.add(other)
inline operator fun LongExpression.plus(other: Float): FloatBinding = this.add(other)
inline operator fun LongExpression.plus(other: Long): LongBinding = this.add(other)
inline operator fun LongExpression.plus(other: Int): LongBinding = this.add(other)

inline operator fun Int.plus(other: ObservableNumberValue): IntegerBinding = Bindings.add(this, other) as IntegerBinding
inline operator fun IntegerExpression.plus(other: ObservableNumberValue): NumberBinding = this.add(other)
inline operator fun IntegerExpression.plus(other: Double): DoubleBinding = this.add(other)
inline operator fun IntegerExpression.plus(other: Float): FloatBinding = this.add(other)
inline operator fun IntegerExpression.plus(other: Long): LongBinding = this.add(other)
inline operator fun IntegerExpression.plus(other: Int): IntegerBinding = this.add(other)

inline operator fun Double.minus(other: ObservableNumberValue): DoubleBinding = Bindings.subtract(this, other)
inline operator fun DoubleExpression.minus(other: ObservableNumberValue): DoubleBinding = this.subtract(other)
inline operator fun DoubleExpression.minus(other: Double): DoubleBinding = this.subtract(other)
inline operator fun DoubleExpression.minus(other: Float): DoubleBinding = this.subtract(other)
inline operator fun DoubleExpression.minus(other: Long): DoubleBinding = this.subtract(other)
inline operator fun DoubleExpression.minus(other: Int): DoubleBinding = this.subtract(other)

inline operator fun Float.minus(other: ObservableNumberValue): FloatBinding = Bindings.subtract(this, other) as FloatBinding
inline operator fun FloatExpression.minus(other: ObservableNumberValue): NumberBinding = this.subtract(other)
inline operator fun FloatExpression.minus(other: Double): DoubleBinding = this.subtract(other)
inline operator fun FloatExpression.minus(other: Float): FloatBinding = this.subtract(other)
inline operator fun FloatExpression.minus(other: Long): FloatBinding = this.subtract(other)
inline operator fun FloatExpression.minus(other: Int): FloatBinding = this.subtract(other)

inline operator fun Long.minus(other: ObservableNumberValue): LongBinding = Bindings.subtract(this, other) as LongBinding
inline operator fun LongExpression.minus(other: ObservableNumberValue): NumberBinding = this.subtract(other)
inline operator fun LongExpression.minus(other: Double): DoubleBinding = this.subtract(other)
inline operator fun LongExpression.minus(other: Float): FloatBinding = this.subtract(other)
inline operator fun LongExpression.minus(other: Long): LongBinding = this.subtract(other)
inline operator fun LongExpression.minus(other: Int): LongBinding = this.subtract(other)

inline operator fun Int.minus(other: ObservableNumberValue): IntegerBinding = Bindings.subtract(this, other) as IntegerBinding
inline operator fun IntegerExpression.minus(other: ObservableNumberValue): NumberBinding = this.subtract(other)
inline operator fun IntegerExpression.minus(other: Double): DoubleBinding = this.subtract(other)
inline operator fun IntegerExpression.minus(other: Float): FloatBinding = this.subtract(other)
inline operator fun IntegerExpression.minus(other: Long): LongBinding = this.subtract(other)
inline operator fun IntegerExpression.minus(other: Int): IntegerBinding = this.subtract(other)

inline operator fun Double.times(other: ObservableNumberValue): DoubleBinding = Bindings.multiply(this, other)
inline operator fun DoubleExpression.times(other: ObservableNumberValue): DoubleBinding = this.multiply(other)
inline operator fun DoubleExpression.times(other: Double): DoubleBinding = this.multiply(other)
inline operator fun DoubleExpression.times(other: Float): DoubleBinding = this.multiply(other)
inline operator fun DoubleExpression.times(other: Long): DoubleBinding = this.multiply(other)
inline operator fun DoubleExpression.times(other: Int): DoubleBinding = this.multiply(other)

inline operator fun Float.times(other: ObservableNumberValue): FloatBinding = Bindings.multiply(this, other) as FloatBinding
inline operator fun FloatExpression.times(other: ObservableNumberValue): NumberBinding = this.multiply(other)
inline operator fun FloatExpression.times(other: Double): DoubleBinding = this.multiply(other)
inline operator fun FloatExpression.times(other: Float): FloatBinding = this.multiply(other)
inline operator fun FloatExpression.times(other: Long): FloatBinding = this.multiply(other)
inline operator fun FloatExpression.times(other: Int): FloatBinding = this.multiply(other)

inline operator fun Long.times(other: ObservableNumberValue): LongBinding = Bindings.multiply(this, other) as LongBinding
inline operator fun LongExpression.times(other: ObservableNumberValue): NumberBinding = this.multiply(other)
inline operator fun LongExpression.times(other: Double): DoubleBinding = this.multiply(other)
inline operator fun LongExpression.times(other: Float): FloatBinding = this.multiply(other)
inline operator fun LongExpression.times(other: Long): LongBinding = this.multiply(other)
inline operator fun LongExpression.times(other: Int): LongBinding = this.multiply(other)

inline operator fun Int.times(other: ObservableNumberValue): IntegerBinding = Bindings.multiply(this, other) as IntegerBinding
inline operator fun IntegerExpression.times(other: ObservableNumberValue): NumberBinding = this.multiply(other)
inline operator fun IntegerExpression.times(other: Double): DoubleBinding = this.multiply(other)
inline operator fun IntegerExpression.times(other: Float): FloatBinding = this.multiply(other)
inline operator fun IntegerExpression.times(other: Long): LongBinding = this.multiply(other)
inline operator fun IntegerExpression.times(other: Int): IntegerBinding = this.multiply(other)

inline operator fun Double.div(other: ObservableNumberValue): DoubleBinding = Bindings.divide(this, other)
inline operator fun DoubleExpression.div(other: ObservableNumberValue): DoubleBinding = this.divide(other)
inline operator fun DoubleExpression.div(other: Double): DoubleBinding = this.divide(other)
inline operator fun DoubleExpression.div(other: Float): DoubleBinding = this.divide(other)
inline operator fun DoubleExpression.div(other: Long): DoubleBinding = this.divide(other)
inline operator fun DoubleExpression.div(other: Int): DoubleBinding = this.divide(other)

inline operator fun Float.div(other: ObservableNumberValue): FloatBinding = Bindings.divide(this, other) as FloatBinding
inline operator fun FloatExpression.div(other: ObservableNumberValue): NumberBinding = this.divide(other)
inline operator fun FloatExpression.div(other: Double): DoubleBinding = this.divide(other)
inline operator fun FloatExpression.div(other: Float): FloatBinding = this.divide(other)
inline operator fun FloatExpression.div(other: Long): FloatBinding = this.divide(other)
inline operator fun FloatExpression.div(other: Int): FloatBinding = this.divide(other)

inline operator fun Long.div(other: ObservableNumberValue): LongBinding = Bindings.divide(this, other) as LongBinding
inline operator fun LongExpression.div(other: ObservableNumberValue): NumberBinding = this.divide(other)
inline operator fun LongExpression.div(other: Double): DoubleBinding = this.divide(other)
inline operator fun LongExpression.div(other: Float): FloatBinding = this.divide(other)
inline operator fun LongExpression.div(other: Long): LongBinding = this.divide(other)
inline operator fun LongExpression.div(other: Int): LongBinding = this.divide(other)

inline operator fun Int.div(other: ObservableNumberValue): IntegerBinding = Bindings.divide(this, other) as IntegerBinding
inline operator fun IntegerExpression.div(other: ObservableNumberValue): NumberBinding = this.divide(other)
inline operator fun IntegerExpression.div(other: Double): DoubleBinding = this.divide(other)
inline operator fun IntegerExpression.div(other: Float): FloatBinding = this.divide(other)
inline operator fun IntegerExpression.div(other: Long): LongBinding = this.divide(other)
inline operator fun IntegerExpression.div(other: Int): IntegerBinding = this.divide(other)

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