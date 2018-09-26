@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.value

import javafx.beans.binding.Bindings.and
import javafx.beans.binding.Bindings.equal
import javafx.beans.binding.Bindings.notEqual
import javafx.beans.binding.Bindings.or
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableBooleanValue

/**
 * Creates a [BooleanBinding] that calculates the conditional-AND
 * operation on the value of two instance of [ObservableBooleanValue].
 */
inline infix fun ObservableBooleanValue.and(op: ObservableBooleanValue): BooleanBinding = and(this, op)

/**
 * Creates a [BooleanBinding] that calculates the conditional-OR
 * operation on the value of two instance of [ObservableBooleanValue].
 */
inline infix fun ObservableBooleanValue.or(op: ObservableBooleanValue): BooleanBinding = or(this, op)

/**
 * Creates a new [BooleanBinding] that holds `true`
 * if the values of two instances of [ObservableBooleanValue] are equal.
 */
inline infix fun ObservableBooleanValue.eq(op: ObservableBooleanValue): BooleanBinding = equal(this, op)

/**
 * Creates a new [BooleanBinding] that holds `true`
 * if the values of two instances of [ObservableBooleanValue] are not equal.
 */
inline infix fun ObservableBooleanValue.neq(op: ObservableBooleanValue): BooleanBinding = notEqual(this, op)