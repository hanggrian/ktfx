@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.Bindings.equal
import javafx.beans.binding.Bindings.notEqual
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.LongBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding
import javafx.beans.value.ObservableObjectValue
import javafx.beans.value.ObservableValue

/** Infix typing for [equal]. */
inline infix fun ObservableObjectValue<*>.eq(op: ObservableObjectValue<*>): BooleanBinding = equal(this, op)

/** Infix typing for [equal]. */
inline infix fun ObservableObjectValue<*>.eq(op: Any): BooleanBinding = equal(this, op)

/** Infix typing for [equal]. */
inline infix fun Any.eq(op: ObservableObjectValue<*>): BooleanBinding = equal(this, op)

/** Infix typing for [notEqual]. */
inline infix fun ObservableObjectValue<*>.neq(op: ObservableObjectValue<*>): BooleanBinding = notEqual(this, op)

/** Infix typing for [notEqual]. */
inline infix fun ObservableObjectValue<*>.neq(op: Any): BooleanBinding = notEqual(this, op)

/** Infix typing for [notEqual]. */
inline infix fun Any.neq(op: ObservableObjectValue<*>): BooleanBinding = notEqual(this, op)

/** Creates an object binding used to get a member. */
inline fun <T> ObservableValue<*>.select(vararg steps: String): ObjectBinding<T> = Bindings.select(this, *steps)

/** Creates a double binding used to get a member. */
inline fun ObservableValue<*>.selectDouble(vararg steps: String): DoubleBinding = Bindings.selectDouble(this, *steps)

/** Creates a float binding used to get a member. */
inline fun ObservableValue<*>.selectFloat(vararg steps: String): FloatBinding = Bindings.selectFloat(this, *steps)

/** Creates an integer binding used to get a member. */
inline fun ObservableValue<*>.selectInt(vararg steps: String): IntegerBinding = Bindings.selectInteger(this, *steps)

/** Creates a long binding used to get a member. */
inline fun ObservableValue<*>.selectLong(vararg steps: String): LongBinding = Bindings.selectLong(this, *steps)

/** Creates a boolean binding used to get a member. */
inline fun ObservableValue<*>.selectBoolean(vararg steps: String): BooleanBinding = Bindings.selectBoolean(this, *steps)

/** Creates a string binding used to get a member. */
inline fun ObservableValue<*>.selectString(vararg steps: String): StringBinding = Bindings.selectString(this, *steps)