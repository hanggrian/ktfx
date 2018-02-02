@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.binding.*
import javafx.beans.binding.Bindings.*
import javafx.beans.value.ObservableValue

/** Creates an object binding used to get a member. */
inline fun <T> ObservableValue<*>.select(vararg steps: String): AnyBinding<T> = select(this, *steps)

/** Creates a double binding used to get a member. */
inline fun ObservableValue<*>.selectDouble(vararg steps: String): DoubleBinding = selectDouble(this, *steps)

/** Creates a float binding used to get a member. */
inline fun ObservableValue<*>.selectFloat(vararg steps: String): FloatBinding = selectFloat(this, *steps)

/** Creates an integer binding used to get a member. */
inline fun ObservableValue<*>.selectInt(vararg steps: String): IntBinding = selectInteger(this, *steps)

/** Creates a long binding used to get a member. */
inline fun ObservableValue<*>.selectLong(vararg steps: String): LongBinding = selectLong(this, *steps)

/** Creates a boolean binding used to get a member. */
inline fun ObservableValue<*>.selectBoolean(vararg steps: String): BooleanBinding = selectBoolean(this, *steps)

/** Creates a string binding used to get a member. */
inline fun ObservableValue<*>.selectString(vararg steps: String): StringBinding = selectString(this, *steps)

/** Creates an object binding used to get a member. */
inline fun <T> Any.select(vararg steps: String): AnyBinding<T> = select(this, *steps)

/** Creates a double binding used to get a member. */
inline fun Any.selectDouble(vararg steps: String): DoubleBinding = selectDouble(this, *steps)

/** Creates a float binding used to get a member. */
inline fun Any.selectFloat(vararg steps: String): FloatBinding = selectFloat(this, *steps)

/** Creates an integer binding used to get a member. */
inline fun Any.selectInt(vararg steps: String): IntBinding = selectInteger(this, *steps)

/** Creates a long binding used to get a member. */
inline fun Any.selectLong(vararg steps: String): LongBinding = selectLong(this, *steps)

/** Creates a boolean binding used to get a member. */
inline fun Any.selectBoolean(vararg steps: String): BooleanBinding = selectBoolean(this, *steps)

/** Creates a string binding used to get a member. */
inline fun Any.selectString(vararg steps: String): StringBinding = selectString(this, *steps)