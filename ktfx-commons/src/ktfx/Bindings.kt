@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.LongBinding
import javafx.beans.binding.NumberBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding
import javafx.beans.binding.When
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableNumberValue
import javafx.beans.value.ObservableObjectValue
import javafx.beans.value.ObservableStringValue
import java.util.concurrent.Callable

/** Helper function to create a custom [ObjectBinding]. */
inline fun <T> buildBinding(
    vararg dependencies: Observable,
    noinline func: () -> T?
): ObjectBinding<T> = Bindings.createObjectBinding<T>(Callable(func), *dependencies)

/** Helper function to create a custom [ObjectBinding]. */
inline fun <T> buildBinding(
    dependencies: Collection<Observable>,
    noinline func: () -> T?
): ObjectBinding<T> = buildBinding(*dependencies.toTypedArray(), func = func)

/** Creates an object binding used to get a member. */
inline fun <T> Any.select(vararg steps: String): ObjectBinding<T> = Bindings.select(this, *steps)

/** Helper function to create a custom [BooleanBinding]. */
inline fun buildBooleanBinding(
    vararg dependencies: Observable,
    noinline func: () -> Boolean?
): BooleanBinding = Bindings.createBooleanBinding(Callable(func), *dependencies)

/** Helper function to create a custom [BooleanBinding]. */
inline fun buildBooleanBinding(
    dependencies: Collection<Observable>,
    noinline func: () -> Boolean?
): BooleanBinding = buildBooleanBinding(*dependencies.toTypedArray(), func = func)

/** Creates a boolean binding used to get a member. */
inline fun Any.selectBoolean(vararg steps: String): BooleanBinding = Bindings.selectBoolean(this, *steps)

/** Helper function to create a custom [StringBinding]. */
inline fun buildStringBinding(
    vararg dependencies: Observable,
    noinline func: () -> String?
): StringBinding = Bindings.createStringBinding(Callable(func), *dependencies)

/** Helper function to create a custom [StringBinding]. */
inline fun buildStringBinding(
    dependencies: Collection<Observable>,
    noinline func: () -> String?
): StringBinding = buildStringBinding(*dependencies.toTypedArray(), func = func)

/** Creates a string binding used to get a member. */
inline fun Any.selectString(vararg steps: String): StringBinding = Bindings.selectString(this, *steps)

/** Helper function to create a custom [DoubleBinding]. */
inline fun buildDoubleBinding(
    vararg dependencies: Observable,
    noinline func: () -> Double?
): DoubleBinding = Bindings.createDoubleBinding(Callable(func), *dependencies)

/** Helper function to create a custom [DoubleBinding]. */
inline fun buildDoubleBinding(
    dependencies: Collection<Observable>,
    noinline func: () -> Double?
): DoubleBinding = buildDoubleBinding(*dependencies.toTypedArray(), func = func)

/** Helper function to create a custom [FloatBinding]. */
inline fun buildFloatBinding(
    vararg dependencies: Observable,
    noinline func: () -> Float?
): FloatBinding = Bindings.createFloatBinding(Callable(func), *dependencies)

/** Helper function to create a custom [FloatBinding]. */
inline fun buildFloatBinding(
    dependencies: Collection<Observable>,
    noinline func: () -> Float?
): FloatBinding = buildFloatBinding(*dependencies.toTypedArray(), func = func)

/** Helper function to create a custom [IntegerBinding]. */
inline fun buildIntBinding(
    vararg dependencies: Observable,
    noinline func: () -> Int?
): IntegerBinding = Bindings.createIntegerBinding(Callable(func), *dependencies)

/** Helper function to create a custom [IntegerBinding]. */
inline fun buildIntBinding(
    dependencies: Collection<Observable>,
    noinline func: () -> Int?
): IntegerBinding = buildIntBinding(*dependencies.toTypedArray(), func = func)

/** Helper function to create a custom [LongBinding]. */
inline fun buildLongBinding(
    vararg dependencies: Observable,
    noinline func: () -> Long?
): LongBinding = Bindings.createLongBinding(Callable(func), *dependencies)

/** Helper function to create a custom [LongBinding]. */
inline fun buildLongBinding(
    dependencies: Collection<Observable>,
    noinline func: () -> Long?
): LongBinding = buildLongBinding(*dependencies.toTypedArray(), func = func)

/** Creates a double binding used to get a member. */
inline fun Any.selectDouble(vararg steps: String): DoubleBinding = Bindings.selectDouble(this, *steps)

/** Creates a float binding used to get a member. */
inline fun Any.selectFloat(vararg steps: String): FloatBinding = Bindings.selectFloat(this, *steps)

/** Creates an integer binding used to get a member. */
inline fun Any.selectInt(vararg steps: String): IntegerBinding = Bindings.selectInteger(this, *steps)

/** Creates a long binding used to get a member. */
inline fun Any.selectLong(vararg steps: String): LongBinding = Bindings.selectLong(this, *steps)

/** Public alias for infix typing. */
inline infix fun When.then(value: ObservableNumberValue): When.NumberConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: Double): When.NumberConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: Float): When.NumberConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: Long): When.NumberConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: Int): When.NumberConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.NumberConditionBuilder.otherwise(value: ObservableNumberValue): NumberBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.NumberConditionBuilder.otherwise(value: Double): DoubleBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.NumberConditionBuilder.otherwise(value: Float): NumberBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.NumberConditionBuilder.otherwise(value: Long): NumberBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.NumberConditionBuilder.otherwise(value: Int): NumberBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: ObservableBooleanValue): When.BooleanConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: Boolean): When.BooleanConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.BooleanConditionBuilder.otherwise(value: ObservableBooleanValue): BooleanBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.BooleanConditionBuilder.otherwise(value: Boolean): BooleanBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: ObservableStringValue): When.StringConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: String): When.StringConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.StringConditionBuilder.otherwise(value: ObservableStringValue): StringBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.StringConditionBuilder.otherwise(value: String): StringBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun <T> When.then(value: ObservableObjectValue<T>): When.ObjectConditionBuilder<T> =
    then(value)

/** Public alias for infix typing. */
inline infix fun <T> When.then(value: T?): When.ObjectConditionBuilder<T> =
    then(value)

/** Public alias for infix typing. */
inline infix fun <T> When.ObjectConditionBuilder<T>.otherwise(value: ObservableObjectValue<T>): ObjectBinding<T> =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun <T> When.ObjectConditionBuilder<T>.otherwise(value: T?): ObjectBinding<T> =
    otherwise(value)