@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.bindings

import javafx.beans.binding.*
import javafx.beans.binding.Bindings.*
import javafx.beans.value.ObservableNumberValue

inline operator fun Double.plus(other: ObservableNumberValue): DoubleBinding = add(this, other)
inline operator fun DoubleExpression.plus(other: ObservableNumberValue): DoubleBinding = this.add(other)
inline operator fun DoubleExpression.plus(other: Double): DoubleBinding = this.add(other)
inline operator fun DoubleExpression.plus(other: Float): DoubleBinding = this.add(other)
inline operator fun DoubleExpression.plus(other: Long): DoubleBinding = this.add(other)
inline operator fun DoubleExpression.plus(other: Int): DoubleBinding = this.add(other)

inline operator fun Float.plus(other: ObservableNumberValue): FloatBinding = add(this, other) as FloatBinding
inline operator fun FloatExpression.plus(other: ObservableNumberValue): NumberBinding = this.add(other)
inline operator fun FloatExpression.plus(other: Double): DoubleBinding = this.add(other)
inline operator fun FloatExpression.plus(other: Float): FloatBinding = this.add(other)
inline operator fun FloatExpression.plus(other: Long): FloatBinding = this.add(other)
inline operator fun FloatExpression.plus(other: Int): FloatBinding = this.add(other)

inline operator fun Long.plus(other: ObservableNumberValue): LongBinding = add(this, other) as LongBinding
inline operator fun LongExpression.plus(other: ObservableNumberValue): NumberBinding = this.add(other)
inline operator fun LongExpression.plus(other: Double): DoubleBinding = this.add(other)
inline operator fun LongExpression.plus(other: Float): FloatBinding = this.add(other)
inline operator fun LongExpression.plus(other: Long): LongBinding = this.add(other)
inline operator fun LongExpression.plus(other: Int): LongBinding = this.add(other)

inline operator fun Int.plus(other: ObservableNumberValue): IntegerBinding = add(this, other) as IntegerBinding
inline operator fun IntegerExpression.plus(other: ObservableNumberValue): NumberBinding = this.add(other)
inline operator fun IntegerExpression.plus(other: Double): DoubleBinding = this.add(other)
inline operator fun IntegerExpression.plus(other: Float): FloatBinding = this.add(other)
inline operator fun IntegerExpression.plus(other: Long): LongBinding = this.add(other)
inline operator fun IntegerExpression.plus(other: Int): IntegerBinding = this.add(other)

inline operator fun Double.minus(other: ObservableNumberValue): DoubleBinding = subtract(this, other)
inline operator fun DoubleExpression.minus(other: ObservableNumberValue): DoubleBinding = this.subtract(other)
inline operator fun DoubleExpression.minus(other: Double): DoubleBinding = this.subtract(other)
inline operator fun DoubleExpression.minus(other: Float): DoubleBinding = this.subtract(other)
inline operator fun DoubleExpression.minus(other: Long): DoubleBinding = this.subtract(other)
inline operator fun DoubleExpression.minus(other: Int): DoubleBinding = this.subtract(other)

inline operator fun Float.minus(other: ObservableNumberValue): FloatBinding = subtract(this, other) as FloatBinding
inline operator fun FloatExpression.minus(other: ObservableNumberValue): NumberBinding = this.subtract(other)
inline operator fun FloatExpression.minus(other: Double): DoubleBinding = this.subtract(other)
inline operator fun FloatExpression.minus(other: Float): FloatBinding = this.subtract(other)
inline operator fun FloatExpression.minus(other: Long): FloatBinding = this.subtract(other)
inline operator fun FloatExpression.minus(other: Int): FloatBinding = this.subtract(other)

inline operator fun Long.minus(other: ObservableNumberValue): LongBinding = subtract(this, other) as LongBinding
inline operator fun LongExpression.minus(other: ObservableNumberValue): NumberBinding = this.subtract(other)
inline operator fun LongExpression.minus(other: Double): DoubleBinding = this.subtract(other)
inline operator fun LongExpression.minus(other: Float): FloatBinding = this.subtract(other)
inline operator fun LongExpression.minus(other: Long): LongBinding = this.subtract(other)
inline operator fun LongExpression.minus(other: Int): LongBinding = this.subtract(other)

