@file:JvmMultifileClass
@file:JvmName("BindingKt")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.LongBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding
import javafx.beans.value.ObservableObjectValue
import javafx.beans.value.ObservableValue

/** Infix typing for [Bindings.equal]. */
infix fun ObservableObjectValue<*>.eq(op: ObservableObjectValue<*>): BooleanBinding =
    Bindings.equal(this, op)

/** Infix typing for [Bindings.equal]. */
infix fun ObservableObjectValue<*>.eq(op: Any): BooleanBinding =
    Bindings.equal(this, op)

/** Infix typing for [Bindings.equal]. */
infix fun Any.eq(op: ObservableObjectValue<*>): BooleanBinding =
    Bindings.equal(this, op)

/** Infix typing for [Bindings.notEqual]. */
infix fun ObservableObjectValue<*>.neq(op: ObservableObjectValue<*>): BooleanBinding =
    Bindings.notEqual(this, op)

/** Infix typing for [Bindings.notEqual]. */
infix fun ObservableObjectValue<*>.neq(op: Any): BooleanBinding =
    Bindings.notEqual(this, op)

/** Infix typing for [Bindings.notEqual]. */
infix fun Any.neq(op: ObservableObjectValue<*>): BooleanBinding =
    Bindings.notEqual(this, op)

/** Creates an object binding used to get a member. */
fun <T> ObservableValue<*>.select(vararg steps: String): ObjectBinding<T> =
    Bindings.select(this, *steps)

/** Creates a double binding used to get a member. */
fun ObservableValue<*>.selectDouble(vararg steps: String): DoubleBinding =
    Bindings.selectDouble(this, *steps)

/** Creates a float binding used to get a member. */
fun ObservableValue<*>.selectFloat(vararg steps: String): FloatBinding =
    Bindings.selectFloat(this, *steps)

/** Creates an integer binding used to get a member. */
fun ObservableValue<*>.selectInt(vararg steps: String): IntegerBinding =
    Bindings.selectInteger(this, *steps)

/** Creates a long binding used to get a member. */
fun ObservableValue<*>.selectLong(vararg steps: String): LongBinding =
    Bindings.selectLong(this, *steps)

/** Creates a boolean binding used to get a member. */
fun ObservableValue<*>.selectBoolean(vararg steps: String): BooleanBinding =
    Bindings.selectBoolean(this, *steps)

/** Creates a string binding used to get a member. */
fun ObservableValue<*>.selectString(vararg steps: String): StringBinding =
    Bindings.selectString(this, *steps)
