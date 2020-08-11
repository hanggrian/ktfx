@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableObjectValue

/** Infix alias of [Bindings.equal]. */
inline infix fun ObservableObjectValue<*>.eq(other: ObservableObjectValue<*>): BooleanBinding =
    Bindings.equal(this, other)

/** Infix alias of [Bindings.equal]. */
inline infix fun ObservableObjectValue<*>.eq(other: Any): BooleanBinding =
    Bindings.equal(this, other)

/** Infix alias of [Bindings.equal]. */
inline infix fun Any.eq(other: ObservableObjectValue<*>): BooleanBinding =
    Bindings.equal(this, other)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun ObservableObjectValue<*>.neq(other: ObservableObjectValue<*>): BooleanBinding =
    Bindings.notEqual(this, other)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun ObservableObjectValue<*>.neq(other: Any): BooleanBinding =
    Bindings.notEqual(this, other)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun Any.neq(other: ObservableObjectValue<*>): BooleanBinding =
    Bindings.notEqual(this, other)
