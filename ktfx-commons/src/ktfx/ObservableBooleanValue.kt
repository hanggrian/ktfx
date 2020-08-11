@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.WritableBooleanValue
import kotlin.reflect.KProperty

/** Delegated property of this read-only [Boolean] value, use with `by` keyword. */
inline operator fun ObservableBooleanValue.getValue(
    thisRef: Any?,
    property: KProperty<*>
): Boolean = get()

/** Delegated property of this writable [Boolean] value, use with `by` keyword. */
inline operator fun WritableBooleanValue.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: Boolean
): Unit = set(value)

/**
 * Creates a [BooleanBinding] that calculates the conditional-AND
 * operation on the value of two instance of [ObservableBooleanValue].
 */
inline infix fun ObservableBooleanValue.and(other: ObservableBooleanValue): BooleanBinding =
    Bindings.and(this, other)

/**
 * Creates a [BooleanBinding] that calculates the conditional-OR
 * operation on the value of two instance of [ObservableBooleanValue].
 */
inline infix fun ObservableBooleanValue.or(other: ObservableBooleanValue): BooleanBinding =
    Bindings.or(this, other)

/**
 * Creates a new [BooleanBinding] that holds `true`
 * if the values of two instances of [ObservableBooleanValue] are equal.
 */
inline infix fun ObservableBooleanValue.eq(other: ObservableBooleanValue): BooleanBinding =
    Bindings.equal(this, other)

/**
 * Creates a new [BooleanBinding] that holds `true`
 * if the values of two instances of [ObservableBooleanValue] are not equal.
 */
inline infix fun ObservableBooleanValue.neq(other: ObservableBooleanValue): BooleanBinding =
    Bindings.notEqual(this, other)
