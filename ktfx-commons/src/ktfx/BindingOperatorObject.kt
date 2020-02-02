@file:JvmMultifileClass
@file:JvmName("BindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableObjectValue

/** Infix alias of [Bindings.equal]. */
inline infix fun ObservableObjectValue<*>.eq(op: ObservableObjectValue<*>): BooleanBinding = Bindings.equal(this, op)

/** Infix alias of [Bindings.equal]. */
inline infix fun ObservableObjectValue<*>.eq(op: Any): BooleanBinding = Bindings.equal(this, op)

/** Infix alias of [Bindings.equal]. */
inline infix fun Any.eq(op: ObservableObjectValue<*>): BooleanBinding = Bindings.equal(this, op)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun ObservableObjectValue<*>.neq(op: ObservableObjectValue<*>): BooleanBinding =
    Bindings.notEqual(this, op)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun ObservableObjectValue<*>.neq(op: Any): BooleanBinding = Bindings.notEqual(this, op)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun Any.neq(op: ObservableObjectValue<*>): BooleanBinding = Bindings.notEqual(this, op)
