@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.binding.Bindings
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.DoubleExpression
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.FloatExpression
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.IntegerExpression
import javafx.beans.binding.LongBinding
import javafx.beans.binding.LongExpression
import javafx.beans.binding.NumberBinding
import javafx.beans.binding.NumberExpressionBase
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableNumberValue
import javafx.beans.value.WritableDoubleValue
import javafx.beans.value.WritableFloatValue
import javafx.beans.value.WritableIntegerValue
import javafx.beans.value.WritableLongValue
import kotlin.reflect.KProperty

/** Delegated property of this read-only [Double] value, use with `by` keyword. */
inline operator fun ObservableDoubleValue.getValue(
    thisRef: Any?,
    property: KProperty<*>
): Double = get()

/** Delegated property of this writable [Double] value, use with `by` keyword. */
inline operator fun WritableDoubleValue.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: Double
): Unit = set(value)

/** Delegated property of this read-only [Float] value, use with `by` keyword. */
inline operator fun ObservableFloatValue.getValue(
    thisRef: Any?,
    property: KProperty<*>
): Float = get()

/** Delegated property of this writable [Float] value, use with `by` keyword. */
inline operator fun WritableFloatValue.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: Float
): Unit = set(value)

/** Delegated property of this read-only [Int] value, use with `by` keyword. */
inline operator fun ObservableIntegerValue.getValue(
    thisRef: Any?,
    property: KProperty<*>
): Int = get()

/** Delegated property of this writable [Int] value, use with `by` keyword. */
inline operator fun WritableIntegerValue.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: Int
): Unit = set(value)

/** Delegated property of this read-only [Long] value, use with `by` keyword. */
inline operator fun ObservableLongValue.getValue(
    thisRef: Any?,
    property: KProperty<*>
): Long = get()

/** Delegated property of this writable [Long] value, use with `by` keyword. */
inline operator fun WritableLongValue.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: Long
): Unit = set(value)

/** Operator alias of [NumberExpressionBase.add]. */
inline operator fun ObservableNumberValue.plus(other: ObservableNumberValue): ObservableNumberValue =
    Bindings.add(this, other)

/** Operator alias of [DoubleExpression.add]. */
inline operator fun ObservableDoubleValue.plus(other: ObservableNumberValue): DoubleBinding =
    Bindings.add(this, other) as DoubleBinding

/** Operator alias of [DoubleExpression.add]. */
inline operator fun Double.plus(other: ObservableNumberValue): DoubleBinding = Bindings.add(this, other)

/** Operator alias of [DoubleExpression.add]. */
inline operator fun ObservableDoubleValue.plus(other: Double): DoubleBinding = Bindings.add(this, other)

/** Operator alias of [DoubleExpression.add]. */
inline operator fun ObservableDoubleValue.plus(other: Float): DoubleBinding = Bindings.add(this, other) as DoubleBinding

/** Operator alias of [DoubleExpression.add]. */
inline operator fun ObservableDoubleValue.plus(other: Long): DoubleBinding = Bindings.add(this, other) as DoubleBinding

/** Operator alias of [DoubleExpression.add]. */
inline operator fun ObservableDoubleValue.plus(other: Int): DoubleBinding = Bindings.add(this, other) as DoubleBinding

/** Operator alias of [FloatExpression.add]. */
inline operator fun Float.plus(other: ObservableNumberValue): FloatBinding = Bindings.add(this, other) as FloatBinding

/** Operator alias of [FloatExpression.add]. */
inline operator fun ObservableFloatValue.plus(other: ObservableNumberValue): FloatBinding =
    Bindings.add(this, other) as FloatBinding

/** Operator alias of [FloatExpression.add]. */
inline operator fun FloatExpression.plus(other: Double): DoubleBinding = Bindings.add(this, other)

/** Operator alias of [FloatExpression.add]. */
inline operator fun FloatExpression.plus(other: Float): FloatBinding = Bindings.add(this, other) as FloatBinding

