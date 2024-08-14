@file:JvmMultifileClass
@file:JvmName("NumberValueBindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.DoubleExpression
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableNumberValue

/**
 * @see DoubleExpression.negate
 */
public inline operator fun ObservableDoubleValue.unaryMinus(): DoubleBinding =
    Bindings.negate(this) as DoubleBinding

/**
 * @see DoubleExpression.add
 */
public inline operator fun ObservableDoubleValue.plus(other: ObservableNumberValue): DoubleBinding =
    Bindings.add(this, other) as DoubleBinding

/**
 * @see DoubleExpression.add
 */
public inline operator fun ObservableDoubleValue.plus(other: Double): DoubleBinding =
    Bindings.add(this, other)

/**
 * @see DoubleExpression.add
 */
public inline operator fun Double.plus(other: ObservableDoubleValue): DoubleBinding =
    Bindings.add(this, other)

/**
 * @see DoubleExpression.add
 */
public inline operator fun ObservableDoubleValue.plus(other: Float): DoubleBinding =
    Bindings.add(this, other) as DoubleBinding

/**
 * @see DoubleExpression.add
 */
public inline operator fun Float.plus(other: ObservableDoubleValue): DoubleBinding =
    Bindings.add(this, other) as DoubleBinding

/**
 * @see DoubleExpression.add
 */
public inline operator fun ObservableDoubleValue.plus(other: Long): DoubleBinding =
    Bindings.add(this, other) as DoubleBinding

/**
 * @see DoubleExpression.add
 */
public inline operator fun Long.plus(other: ObservableDoubleValue): DoubleBinding =
    Bindings.add(this, other) as DoubleBinding

/**
 * @see DoubleExpression.add
 */
public inline operator fun ObservableDoubleValue.plus(other: Int): DoubleBinding =
    Bindings.add(this, other) as DoubleBinding

/**
 * @see DoubleExpression.add
 */
public inline operator fun Int.plus(other: ObservableDoubleValue): DoubleBinding =
    Bindings.add(this, other) as DoubleBinding

/**
 * @see DoubleExpression.subtract
 */
public inline operator fun ObservableDoubleValue.minus(
    other: ObservableDoubleValue,
): DoubleBinding = Bindings.subtract(this, other) as DoubleBinding

/**
 * @see DoubleExpression.subtract
 */
public inline operator fun ObservableDoubleValue.minus(other: Double): DoubleBinding =
    Bindings.subtract(this, other)

/**
 * @see DoubleExpression.subtract
 */
public inline operator fun Double.minus(other: ObservableDoubleValue): DoubleBinding =
    Bindings.subtract(this, other)

/**
 * @see DoubleExpression.subtract
 */
public inline operator fun ObservableDoubleValue.minus(other: Float): DoubleBinding =
    Bindings.subtract(this, other) as DoubleBinding

/**
 * @see DoubleExpression.subtract
 */
public inline operator fun Float.minus(other: ObservableDoubleValue): DoubleBinding =
    Bindings.subtract(this, other) as DoubleBinding

/**
 * @see DoubleExpression.subtract
 */
public inline operator fun ObservableDoubleValue.minus(other: Long): DoubleBinding =
    Bindings.subtract(this, other) as DoubleBinding

/**
 * @see DoubleExpression.subtract
 */
public inline operator fun Long.minus(other: ObservableDoubleValue): DoubleBinding =
    Bindings.subtract(this, other) as DoubleBinding

/**
 * @see DoubleExpression.subtract
 */
public inline operator fun ObservableDoubleValue.minus(other: Int): DoubleBinding =
    Bindings.subtract(this, other) as DoubleBinding

/**
 * @see DoubleExpression.subtract
 */
public inline operator fun Int.minus(other: ObservableDoubleValue): DoubleBinding =
    Bindings.subtract(this, other) as DoubleBinding

/**
 * @see DoubleExpression.multiply
 */
public inline operator fun ObservableDoubleValue.times(
    other: ObservableDoubleValue,
): DoubleBinding = Bindings.multiply(this, other) as DoubleBinding

/**
 * @see DoubleExpression.multiply
 */
public inline operator fun ObservableDoubleValue.times(other: Double): DoubleBinding =
    Bindings.multiply(this, other)

/**
 * @see DoubleExpression.multiply
 */
public inline operator fun Double.times(other: ObservableDoubleValue): DoubleBinding =
    Bindings.multiply(this, other)

/**
 * @see DoubleExpression.multiply
 */
public inline operator fun ObservableDoubleValue.times(other: Float): DoubleBinding =
    Bindings.multiply(this, other) as DoubleBinding

/**
 * @see DoubleExpression.multiply
 */
public inline operator fun Float.times(other: ObservableDoubleValue): DoubleBinding =
    Bindings.multiply(this, other) as DoubleBinding

/**
 * @see DoubleExpression.multiply
 */
public inline operator fun ObservableDoubleValue.times(other: Long): DoubleBinding =
    Bindings.multiply(this, other) as DoubleBinding

/**
 * @see DoubleExpression.multiply
 */
public inline operator fun Long.times(other: ObservableDoubleValue): DoubleBinding =
    Bindings.multiply(this, other) as DoubleBinding

/**
 * @see DoubleExpression.multiply
 */
public inline operator fun ObservableDoubleValue.times(other: Int): DoubleBinding =
    Bindings.multiply(this, other) as DoubleBinding

/**
 * @see DoubleExpression.multiply
 */
public inline operator fun Int.times(other: ObservableDoubleValue): DoubleBinding =
    Bindings.multiply(this, other) as DoubleBinding

/**
 * @see DoubleExpression.divide
 */
public inline operator fun ObservableDoubleValue.div(other: ObservableDoubleValue): DoubleBinding =
    Bindings.divide(this, other) as DoubleBinding

/**
 * @see DoubleExpression.divide
 */
public inline operator fun ObservableDoubleValue.div(other: Double): DoubleBinding =
    Bindings.divide(this, other)

/**
 * @see DoubleExpression.divide
 */
public inline operator fun Double.div(other: ObservableDoubleValue): DoubleBinding =
    Bindings.divide(this, other)

/**
 * @see DoubleExpression.divide
 */
public inline operator fun ObservableDoubleValue.div(other: Float): DoubleBinding =
    Bindings.divide(this, other) as DoubleBinding

/**
 * @see DoubleExpression.divide
 */
public inline operator fun Float.div(other: ObservableDoubleValue): DoubleBinding =
    Bindings.divide(this, other) as DoubleBinding

/**
 * @see DoubleExpression.divide
 */
public inline operator fun ObservableDoubleValue.div(other: Long): DoubleBinding =
    Bindings.divide(this, other) as DoubleBinding

/**
 * @see DoubleExpression.divide
 */
public inline operator fun Long.div(other: ObservableDoubleValue): DoubleBinding =
    Bindings.divide(this, other) as DoubleBinding

/**
 * @see DoubleExpression.divide
 */
public inline operator fun ObservableDoubleValue.div(other: Int): DoubleBinding =
    Bindings.divide(this, other) as DoubleBinding

/**
 * @see DoubleExpression.divide
 */
public inline operator fun Int.div(other: ObservableDoubleValue): DoubleBinding =
    Bindings.divide(this, other) as DoubleBinding
