@file:JvmMultifileClass
@file:JvmName("NumberValueBindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.LongBinding
import javafx.beans.binding.LongExpression
import javafx.beans.value.ObservableLongValue

/** @see LongExpression.negate */
inline operator fun ObservableLongValue.unaryMinus(): LongBinding =
    Bindings.negate(this) as LongBinding

/** @see LongExpression.add */
inline operator fun ObservableLongValue.plus(other: Double): DoubleBinding =
    Bindings.add(this, other)

/** @see LongExpression.add */
inline operator fun Double.plus(other: ObservableLongValue): DoubleBinding =
    Bindings.add(this, other)

/** @see LongExpression.add */
inline operator fun ObservableLongValue.plus(other: Float): FloatBinding =
    Bindings.add(this, other) as FloatBinding

/** @see LongExpression.add */
inline operator fun Float.plus(other: ObservableLongValue): FloatBinding =
    Bindings.add(this, other) as FloatBinding

/** @see LongExpression.add */
inline operator fun ObservableLongValue.plus(other: Long): LongBinding =
    Bindings.add(this, other) as LongBinding

/** @see LongExpression.add */
inline operator fun Long.plus(other: ObservableLongValue): LongBinding =
    Bindings.add(this, other) as LongBinding

/** @see LongExpression.add */
inline operator fun ObservableLongValue.plus(other: Int): LongBinding =
    Bindings.add(this, other) as LongBinding

/** @see LongExpression.add */
inline operator fun Int.plus(other: ObservableLongValue): LongBinding =
    Bindings.add(this, other) as LongBinding

/** @see LongExpression.subtract */
inline operator fun ObservableLongValue.minus(other: Double): DoubleBinding =
    Bindings.subtract(this, other)

/** @see LongExpression.subtract */
inline operator fun Double.minus(other: ObservableLongValue): DoubleBinding =
    Bindings.subtract(this, other)

/** @see LongExpression.subtract */
inline operator fun ObservableLongValue.minus(other: Float): FloatBinding =
    Bindings.subtract(this, other) as FloatBinding

/** @see LongExpression.subtract */
inline operator fun Float.minus(other: ObservableLongValue): FloatBinding =
    Bindings.subtract(this, other) as FloatBinding

/** @see LongExpression.subtract */
inline operator fun ObservableLongValue.minus(other: Long): LongBinding =
    Bindings.subtract(this, other) as LongBinding

/** @see LongExpression.subtract */
inline operator fun Long.minus(other: ObservableLongValue): LongBinding =
    Bindings.subtract(this, other) as LongBinding

/** @see LongExpression.subtract */
inline operator fun ObservableLongValue.minus(other: Int): LongBinding =
    Bindings.subtract(this, other) as LongBinding

/** @see LongExpression.subtract */
inline operator fun Int.minus(other: ObservableLongValue): LongBinding =
    Bindings.subtract(this, other) as LongBinding

/** @see LongExpression.multiply */
inline operator fun ObservableLongValue.times(other: Double): DoubleBinding =
    Bindings.multiply(this, other)

/** @see LongExpression.multiply */
inline operator fun Double.times(other: ObservableLongValue): DoubleBinding =
    Bindings.multiply(this, other)

/** @see LongExpression.multiply */
inline operator fun ObservableLongValue.times(other: Float): FloatBinding =
    Bindings.multiply(this, other) as FloatBinding

/** @see LongExpression.multiply */
inline operator fun Float.times(other: ObservableLongValue): FloatBinding =
    Bindings.multiply(this, other) as FloatBinding

/** @see LongExpression.multiply */
inline operator fun ObservableLongValue.times(other: Long): LongBinding =
    Bindings.multiply(this, other) as LongBinding

/** @see LongExpression.multiply */
inline operator fun Long.times(other: ObservableLongValue): LongBinding =
    Bindings.multiply(this, other) as LongBinding

/** @see LongExpression.multiply */
inline operator fun ObservableLongValue.times(other: Int): LongBinding =
    Bindings.multiply(this, other) as LongBinding

/** @see LongExpression.multiply */
inline operator fun Int.times(other: ObservableLongValue): LongBinding =
    Bindings.multiply(this, other) as LongBinding

/** @see LongExpression.divide */
inline operator fun ObservableLongValue.div(other: Double): DoubleBinding =
    Bindings.divide(this, other)

/** @see LongExpression.divide */
inline operator fun Double.div(other: ObservableLongValue): DoubleBinding =
    Bindings.divide(this, other)

/** @see LongExpression.divide */
inline operator fun ObservableLongValue.div(other: Float): FloatBinding =
    Bindings.divide(this, other) as FloatBinding

/** @see LongExpression.divide */
inline operator fun Float.div(other: ObservableLongValue): FloatBinding =
    Bindings.divide(this, other) as FloatBinding

/** @see LongExpression.divide */
inline operator fun ObservableLongValue.div(other: Long): LongBinding =
    Bindings.divide(this, other) as LongBinding

/** @see LongExpression.divide */
inline operator fun Long.div(other: ObservableLongValue): LongBinding =
    Bindings.divide(this, other) as LongBinding

/** @see LongExpression.divide */
inline operator fun ObservableLongValue.div(other: Int): LongBinding =
    Bindings.divide(this, other) as LongBinding

/** @see LongExpression.divide */
inline operator fun Int.div(other: ObservableLongValue): LongBinding =
    Bindings.divide(this, other) as LongBinding
