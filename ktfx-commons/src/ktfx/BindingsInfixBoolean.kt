@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableBooleanValue

/**
 * Creates a [BooleanBinding] that calculates the conditional-AND
 * operation on the value of two instance of [ObservableBooleanValue].
 */
inline infix fun ObservableBooleanValue.and(op: ObservableBooleanValue): BooleanBinding = Bindings.and(this, op)

/**
 * Creates a [BooleanBinding] that calculates the conditional-OR
 * operation on the value of two instance of [ObservableBooleanValue].
 */
inline infix fun ObservableBooleanValue.or(op: ObservableBooleanValue): BooleanBinding = Bindings.or(this, op)

/**
 * Creates a new [BooleanBinding] that holds `true`
 * if the values of two instances of [ObservableBooleanValue] are equal.
 */
inline infix fun ObservableBooleanValue.eq(op: ObservableBooleanValue): BooleanBinding = Bindings.equal(this, op)

/**
 * Creates a new [BooleanBinding] that holds `true`
 * if the values of two instances of [ObservableBooleanValue] are not equal.
 */
inline infix fun ObservableBooleanValue.neq(op: ObservableBooleanValue): BooleanBinding = Bindings.notEqual(this, op)
