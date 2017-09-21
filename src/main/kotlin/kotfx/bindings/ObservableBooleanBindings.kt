@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableBooleanValue

/** Creates a [BooleanBinding] that calculates the conditional-AND operation on the value of two instance of [ObservableBooleanValue]. */
inline infix fun ObservableBooleanValue.and(other: ObservableBooleanValue): BooleanBinding = Bindings.and(this, other)

/** Creates a [BooleanBinding] that calculates the conditional-OR operation on the value of two instance of [ObservableBooleanValue]. */
inline infix fun ObservableBooleanValue.or(other: ObservableBooleanValue): BooleanBinding = Bindings.or(this, other)

/** Creates a new [BooleanBinding] that holds {@code true} if the values of two instances of [ObservableBooleanValue] are equal. */
inline infix fun ObservableBooleanValue.eq(other: ObservableBooleanValue): BooleanBinding = Bindings.equal(this, other)

/** Creates a new [BooleanBinding] that holds {@code true} if the values of two instances of [ObservableBooleanValue] are not equal. */
inline infix fun ObservableBooleanValue.neq(other: ObservableBooleanValue): BooleanBinding = Bindings.notEqual(this, other)