/** Operator alias of [FloatExpression.add]. */
inline operator fun FloatExpression.plus(other: Long): FloatBinding = Bindings.add(this, other) as FloatBinding

/** Operator alias of [FloatExpression.add]. */
inline operator fun FloatExpression.plus(other: Int): FloatBinding = Bindings.add(this, other) as FloatBinding

/** Operator alias of [LongExpression.add]. */
inline operator fun Long.plus(other: ObservableNumberValue): LongBinding = Bindings.add(this, other) as LongBinding

/** Operator alias of [LongExpression.add]. */
inline operator fun LongExpression.plus(other: ObservableNumberValue): LongBinding =
    Bindings.add(this, other) as LongBinding

/** Operator alias of [LongExpression.add]. */
inline operator fun LongExpression.plus(other: Double): DoubleBinding = Bindings.add(this, other)

/** Operator alias of [LongExpression.add]. */
inline operator fun LongExpression.plus(other: Float): FloatBinding = Bindings.add(this, other) as FloatBinding

/** Operator alias of [LongExpression.add]. */
inline operator fun LongExpression.plus(other: Long): LongBinding = Bindings.add(this, other) as LongBinding

/** Operator alias of [LongExpression.add]. */
inline operator fun LongExpression.plus(other: Int): LongBinding = Bindings.add(this, other) as LongBinding

/** Operator alias of [Bindings.add]. */
inline operator fun Int.plus(other: ObservableNumberValue): IntegerBinding = Bindings.add(this, other) as IntegerBinding

/** Operator alias of [Bindings.add]. */
inline operator fun IntegerExpression.plus(other: ObservableNumberValue): NumberBinding = add(other)

/** Operator alias of [Bindings.add]. */
inline operator fun IntegerExpression.plus(other: Double): DoubleBinding = add(other)

/** Operator alias of [Bindings.add]. */
inline operator fun IntegerExpression.plus(other: Float): FloatBinding = add(other)

/** Operator alias of [Bindings.add]. */
inline operator fun IntegerExpression.plus(other: Long): LongBinding = add(other)

