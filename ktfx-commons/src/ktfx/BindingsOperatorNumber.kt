@file:JvmMultifileClass
@file:JvmName("BindingsKt")
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
import javafx.beans.value.ObservableNumberValue

/** Operator alias of [Bindings.add]. */
inline operator fun Double.plus(op: ObservableNumberValue): DoubleBinding = Bindings.add(this, op)

/** Operator alias of [Bindings.add]. */
inline operator fun DoubleExpression.plus(op: ObservableNumberValue): DoubleBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun DoubleExpression.plus(op: Double): DoubleBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun DoubleExpression.plus(op: Float): DoubleBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun DoubleExpression.plus(op: Long): DoubleBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun DoubleExpression.plus(op: Int): DoubleBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun Float.plus(op: ObservableNumberValue): FloatBinding = Bindings.add(this, op) as FloatBinding

/** Operator alias of [Bindings.add]. */
inline operator fun FloatExpression.plus(op: ObservableNumberValue): NumberBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun FloatExpression.plus(op: Double): DoubleBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun FloatExpression.plus(op: Float): FloatBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun FloatExpression.plus(op: Long): FloatBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun FloatExpression.plus(op: Int): FloatBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun Long.plus(op: ObservableNumberValue): LongBinding = Bindings.add(this, op) as LongBinding

/** Operator alias of [Bindings.add]. */
inline operator fun LongExpression.plus(op: ObservableNumberValue): NumberBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun LongExpression.plus(op: Double): DoubleBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun LongExpression.plus(op: Float): FloatBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun LongExpression.plus(op: Long): LongBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun LongExpression.plus(op: Int): LongBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun Int.plus(op: ObservableNumberValue): IntegerBinding = Bindings.add(this, op) as IntegerBinding

/** Operator alias of [Bindings.add]. */
inline operator fun IntegerExpression.plus(op: ObservableNumberValue): NumberBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun IntegerExpression.plus(op: Double): DoubleBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun IntegerExpression.plus(op: Float): FloatBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun IntegerExpression.plus(op: Long): LongBinding = add(op)