inline operator fun Int.minus(other: ObservableNumberValue): IntegerBinding = subtract(this, other) as IntegerBinding
inline operator fun IntegerExpression.minus(other: ObservableNumberValue): NumberBinding = this.subtract(other)
inline operator fun IntegerExpression.minus(other: Double): DoubleBinding = this.subtract(other)
inline operator fun IntegerExpression.minus(other: Float): FloatBinding = this.subtract(other)
inline operator fun IntegerExpression.minus(other: Long): LongBinding = this.subtract(other)
inline operator fun IntegerExpression.minus(other: Int): IntegerBinding = this.subtract(other)

inline operator fun Double.times(other: ObservableNumberValue): DoubleBinding = multiply(this, other)
inline operator fun DoubleExpression.times(other: ObservableNumberValue): DoubleBinding = this.multiply(other)
inline operator fun DoubleExpression.times(other: Double): DoubleBinding = this.multiply(other)
inline operator fun DoubleExpression.times(other: Float): DoubleBinding = this.multiply(other)
inline operator fun DoubleExpression.times(other: Long): DoubleBinding = this.multiply(other)
inline operator fun DoubleExpression.times(other: Int): DoubleBinding = this.multiply(other)

inline operator fun Float.times(other: ObservableNumberValue): FloatBinding = multiply(this, other) as FloatBinding
inline operator fun FloatExpression.times(other: ObservableNumberValue): NumberBinding = this.multiply(other)
inline operator fun FloatExpression.times(other: Double): DoubleBinding = this.multiply(other)
inline operator fun FloatExpression.times(other: Float): FloatBinding = this.multiply(other)
inline operator fun FloatExpression.times(other: Long): FloatBinding = this.multiply(other)
inline operator fun FloatExpression.times(other: Int): FloatBinding = this.multiply(other)

inline operator fun Long.times(other: ObservableNumberValue): LongBinding = multiply(this, other) as LongBinding
inline operator fun LongExpression.times(other: ObservableNumberValue): NumberBinding = this.multiply(other)
inline operator fun LongExpression.times(other: Double): DoubleBinding = this.multiply(other)
inline operator fun LongExpression.times(other: Float): FloatBinding = this.multiply(other)
inline operator fun LongExpression.times(other: Long): LongBinding = this.multiply(other)
inline operator fun LongExpression.times(other: Int): LongBinding = this.multiply(other)

inline operator fun Int.times(other: ObservableNumberValue): IntegerBinding = multiply(this, other) as IntegerBinding
inline operator fun IntegerExpression.times(other: ObservableNumberValue): NumberBinding = this.multiply(other)
inline operator fun IntegerExpression.times(other: Double): DoubleBinding = this.multiply(other)
inline operator fun IntegerExpression.times(other: Float): FloatBinding = this.multiply(other)
inline operator fun IntegerExpression.times(other: Long): LongBinding = this.multiply(other)
inline operator fun IntegerExpression.times(other: Int): IntegerBinding = this.multiply(other)

inline operator fun Double.div(other: ObservableNumberValue): DoubleBinding = divide(this, other)
inline operator fun DoubleExpression.div(other: ObservableNumberValue): DoubleBinding = this.divide(other)
inline operator fun DoubleExpression.div(other: Double): DoubleBinding = this.divide(other)
inline operator fun DoubleExpression.div(other: Float): DoubleBinding = this.divide(other)
inline operator fun DoubleExpression.div(other: Long): DoubleBinding = this.divide(other)
inline operator fun DoubleExpression.div(other: Int): DoubleBinding = this.divide(other)

inline operator fun Float.div(other: ObservableNumberValue): FloatBinding = divide(this, other) as FloatBinding
inline operator fun FloatExpression.div(other: ObservableNumberValue): NumberBinding = this.divide(other)
inline operator fun FloatExpression.div(other: Double): DoubleBinding = this.divide(other)
inline operator fun FloatExpression.div(other: Float): FloatBinding = this.divide(other)
inline operator fun FloatExpression.div(other: Long): FloatBinding = this.divide(other)
inline operator fun FloatExpression.div(other: Int): FloatBinding = this.divide(other)

inline operator fun Long.div(other: ObservableNumberValue): LongBinding = divide(this, other) as LongBinding
inline operator fun LongExpression.div(other: ObservableNumberValue): NumberBinding = this.divide(other)
inline operator fun LongExpression.div(other: Double): DoubleBinding = this.divide(other)
inline operator fun LongExpression.div(other: Float): FloatBinding = this.divide(other)
inline operator fun LongExpression.div(other: Long): LongBinding = this.divide(other)
inline operator fun LongExpression.div(other: Int): LongBinding = this.divide(other)

