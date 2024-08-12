@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.BooleanExpression
import javafx.beans.value.ObservableBooleanValue

/**
 * Creates a [BooleanBinding] that calculates the conditional-AND
 * operation on the value of two instance of [ObservableBooleanValue].
 *
 * @see BooleanExpression.and
 */
inline infix fun ObservableBooleanValue.and(other: ObservableBooleanValue): BooleanBinding =
    Bindings.and(this, other)

/**
 * Creates a [BooleanBinding] that calculates the conditional-OR
 * operation on the value of two instance of [ObservableBooleanValue].
 *
 * @see BooleanExpression.or
 */
inline infix fun ObservableBooleanValue.or(other: ObservableBooleanValue): BooleanBinding =
    Bindings.or(this, other)

/**
 * Creates a new [BooleanBinding] that holds `true`
 * if the values of two instances of [ObservableBooleanValue] are equal.
 *
 * @see BooleanExpression.isEqualTo
 */
inline infix fun ObservableBooleanValue.eq(other: ObservableBooleanValue): BooleanBinding =
    Bindings.equal(this, other)

/**
 * Creates a new [BooleanBinding] that holds `true`
 * if the values of two instances of [ObservableBooleanValue] are not equal.
 *
 * @see BooleanExpression.isNotEqualTo
 */
inline infix fun ObservableBooleanValue.neq(other: ObservableBooleanValue): BooleanBinding =
    Bindings.notEqual(this, other)