/** Operator alias of [Bindings.add]. */
inline operator fun IntegerExpression.plus(op: Int): IntegerBinding = add(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun Double.minus(op: ObservableNumberValue): DoubleBinding = Bindings.subtract(this, op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun DoubleExpression.minus(op: ObservableNumberValue): DoubleBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun DoubleExpression.minus(op: Double): DoubleBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun DoubleExpression.minus(op: Float): DoubleBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun DoubleExpression.minus(op: Long): DoubleBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun DoubleExpression.minus(op: Int): DoubleBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun Float.minus(op: ObservableNumberValue): FloatBinding = Bindings.subtract(this, op) as FloatBinding

/** Operator alias of [Bindings.subtract]. */
inline operator fun FloatExpression.minus(op: ObservableNumberValue): NumberBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun FloatExpression.minus(op: Double): DoubleBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun FloatExpression.minus(op: Float): FloatBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun FloatExpression.minus(op: Long): FloatBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun FloatExpression.minus(op: Int): FloatBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun Long.minus(op: ObservableNumberValue): LongBinding = Bindings.subtract(this, op) as LongBinding

/** Operator alias of [Bindings.subtract]. */
inline operator fun LongExpression.minus(op: ObservableNumberValue): NumberBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun LongExpression.minus(op: Double): DoubleBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun LongExpression.minus(op: Float): FloatBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun LongExpression.minus(op: Long): LongBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun LongExpression.minus(op: Int): LongBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun Int.minus(op: ObservableNumberValue): IntegerBinding = Bindings.subtract(this, op) as IntegerBinding

/** Operator alias of [Bindings.subtract]. */
inline operator fun IntegerExpression.minus(op: ObservableNumberValue): NumberBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun IntegerExpression.minus(op: Double): DoubleBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun IntegerExpression.minus(op: Float): FloatBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun IntegerExpression.minus(op: Long): LongBinding = subtract(op)

/** Operator alias of [Bindings.subtract]. */
inline operator fun IntegerExpression.minus(op: Int): IntegerBinding = subtract(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun Double.times(op: ObservableNumberValue): DoubleBinding = Bindings.multiply(this, op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun DoubleExpression.times(op: ObservableNumberValue): DoubleBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun DoubleExpression.times(op: Double): DoubleBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun DoubleExpression.times(op: Float): DoubleBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun DoubleExpression.times(op: Long): DoubleBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun DoubleExpression.times(op: Int): DoubleBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun Float.times(op: ObservableNumberValue): FloatBinding = Bindings.multiply(this, op) as FloatBinding

/** Operator alias of [Bindings.multiply]. */
inline operator fun FloatExpression.times(op: ObservableNumberValue): NumberBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun FloatExpression.times(op: Double): DoubleBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun FloatExpression.times(op: Float): FloatBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun FloatExpression.times(op: Long): FloatBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun FloatExpression.times(op: Int): FloatBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun Long.times(op: ObservableNumberValue): LongBinding = Bindings.multiply(this, op) as LongBinding

/** Operator alias of [Bindings.multiply]. */
inline operator fun LongExpression.times(op: ObservableNumberValue): NumberBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun LongExpression.times(op: Double): DoubleBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun LongExpression.times(op: Float): FloatBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun LongExpression.times(op: Long): LongBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun LongExpression.times(op: Int): LongBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun Int.times(op: ObservableNumberValue): IntegerBinding = Bindings.multiply(this, op) as IntegerBinding

/** Operator alias of [Bindings.multiply]. */
inline operator fun IntegerExpression.times(op: ObservableNumberValue): NumberBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun IntegerExpression.times(op: Double): DoubleBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun IntegerExpression.times(op: Float): FloatBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun IntegerExpression.times(op: Long): LongBinding = multiply(op)

/** Operator alias of [Bindings.multiply]. */
inline operator fun IntegerExpression.times(op: Int): IntegerBinding = multiply(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun Double.div(op: ObservableNumberValue): DoubleBinding = Bindings.divide(this, op)

/** Operator alias of [Bindings.divide]. */
inline operator fun DoubleExpression.div(op: ObservableNumberValue): DoubleBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun DoubleExpression.div(op: Double): DoubleBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun DoubleExpression.div(op: Float): DoubleBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun DoubleExpression.div(op: Long): DoubleBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun DoubleExpression.div(op: Int): DoubleBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun Float.div(op: ObservableNumberValue): FloatBinding = Bindings.divide(this, op) as FloatBinding

/** Operator alias of [Bindings.divide]. */
inline operator fun FloatExpression.div(op: ObservableNumberValue): NumberBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun FloatExpression.div(op: Double): DoubleBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun FloatExpression.div(op: Float): FloatBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun FloatExpression.div(op: Long): FloatBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun FloatExpression.div(op: Int): FloatBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun Long.div(op: ObservableNumberValue): LongBinding = Bindings.divide(this, op) as LongBinding

/** Operator alias of [Bindings.divide]. */
inline operator fun LongExpression.div(op: ObservableNumberValue): NumberBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun LongExpression.div(op: Double): DoubleBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun LongExpression.div(op: Float): FloatBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun LongExpression.div(op: Long): LongBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun LongExpression.div(op: Int): LongBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun Int.div(op: ObservableNumberValue): IntegerBinding = Bindings.divide(this, op) as IntegerBinding

/** Operator alias of [Bindings.divide]. */
inline operator fun IntegerExpression.div(op: ObservableNumberValue): NumberBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun IntegerExpression.div(op: Double): DoubleBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun IntegerExpression.div(op: Float): FloatBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun IntegerExpression.div(op: Long): LongBinding = divide(op)

/** Operator alias of [Bindings.divide]. */
inline operator fun IntegerExpression.div(op: Int): IntegerBinding = divide(op)
