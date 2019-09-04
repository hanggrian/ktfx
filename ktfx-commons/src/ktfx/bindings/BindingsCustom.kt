@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.LongBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding
import java.util.concurrent.Callable

/** Helper function to create a custom [ObjectBinding]. */
fun <T> buildBinding(
    vararg dependencies: Observable,
    func: () -> T?
): ObjectBinding<T> = Bindings.createObjectBinding<T>(Callable(func), *dependencies)

/** Helper function to create a custom [ObjectBinding]. */
inline fun <T> buildBinding(
    dependencies: Collection<Observable>,
    noinline func: () -> T?
): ObjectBinding<T> = buildBinding(*dependencies.toTypedArray(), func = func)

/** Helper function to create a custom [BooleanBinding]. */
fun buildBooleanBinding(
    vararg dependencies: Observable,
    func: () -> Boolean?
): BooleanBinding = Bindings.createBooleanBinding(Callable(func), *dependencies)

/** Helper function to create a custom [BooleanBinding]. */
inline fun buildBooleanBinding(
    dependencies: Collection<Observable>,
    noinline func: () -> Boolean?
): BooleanBinding = buildBooleanBinding(*dependencies.toTypedArray(), func = func)

/** Helper function to create a custom [StringBinding]. */
fun buildStringBinding(
    vararg dependencies: Observable,
    func: () -> String?
): StringBinding = Bindings.createStringBinding(Callable(func), *dependencies)

/** Helper function to create a custom [StringBinding]. */
inline fun buildStringBinding(
    dependencies: Collection<Observable>,
    noinline func: () -> String?
): StringBinding = buildStringBinding(*dependencies.toTypedArray(), func = func)

/** Helper function to create a custom [DoubleBinding]. */
fun buildDoubleBinding(
    vararg dependencies: Observable,
    func: () -> Double?
): DoubleBinding = Bindings.createDoubleBinding(Callable(func), *dependencies)

/** Helper function to create a custom [DoubleBinding]. */
inline fun buildDoubleBinding(
    dependencies: Collection<Observable>,
    noinline func: () -> Double?
): DoubleBinding = buildDoubleBinding(*dependencies.toTypedArray(), func = func)

/** Helper function to create a custom [FloatBinding]. */
fun buildFloatBinding(
    vararg dependencies: Observable,
    func: () -> Float?
): FloatBinding = Bindings.createFloatBinding(Callable(func), *dependencies)

/** Helper function to create a custom [FloatBinding]. */
inline fun buildFloatBinding(
    dependencies: Collection<Observable>,
    noinline func: () -> Float?
): FloatBinding = buildFloatBinding(*dependencies.toTypedArray(), func = func)

/** Helper function to create a custom [IntegerBinding]. */
fun buildIntBinding(
    vararg dependencies: Observable,
    func: () -> Int?
): IntegerBinding = Bindings.createIntegerBinding(Callable(func), *dependencies)

/** Helper function to create a custom [IntegerBinding]. */
inline fun buildIntBinding(
    dependencies: Collection<Observable>,
    noinline func: () -> Int?
): IntegerBinding = buildIntBinding(*dependencies.toTypedArray(), func = func)

/** Helper function to create a custom [LongBinding]. */
fun buildLongBinding(
    vararg dependencies: Observable,
    func: () -> Long?
): LongBinding = Bindings.createLongBinding(Callable(func), *dependencies)

/** Helper function to create a custom [LongBinding]. */
inline fun buildLongBinding(
    dependencies: Collection<Observable>,
    noinline func: () -> Long?
): LongBinding = buildLongBinding(*dependencies.toTypedArray(), func = func)

/** Creates a string binding used to get a member. */
fun Any.selectString(vararg steps: String): StringBinding =
    Bindings.selectString(this, *steps)

/** Creates an object binding used to get a member. */
fun <T> Any.select(vararg steps: String): ObjectBinding<T> =
    Bindings.select(this, *steps)

/** Creates a boolean binding used to get a member. */
fun Any.selectBoolean(vararg steps: String): BooleanBinding =
    Bindings.selectBoolean(this, *steps)

/** Creates a double binding used to get a member. */
fun Any.selectDouble(vararg steps: String): DoubleBinding =
    Bindings.selectDouble(this, *steps)

/** Creates a float binding used to get a member. */
fun Any.selectFloat(vararg steps: String): FloatBinding =
    Bindings.selectFloat(this, *steps)

/** Creates an integer binding used to get a member. */
fun Any.selectInt(vararg steps: String): IntegerBinding =
    Bindings.selectInteger(this, *steps)

/** Creates a long binding used to get a member. */
fun Any.selectLong(vararg steps: String): LongBinding =
    Bindings.selectLong(this, *steps)