/** Operator alias of [Bindings.add]. */
inline operator fun IntegerExpression.plus(other: Int): IntegerBinding = add(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun Double.minus(other: ObservableNumberValue): DoubleBinding = Bindings.subtract(this, other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun DoubleExpression.minus(other: ObservableNumberValue): DoubleBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun DoubleExpression.minus(other: Double): DoubleBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun DoubleExpression.minus(other: Float): DoubleBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun DoubleExpression.minus(other: Long): DoubleBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun DoubleExpression.minus(other: Int): DoubleBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun Float.minus(other: ObservableNumberValue): FloatBinding =
    Bindings.subtract(this, other) as FloatBinding

/** Operator alias of [Bindings.subtract]. */
inline operator fun FloatExpression.minus(other: ObservableNumberValue): NumberBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun FloatExpression.minus(other: Double): DoubleBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun FloatExpression.minus(other: Float): FloatBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun FloatExpression.minus(other: Long): FloatBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun FloatExpression.minus(other: Int): FloatBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun Long.minus(other: ObservableNumberValue): LongBinding =
    Bindings.subtract(this, other) as LongBinding

/** Operator alias of [Bindings.subtract]. */
inline operator fun LongExpression.minus(other: ObservableNumberValue): NumberBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun LongExpression.minus(other: Double): DoubleBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun LongExpression.minus(other: Float): FloatBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun LongExpression.minus(other: Long): LongBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun LongExpression.minus(other: Int): LongBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun Int.minus(other: ObservableNumberValue): IntegerBinding =
    Bindings.subtract(this, other) as IntegerBinding

/** Operator alias of [Bindings.subtract]. */
inline operator fun IntegerExpression.minus(other: ObservableNumberValue): NumberBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun IntegerExpression.minus(other: Double): DoubleBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun IntegerExpression.minus(other: Float): FloatBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun IntegerExpression.minus(other: Long): LongBinding = subtract(other)

/** Operator alias of [Bindings.subtract]. */
inline operator fun IntegerExpression.minus(other: Int): IntegerBinding = subtract(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun Double.times(other: ObservableNumberValue): DoubleBinding = Bindings.multiply(this, other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun DoubleExpression.times(other: ObservableNumberValue): DoubleBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun DoubleExpression.times(other: Double): DoubleBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun DoubleExpression.times(other: Float): DoubleBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun DoubleExpression.times(other: Long): DoubleBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun DoubleExpression.times(other: Int): DoubleBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun Float.times(other: ObservableNumberValue): FloatBinding =
    Bindings.multiply(this, other) as FloatBinding

/** Operator alias of [Bindings.multiply]. */
inline operator fun FloatExpression.times(other: ObservableNumberValue): NumberBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun FloatExpression.times(other: Double): DoubleBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun FloatExpression.times(other: Float): FloatBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun FloatExpression.times(other: Long): FloatBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun FloatExpression.times(other: Int): FloatBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun Long.times(other: ObservableNumberValue): LongBinding =
    Bindings.multiply(this, other) as LongBinding

/** Operator alias of [Bindings.multiply]. */
inline operator fun LongExpression.times(other: ObservableNumberValue): NumberBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun LongExpression.times(other: Double): DoubleBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun LongExpression.times(other: Float): FloatBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun LongExpression.times(other: Long): LongBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun LongExpression.times(other: Int): LongBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun Int.times(other: ObservableNumberValue): IntegerBinding =
    Bindings.multiply(this, other) as IntegerBinding

/** Operator alias of [Bindings.multiply]. */
inline operator fun IntegerExpression.times(other: ObservableNumberValue): NumberBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun IntegerExpression.times(other: Double): DoubleBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun IntegerExpression.times(other: Float): FloatBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun IntegerExpression.times(other: Long): LongBinding = multiply(other)

/** Operator alias of [Bindings.multiply]. */
inline operator fun IntegerExpression.times(other: Int): IntegerBinding = multiply(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun Double.div(other: ObservableNumberValue): DoubleBinding = Bindings.divide(this, other)

/** Operator alias of [Bindings.divide]. */
inline operator fun DoubleExpression.div(other: ObservableNumberValue): DoubleBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun DoubleExpression.div(other: Double): DoubleBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun DoubleExpression.div(other: Float): DoubleBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun DoubleExpression.div(other: Long): DoubleBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun DoubleExpression.div(other: Int): DoubleBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun Float.div(other: ObservableNumberValue): FloatBinding = Bindings.divide(this, other) as FloatBinding

/** Operator alias of [Bindings.divide]. */
inline operator fun FloatExpression.div(other: ObservableNumberValue): NumberBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun FloatExpression.div(other: Double): DoubleBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun FloatExpression.div(other: Float): FloatBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun FloatExpression.div(other: Long): FloatBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun FloatExpression.div(other: Int): FloatBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun Long.div(other: ObservableNumberValue): LongBinding = Bindings.divide(this, other) as LongBinding

/** Operator alias of [Bindings.divide]. */
inline operator fun LongExpression.div(other: ObservableNumberValue): NumberBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun LongExpression.div(other: Double): DoubleBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun LongExpression.div(other: Float): FloatBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun LongExpression.div(other: Long): LongBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun LongExpression.div(other: Int): LongBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun Int.div(other: ObservableNumberValue): IntegerBinding =
    Bindings.divide(this, other) as IntegerBinding

/** Operator alias of [Bindings.divide]. */
inline operator fun IntegerExpression.div(other: ObservableNumberValue): NumberBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun IntegerExpression.div(other: Double): DoubleBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun IntegerExpression.div(other: Float): FloatBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun IntegerExpression.div(other: Long): LongBinding = divide(other)

/** Operator alias of [Bindings.divide]. */
inline operator fun IntegerExpression.div(other: Int): IntegerBinding = divide(other)