inline operator fun Int.div(other: ObservableNumberValue): IntegerBinding = divide(this, other) as IntegerBinding
inline operator fun IntegerExpression.div(other: ObservableNumberValue): NumberBinding = this.divide(other)
inline operator fun IntegerExpression.div(other: Double): DoubleBinding = this.divide(other)
inline operator fun IntegerExpression.div(other: Float): FloatBinding = this.divide(other)
inline operator fun IntegerExpression.div(other: Long): LongBinding = this.divide(other)
inline operator fun IntegerExpression.div(other: Int): IntegerBinding = this.divide(other)

inline infix fun ObservableNumberValue.eq(other: ObservableNumberValue): BooleanBinding = equal(this, other)
inline infix fun ObservableNumberValue.eq(other: Double): BooleanBinding = equal(this, other, 0.0)
inline infix fun Double.eq(other: ObservableNumberValue): BooleanBinding = equal(this, other, 0.0)
inline infix fun ObservableNumberValue.eq(other: Float): BooleanBinding = equal(this, other, 0.0)
inline infix fun Float.eq(other: ObservableNumberValue): BooleanBinding = equal(this, other, 0.0)
inline infix fun ObservableNumberValue.eq(other: Long): BooleanBinding = equal(this, other)
inline infix fun Long.eq(other: ObservableNumberValue): BooleanBinding = equal(this, other)
inline infix fun ObservableNumberValue.eq(other: Int): BooleanBinding = equal(this, other)
inline infix fun Int.eq(other: ObservableNumberValue): BooleanBinding = equal(this, other)

inline infix fun ObservableNumberValue.neq(other: ObservableNumberValue): BooleanBinding = notEqual(this, other)
inline infix fun ObservableNumberValue.neq(other: Double): BooleanBinding = notEqual(this, other, 0.0)
inline infix fun Double.neq(other: ObservableNumberValue): BooleanBinding = notEqual(this, other, 0.0)
inline infix fun ObservableNumberValue.neq(other: Float): BooleanBinding = notEqual(this, other, 0.0)
inline infix fun Float.neq(other: ObservableNumberValue): BooleanBinding = notEqual(this, other, 0.0)
inline infix fun ObservableNumberValue.neq(other: Long): BooleanBinding = notEqual(this, other)
inline infix fun Long.neq(other: ObservableNumberValue): BooleanBinding = notEqual(this, other)
inline infix fun ObservableNumberValue.neq(other: Int): BooleanBinding = notEqual(this, other)
inline infix fun Int.neq(other: ObservableNumberValue): BooleanBinding = notEqual(this, other)

inline infix fun ObservableNumberValue.greater(other: ObservableNumberValue): BooleanBinding = greaterThan(this, other)
inline infix fun ObservableNumberValue.greater(other: Double): BooleanBinding = greaterThan(this, other)
inline infix fun Double.greater(other: ObservableNumberValue): BooleanBinding = greaterThan(this, other)
inline infix fun ObservableNumberValue.greater(other: Float): BooleanBinding = greaterThan(this, other)
inline infix fun Float.greater(other: ObservableNumberValue): BooleanBinding = greaterThan(this, other)
inline infix fun ObservableNumberValue.greater(other: Long): BooleanBinding = greaterThan(this, other)
inline infix fun Long.greater(other: ObservableNumberValue): BooleanBinding = greaterThan(this, other)
inline infix fun ObservableNumberValue.greater(other: Int): BooleanBinding = greaterThan(this, other)
inline infix fun Int.greater(other: ObservableNumberValue): BooleanBinding = greaterThan(this, other)

inline infix fun ObservableNumberValue.less(other: ObservableNumberValue): BooleanBinding = lessThan(this, other)
inline infix fun ObservableNumberValue.less(other: Double): BooleanBinding = lessThan(this, other)
inline infix fun Double.less(other: ObservableNumberValue): BooleanBinding = lessThan(this, other)
inline infix fun ObservableNumberValue.less(other: Float): BooleanBinding = lessThan(this, other)
inline infix fun Float.less(other: ObservableNumberValue): BooleanBinding = lessThan(this, other)
inline infix fun ObservableNumberValue.less(other: Long): BooleanBinding = lessThan(this, other)
inline infix fun Long.less(other: ObservableNumberValue): BooleanBinding = lessThan(this, other)
inline infix fun ObservableNumberValue.less(other: Int): BooleanBinding = lessThan(this, other)
inline infix fun Int.less(other: ObservableNumberValue): BooleanBinding = lessThan(this, other)

