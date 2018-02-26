@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.Bindings.and
import javafx.beans.binding.Bindings.createBooleanBinding
import javafx.beans.binding.Bindings.equal
import javafx.beans.binding.Bindings.not
import javafx.beans.binding.Bindings.notEqual
import javafx.beans.binding.Bindings.or
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableBooleanValue
import java.util.concurrent.Callable

/** Helper function to create a custom [BooleanBinding]. */
inline fun booleanBindingOf(vararg dependencies: Observable, noinline func: () -> Boolean): BooleanBinding = createBooleanBinding(Callable(func), *dependencies)

/** Creates a [BooleanBinding] that calculates the conditional-AND operation on the value of two instance of [ObservableBooleanValue]. */
inline infix fun ObservableBooleanValue.and(other: ObservableBooleanValue): BooleanBinding = and(this, other)

/** Creates a [BooleanBinding] that calculates the conditional-OR operation on the value of two instance of [ObservableBooleanValue]. */
inline infix fun ObservableBooleanValue.or(other: ObservableBooleanValue): BooleanBinding = or(this, other)

/** Creates a {@link BooleanBinding} that calculates the inverse of the value of a [ObservableBooleanValue]. */
inline operator fun ObservableBooleanValue.not(): BooleanBinding = not(this)

/** Creates a new [BooleanBinding] that holds {@code true} if the values of two instances of [ObservableBooleanValue] are equal. */
inline infix fun ObservableBooleanValue.eq(other: ObservableBooleanValue): BooleanBinding = equal(this, other)

/** Creates a new [BooleanBinding] that holds {@code true} if the values of two instances of [ObservableBooleanValue] are not equal. */
inline infix fun ObservableBooleanValue.neq(other: ObservableBooleanValue): BooleanBinding = notEqual(this, other)