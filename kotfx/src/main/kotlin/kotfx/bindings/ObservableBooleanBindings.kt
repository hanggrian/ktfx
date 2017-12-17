@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.Bindings.*
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableBooleanValue
import java.util.concurrent.Callable

/** Helper function to create a custom [BooleanBinding]. */
inline fun booleanBindingOf(vararg dependencies: Observable, noinline func: () -> Boolean): BooleanBinding = createBooleanBinding(Callable { func() }, *dependencies)

/** Creates a [BooleanBinding] that calculates the conditional-AND operation on the value of two instance of [ObservableBooleanValue]. */
inline infix fun ObservableBooleanValue.and(other: ObservableBooleanValue): BooleanBinding = and(this, other)

/** Creates a [BooleanBinding] that calculates the conditional-OR operation on the value of two instance of [ObservableBooleanValue]. */
inline infix fun ObservableBooleanValue.or(other: ObservableBooleanValue): BooleanBinding = or(this, other)

/** Creates a {@link BooleanBinding} that calculates the inverse of the value of a [ObservableBooleanValue]. */
inline fun not(what: ObservableBooleanValue): BooleanBinding = Bindings.not(what)

/** Creates a new [BooleanBinding] that holds {@code true} if the values of two instances of [ObservableBooleanValue] are equal. */
inline infix fun ObservableBooleanValue.eq(other: ObservableBooleanValue): BooleanBinding = equal(this, other)

/** Creates a new [BooleanBinding] that holds {@code true} if the values of two instances of [ObservableBooleanValue] are not equal. */
inline infix fun ObservableBooleanValue.neq(other: ObservableBooleanValue): BooleanBinding = notEqual(this, other)