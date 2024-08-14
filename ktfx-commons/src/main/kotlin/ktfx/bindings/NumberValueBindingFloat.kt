@file:JvmMultifileClass
@file:JvmName("NumberValueBindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.FloatExpression
import javafx.beans.value.ObservableFloatValue

/**
 * @see FloatExpression.negate
 */
public inline operator fun ObservableFloatValue.unaryMinus(): FloatBinding =
    Bindings.negate(this) as FloatBinding

/**
 * @see FloatExpression.add
 */
public inline operator fun ObservableFloatValue.plus(other: Double): DoubleBinding =
    Bindings.add(this, other)

/**
 * @see FloatExpression.add
 */
public inline operator fun Double.plus(other: ObservableFloatValue): DoubleBinding =
    Bindings.add(this, other)

/**
 * @see FloatExpression.add
 */
public inline operator fun ObservableFloatValue.plus(other: Float): FloatBinding =
    Bindings.add(this, other) as FloatBinding

/**
 * @see FloatExpression.add
 */
public inline operator fun Float.plus(other: ObservableFloatValue): FloatBinding =
    Bindings.add(this, other) as FloatBinding

/**
 * @see FloatExpression.add
 */
public inline operator fun ObservableFloatValue.plus(other: Long): FloatBinding =
    Bindings.add(this, other) as FloatBinding

/**
 * @see FloatExpression.add
 */
public inline operator fun Long.plus(other: ObservableFloatValue): FloatBinding =
    Bindings.add(this, other) as FloatBinding

/**
 * @see FloatExpression.add
 */
public inline operator fun ObservableFloatValue.plus(other: Int): FloatBinding =
    Bindings.add(this, other) as FloatBinding

/**
 * @see FloatExpression.add
 */
public inline operator fun Int.plus(other: ObservableFloatValue): FloatBinding =
    Bindings.add(this, other) as FloatBinding

/**
 * @see FloatExpression.subtract
 */
public inline operator fun ObservableFloatValue.minus(other: Double): DoubleBinding =
    Bindings.subtract(this, other)

/**
 * @see FloatExpression.subtract
 */
public inline operator fun Double.minus(other: ObservableFloatValue): DoubleBinding =
    Bindings.subtract(this, other)

/**
 * @see FloatExpression.subtract
 */
public inline operator fun ObservableFloatValue.minus(other: Float): FloatBinding =
    Bindings.subtract(this, other) as FloatBinding

/**
 * @see FloatExpression.subtract
 */
public inline operator fun Float.minus(other: ObservableFloatValue): FloatBinding =
    Bindings.subtract(this, other) as FloatBinding

/**
 * @see FloatExpression.subtract
 */
public inline operator fun ObservableFloatValue.minus(other: Long): FloatBinding =
    Bindings.subtract(this, other) as FloatBinding

/**
 * @see FloatExpression.subtract
 */
public inline operator fun Long.minus(other: ObservableFloatValue): FloatBinding =
    Bindings.subtract(this, other) as FloatBinding

/**
 * @see FloatExpression.subtract
 */
public inline operator fun ObservableFloatValue.minus(other: Int): FloatBinding =
    Bindings.subtract(this, other) as FloatBinding

/**
 * @see FloatExpression.subtract
 */
public inline operator fun Int.minus(other: ObservableFloatValue): FloatBinding =
    Bindings.subtract(this, other) as FloatBinding

/**
 * @see FloatExpression.multiply
 */
public inline operator fun ObservableFloatValue.times(other: Double): DoubleBinding =
    Bindings.multiply(this, other)

/**
 * @see FloatExpression.multiply
 */
public inline operator fun Double.times(other: ObservableFloatValue): DoubleBinding =
    Bindings.multiply(this, other)

/**
 * @see FloatExpression.multiply
 */
public inline operator fun ObservableFloatValue.times(other: Float): FloatBinding =
    Bindings.multiply(this, other) as FloatBinding

/**
 * @see FloatExpression.multiply
 */
public inline operator fun Float.times(other: ObservableFloatValue): FloatBinding =
    Bindings.multiply(this, other) as FloatBinding

/**
 * @see FloatExpression.multiply
 */
public inline operator fun ObservableFloatValue.times(other: Long): FloatBinding =
    Bindings.multiply(this, other) as FloatBinding

/**
 * @see FloatExpression.multiply
 */
public inline operator fun Long.times(other: ObservableFloatValue): FloatBinding =
    Bindings.multiply(this, other) as FloatBinding

/**
 * @see FloatExpression.multiply
 */
public inline operator fun ObservableFloatValue.times(other: Int): FloatBinding =
    Bindings.multiply(this, other) as FloatBinding

/**
 * @see FloatExpression.multiply
 */
public inline operator fun Int.times(other: ObservableFloatValue): FloatBinding =
    Bindings.multiply(this, other) as FloatBinding

/**
 * @see FloatExpression.divide
 */
public inline operator fun ObservableFloatValue.div(other: Double): DoubleBinding =
    Bindings.divide(this, other)

/**
 * @see FloatExpression.divide
 */
public inline operator fun Double.div(other: ObservableFloatValue): DoubleBinding =
    Bindings.divide(this, other)

/**
 * @see FloatExpression.divide
 */
public inline operator fun ObservableFloatValue.div(other: Float): FloatBinding =
    Bindings.divide(this, other) as FloatBinding

/**
 * @see FloatExpression.divide
 */
public inline operator fun Float.div(other: ObservableFloatValue): FloatBinding =
    Bindings.divide(this, other) as FloatBinding

/**
 * @see FloatExpression.divide
 */
public inline operator fun ObservableFloatValue.div(other: Long): FloatBinding =
    Bindings.divide(this, other) as FloatBinding

/**
 * @see FloatExpression.divide
 */
public inline operator fun Long.div(other: ObservableFloatValue): FloatBinding =
    Bindings.divide(this, other) as FloatBinding

/**
 * @see FloatExpression.divide
 */
public inline operator fun ObservableFloatValue.div(other: Int): FloatBinding =
    Bindings.divide(this, other) as FloatBinding

/**
 * @see FloatExpression.divide
 */
public inline operator fun Int.div(other: ObservableFloatValue): FloatBinding =
    Bindings.divide(this, other) as FloatBinding