inline infix fun ObservableNumberValue.greaterEq(other: ObservableNumberValue): BooleanBinding = greaterThanOrEqual(this, other)
inline infix fun ObservableNumberValue.greaterEq(other: Double): BooleanBinding = greaterThanOrEqual(this, other)
inline infix fun Double.greaterEq(other: ObservableNumberValue): BooleanBinding = greaterThanOrEqual(this, other)
inline infix fun ObservableNumberValue.greaterEq(other: Float): BooleanBinding = greaterThanOrEqual(this, other)
inline infix fun Float.greaterEq(other: ObservableNumberValue): BooleanBinding = greaterThanOrEqual(this, other)
inline infix fun ObservableNumberValue.greaterEq(other: Long): BooleanBinding = greaterThanOrEqual(this, other)
inline infix fun Long.greaterEq(other: ObservableNumberValue): BooleanBinding = greaterThanOrEqual(this, other)
inline infix fun ObservableNumberValue.greaterEq(other: Int): BooleanBinding = greaterThanOrEqual(this, other)
inline infix fun Int.greaterEq(other: ObservableNumberValue): BooleanBinding = greaterThanOrEqual(this, other)

inline infix fun ObservableNumberValue.lessEq(other: ObservableNumberValue): BooleanBinding = lessThanOrEqual(this, other)
inline infix fun ObservableNumberValue.lessEq(other: Double): BooleanBinding = lessThanOrEqual(this, other)
inline infix fun Double.lessEq(other: ObservableNumberValue): BooleanBinding = lessThanOrEqual(this, other)
inline infix fun ObservableNumberValue.lessEq(other: Float): BooleanBinding = lessThanOrEqual(this, other)
inline infix fun Float.lessEq(other: ObservableNumberValue): BooleanBinding = lessThanOrEqual(this, other)
inline infix fun ObservableNumberValue.lessEq(other: Long): BooleanBinding = lessThanOrEqual(this, other)
inline infix fun Long.lessEq(other: ObservableNumberValue): BooleanBinding = lessThanOrEqual(this, other)
inline infix fun ObservableNumberValue.lessEq(other: Int): BooleanBinding = lessThanOrEqual(this, other)
inline infix fun Int.lessEq(other: ObservableNumberValue): BooleanBinding = lessThanOrEqual(this, other)

inline infix fun ObservableNumberValue.min(other: ObservableNumberValue): NumberBinding = min(this, other)
inline infix fun ObservableNumberValue.min(other: Double): DoubleBinding = min(this, other)
inline infix fun Double.min(other: ObservableNumberValue): DoubleBinding = min(this, other)
inline infix fun ObservableNumberValue.min(other: Float): FloatBinding = min(this, other) as FloatBinding
inline infix fun Float.min(other: ObservableNumberValue): FloatBinding = min(this, other) as FloatBinding
inline infix fun ObservableNumberValue.min(other: Long): LongBinding = min(this, other) as LongBinding
inline infix fun Long.min(other: ObservableNumberValue): LongBinding = min(this, other) as LongBinding
inline infix fun ObservableNumberValue.min(other: Int): IntegerBinding = min(this, other) as IntegerBinding
inline infix fun Int.min(other: ObservableNumberValue): IntegerBinding = min(this, other) as IntegerBinding

inline infix fun ObservableNumberValue.max(other: ObservableNumberValue): NumberBinding = max(this, other)
inline infix fun ObservableNumberValue.max(other: Double): DoubleBinding = max(this, other)
inline infix fun Double.max(other: ObservableNumberValue): DoubleBinding = max(this, other)
inline infix fun ObservableNumberValue.max(other: Float): FloatBinding = max(this, other) as FloatBinding
inline infix fun Float.max(other: ObservableNumberValue): FloatBinding = max(this, other) as FloatBinding
inline infix fun ObservableNumberValue.max(other: Long): LongBinding = max(this, other) as LongBinding
inline infix fun Long.max(other: ObservableNumberValue): LongBinding = max(this, other) as LongBinding
inline infix fun ObservableNumberValue.max(other: Int): IntegerBinding = max(this, other) as IntegerBinding
inline infix fun Int.max(other: ObservableNumberValue): IntegerBinding = max(this, other) as IntegerBinding