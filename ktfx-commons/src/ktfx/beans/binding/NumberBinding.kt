@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.binding

import javafx.beans.Observable
import javafx.beans.binding.Bindings.add
import javafx.beans.binding.Bindings.createDoubleBinding
import javafx.beans.binding.Bindings.createFloatBinding
import javafx.beans.binding.Bindings.createIntegerBinding
import javafx.beans.binding.Bindings.createLongBinding
import javafx.beans.binding.Bindings.divide
import javafx.beans.binding.Bindings.multiply
import javafx.beans.binding.Bindings.selectDouble
import javafx.beans.binding.Bindings.selectFloat
import javafx.beans.binding.Bindings.selectInteger
import javafx.beans.binding.Bindings.selectLong
import javafx.beans.binding.Bindings.subtract
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
import java.util.concurrent.Callable

/** Helper function to create a custom [DoubleBinding]. */
inline fun doubleBindingOf(
    vararg dependencies: Observable,
    noinline func: () -> Double?
): DoubleBinding = createDoubleBinding(Callable(func), *dependencies)

/** Helper function to create a custom [FloatBinding]. */
inline fun floatBindingOf(
    vararg dependencies: Observable,
    noinline func: () -> Float?
): FloatBinding = createFloatBinding(Callable(func), *dependencies)

/** Helper function to create a custom [IntegerBinding]. */
inline fun intBindingOf(
    vararg dependencies: Observable,
    noinline func: () -> Int?
): IntegerBinding = createIntegerBinding(Callable(func), *dependencies)

/** Helper function to create a custom [LongBinding]. */
inline fun longBindingOf(
    vararg dependencies: Observable,
    noinline func: () -> Long?
): LongBinding = createLongBinding(Callable(func), *dependencies)

/** Creates a double binding used to get a member. */
inline fun Any.selectDouble(vararg steps: String): DoubleBinding = selectDouble(this, *steps)

/** Creates a float binding used to get a member. */
inline fun Any.selectFloat(vararg steps: String): FloatBinding = selectFloat(this, *steps)

/** Creates an integer binding used to get a member. */
inline fun Any.selectInt(vararg steps: String): IntegerBinding = selectInteger(this, *steps)

/** Creates a long binding used to get a member. */
inline fun Any.selectLong(vararg steps: String): LongBinding = selectLong(this, *steps)

/** Operator for [add]. */
inline operator fun Double.plus(op: ObservableNumberValue): DoubleBinding = add(this, op)

/** Operator for [add]. */
inline operator fun DoubleExpression.plus(op: ObservableNumberValue): DoubleBinding = this.add(op)

/** Operator for [add]. */
inline operator fun DoubleExpression.plus(op: Double): DoubleBinding = this.add(op)

/** Operator for [add]. */
inline operator fun DoubleExpression.plus(op: Float): DoubleBinding = this.add(op)

/** Operator for [add]. */
inline operator fun DoubleExpression.plus(op: Long): DoubleBinding = this.add(op)

/** Operator for [add]. */
inline operator fun DoubleExpression.plus(op: Int): DoubleBinding = this.add(op)

/** Operator for [add]. */
inline operator fun Float.plus(op: ObservableNumberValue): FloatBinding = add(this, op) as FloatBinding

/** Operator for [add]. */
inline operator fun FloatExpression.plus(op: ObservableNumberValue): NumberBinding = this.add(op)

/** Operator for [add]. */
inline operator fun FloatExpression.plus(op: Double): DoubleBinding = this.add(op)

/** Operator for [add]. */
inline operator fun FloatExpression.plus(op: Float): FloatBinding = this.add(op)

/** Operator for [add]. */
inline operator fun FloatExpression.plus(op: Long): FloatBinding = this.add(op)

/** Operator for [add]. */
inline operator fun FloatExpression.plus(op: Int): FloatBinding = this.add(op)

/** Operator for [add]. */
inline operator fun Long.plus(op: ObservableNumberValue): LongBinding = add(this, op) as LongBinding

/** Operator for [add]. */
inline operator fun LongExpression.plus(op: ObservableNumberValue): NumberBinding = this.add(op)

/** Operator for [add]. */
inline operator fun LongExpression.plus(op: Double): DoubleBinding = this.add(op)

/** Operator for [add]. */
inline operator fun LongExpression.plus(op: Float): FloatBinding = this.add(op)

/** Operator for [add]. */
inline operator fun LongExpression.plus(op: Long): LongBinding = this.add(op)

/** Operator for [add]. */
inline operator fun LongExpression.plus(op: Int): LongBinding = this.add(op)

/** Operator for [add]. */
inline operator fun Int.plus(op: ObservableNumberValue): IntegerBinding = add(this, op) as IntegerBinding

/** Operator for [add]. */
inline operator fun IntegerExpression.plus(op: ObservableNumberValue): NumberBinding = this.add(op)

/** Operator for [add]. */
inline operator fun IntegerExpression.plus(op: Double): DoubleBinding = this.add(op)

/** Operator for [add]. */
inline operator fun IntegerExpression.plus(op: Float): FloatBinding = this.add(op)

/** Operator for [add]. */
inline operator fun IntegerExpression.plus(op: Long): LongBinding = this.add(op)

/** Operator for [add]. */
inline operator fun IntegerExpression.plus(op: Int): IntegerBinding = this.add(op)

/** Operator for [subtract]. */
inline operator fun Double.minus(op: ObservableNumberValue): DoubleBinding = subtract(this, op)

