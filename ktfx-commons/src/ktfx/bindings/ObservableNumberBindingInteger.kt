@file:JvmMultifileClass
@file:JvmName("ObservableNumberBindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.IntegerExpression
import javafx.beans.binding.LongBinding
import javafx.beans.value.ObservableIntegerValue

/** @see IntegerExpression.negate */
inline operator fun ObservableIntegerValue.unaryMinus(): IntegerBinding = Bindings.negate(this) as IntegerBinding

/** @see IntegerExpression.add */
inline operator fun ObservableIntegerValue.plus(other: Double): DoubleBinding = Bindings.add(this, other)

/** @see IntegerExpression.add */
inline operator fun Double.plus(other: ObservableIntegerValue): DoubleBinding = Bindings.add(this, other)

/** @see IntegerExpression.add */
inline operator fun ObservableIntegerValue.plus(other: Float): FloatBinding = Bindings.add(this, other) as FloatBinding

/** @see IntegerExpression.add */
inline operator fun Float.plus(other: ObservableIntegerValue): FloatBinding = Bindings.add(this, other) as FloatBinding

/** @see IntegerExpression.add */
inline operator fun ObservableIntegerValue.plus(other: Long): LongBinding = Bindings.add(this, other) as LongBinding

/** @see IntegerExpression.add */
inline operator fun Long.plus(other: ObservableIntegerValue): LongBinding = Bindings.add(this, other) as LongBinding

/** @see IntegerExpression.add */
inline operator fun ObservableIntegerValue.plus(other: Int): IntegerBinding =
    Bindings.add(this, other) as IntegerBinding

/** @see IntegerExpression.add */
inline operator fun Int.plus(other: ObservableIntegerValue): IntegerBinding =
    Bindings.add(this, other) as IntegerBinding

/** @see IntegerExpression.subtract */
inline operator fun ObservableIntegerValue.minus(other: Double): DoubleBinding = Bindings.subtract(this, other)

/** @see IntegerExpression.subtract */
inline operator fun Double.minus(other: ObservableIntegerValue): DoubleBinding = Bindings.subtract(this, other)

/** @see IntegerExpression.subtract */
inline operator fun ObservableIntegerValue.minus(other: Float): FloatBinding =
    Bindings.subtract(this, other) as FloatBinding

/** @see IntegerExpression.subtract */
inline operator fun Float.minus(other: ObservableIntegerValue): FloatBinding =
    Bindings.subtract(this, other) as FloatBinding

/** @see IntegerExpression.subtract */
inline operator fun ObservableIntegerValue.minus(other: Long): LongBinding =
    Bindings.subtract(this, other) as LongBinding

/** @see IntegerExpression.subtract */
inline operator fun Long.minus(other: ObservableIntegerValue): LongBinding =
    Bindings.subtract(this, other) as LongBinding

/** @see IntegerExpression.subtract */
inline operator fun ObservableIntegerValue.minus(other: Int): IntegerBinding =
    Bindings.subtract(this, other) as IntegerBinding

/** @see IntegerExpression.subtract */
inline operator fun Int.minus(other: ObservableIntegerValue): IntegerBinding =
    Bindings.subtract(this, other) as IntegerBinding

/** @see IntegerExpression.multiply */
inline operator fun ObservableIntegerValue.times(other: Double): DoubleBinding = Bindings.multiply(this, other)

/** @see IntegerExpression.multiply */
inline operator fun Double.times(other: ObservableIntegerValue): DoubleBinding = Bindings.multiply(this, other)

/** @see IntegerExpression.multiply */
inline operator fun ObservableIntegerValue.times(other: Float): FloatBinding =
    Bindings.multiply(this, other) as FloatBinding

/** @see IntegerExpression.multiply */
inline operator fun Float.times(other: ObservableIntegerValue): FloatBinding =
    Bindings.multiply(this, other) as FloatBinding

/** @see IntegerExpression.multiply */
inline operator fun ObservableIntegerValue.times(other: Long): LongBinding =
    Bindings.multiply(this, other) as LongBinding

/** @see IntegerExpression.multiply */
inline operator fun Long.times(other: ObservableIntegerValue): LongBinding =
    Bindings.multiply(this, other) as LongBinding

/** @see IntegerExpression.multiply */
inline operator fun ObservableIntegerValue.times(other: Int): IntegerBinding =
    Bindings.multiply(this, other) as IntegerBinding

/** @see IntegerExpression.multiply */
inline operator fun Int.times(other: ObservableIntegerValue): IntegerBinding =
    Bindings.multiply(this, other) as IntegerBinding

/** @see IntegerExpression.divide */
inline operator fun ObservableIntegerValue.div(other: Double): DoubleBinding = Bindings.divide(this, other)

/** @see IntegerExpression.divide */
inline operator fun Double.div(other: ObservableIntegerValue): DoubleBinding = Bindings.divide(this, other)

/** @see IntegerExpression.divide */
inline operator fun ObservableIntegerValue.div(other: Float): FloatBinding =
    Bindings.divide(this, other) as FloatBinding

/** @see IntegerExpression.divide */
inline operator fun Float.div(other: ObservableIntegerValue): FloatBinding =
    Bindings.divide(this, other) as FloatBinding

/** @see IntegerExpression.divide */
inline operator fun ObservableIntegerValue.div(other: Long): LongBinding = Bindings.divide(this, other) as LongBinding

/** @see IntegerExpression.divide */
inline operator fun Long.div(other: ObservableIntegerValue): LongBinding = Bindings.divide(this, other) as LongBinding

/** @see IntegerExpression.divide */
inline operator fun ObservableIntegerValue.div(other: Int): IntegerBinding =
    Bindings.divide(this, other) as IntegerBinding

/** @see IntegerExpression.divide */
inline operator fun Int.div(other: ObservableIntegerValue): IntegerBinding =
    Bindings.divide(this, other) as IntegerBinding