/** Operator for [subtract]. */
inline operator fun DoubleExpression.minus(op: ObservableNumberValue): DoubleBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun DoubleExpression.minus(op: Double): DoubleBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun DoubleExpression.minus(op: Float): DoubleBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun DoubleExpression.minus(op: Long): DoubleBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun DoubleExpression.minus(op: Int): DoubleBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun Float.minus(op: ObservableNumberValue): FloatBinding = subtract(this, op) as FloatBinding

/** Operator for [subtract]. */
inline operator fun FloatExpression.minus(op: ObservableNumberValue): NumberBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun FloatExpression.minus(op: Double): DoubleBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun FloatExpression.minus(op: Float): FloatBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun FloatExpression.minus(op: Long): FloatBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun FloatExpression.minus(op: Int): FloatBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun Long.minus(op: ObservableNumberValue): LongBinding = subtract(this, op) as LongBinding

/** Operator for [subtract]. */
inline operator fun LongExpression.minus(op: ObservableNumberValue): NumberBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun LongExpression.minus(op: Double): DoubleBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun LongExpression.minus(op: Float): FloatBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun LongExpression.minus(op: Long): LongBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun LongExpression.minus(op: Int): LongBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun Int.minus(op: ObservableNumberValue): IntegerBinding = subtract(this, op) as IntegerBinding

/** Operator for [subtract]. */
inline operator fun IntegerExpression.minus(op: ObservableNumberValue): NumberBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun IntegerExpression.minus(op: Double): DoubleBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun IntegerExpression.minus(op: Float): FloatBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun IntegerExpression.minus(op: Long): LongBinding = this.subtract(op)

/** Operator for [subtract]. */
inline operator fun IntegerExpression.minus(op: Int): IntegerBinding = this.subtract(op)

/** Operator for [multiply]. */
inline operator fun Double.times(op: ObservableNumberValue): DoubleBinding = multiply(this, op)

/** Operator for [multiply]. */
inline operator fun DoubleExpression.times(op: ObservableNumberValue): DoubleBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun DoubleExpression.times(op: Double): DoubleBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun DoubleExpression.times(op: Float): DoubleBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun DoubleExpression.times(op: Long): DoubleBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun DoubleExpression.times(op: Int): DoubleBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun Float.times(op: ObservableNumberValue): FloatBinding = multiply(this, op) as FloatBinding

/** Operator for [multiply]. */
inline operator fun FloatExpression.times(op: ObservableNumberValue): NumberBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun FloatExpression.times(op: Double): DoubleBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun FloatExpression.times(op: Float): FloatBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun FloatExpression.times(op: Long): FloatBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun FloatExpression.times(op: Int): FloatBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun Long.times(op: ObservableNumberValue): LongBinding = multiply(this, op) as LongBinding

/** Operator for [multiply]. */
inline operator fun LongExpression.times(op: ObservableNumberValue): NumberBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun LongExpression.times(op: Double): DoubleBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun LongExpression.times(op: Float): FloatBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun LongExpression.times(op: Long): LongBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun LongExpression.times(op: Int): LongBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun Int.times(op: ObservableNumberValue): IntegerBinding = multiply(this, op) as IntegerBinding

/** Operator for [multiply]. */
inline operator fun IntegerExpression.times(op: ObservableNumberValue): NumberBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun IntegerExpression.times(op: Double): DoubleBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun IntegerExpression.times(op: Float): FloatBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun IntegerExpression.times(op: Long): LongBinding = this.multiply(op)

/** Operator for [multiply]. */
inline operator fun IntegerExpression.times(op: Int): IntegerBinding = this.multiply(op)

/** Operator for [divide]. */
inline operator fun Double.div(op: ObservableNumberValue): DoubleBinding = divide(this, op)

/** Operator for [divide]. */
inline operator fun DoubleExpression.div(op: ObservableNumberValue): DoubleBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun DoubleExpression.div(op: Double): DoubleBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun DoubleExpression.div(op: Float): DoubleBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun DoubleExpression.div(op: Long): DoubleBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun DoubleExpression.div(op: Int): DoubleBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun Float.div(op: ObservableNumberValue): FloatBinding = divide(this, op) as FloatBinding

/** Operator for [divide]. */
inline operator fun FloatExpression.div(op: ObservableNumberValue): NumberBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun FloatExpression.div(op: Double): DoubleBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun FloatExpression.div(op: Float): FloatBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun FloatExpression.div(op: Long): FloatBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun FloatExpression.div(op: Int): FloatBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun Long.div(op: ObservableNumberValue): LongBinding = divide(this, op) as LongBinding

/** Operator for [divide]. */
inline operator fun LongExpression.div(op: ObservableNumberValue): NumberBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun LongExpression.div(op: Double): DoubleBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun LongExpression.div(op: Float): FloatBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun LongExpression.div(op: Long): LongBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun LongExpression.div(op: Int): LongBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun Int.div(op: ObservableNumberValue): IntegerBinding = divide(this, op) as IntegerBinding

/** Operator for [divide]. */
inline operator fun IntegerExpression.div(op: ObservableNumberValue): NumberBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun IntegerExpression.div(op: Double): DoubleBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun IntegerExpression.div(op: Float): FloatBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun IntegerExpression.div(op: Long): LongBinding = this.divide(op)

/** Operator for [divide]. */
inline operator fun IntegerExpression.div(op: Int): IntegerBinding = this.divide(op)