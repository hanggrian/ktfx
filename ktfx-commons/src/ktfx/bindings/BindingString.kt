@file:JvmMultifileClass
@file:JvmName("BindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableStringValue

/** Infix typing for [Bindings.equal]. */
infix fun ObservableStringValue.eq(op: ObservableStringValue): BooleanBinding =
    Bindings.equal(this, op)

/** Infix typing for [Bindings.equal]. */
infix fun ObservableStringValue.eq(op: String): BooleanBinding =
    Bindings.equal(this, op)

/** Infix typing for [Bindings.equal]. */
infix fun String.eq(op: ObservableStringValue): BooleanBinding =
    Bindings.equal(this, op)

/** Infix typing for [Bindings.notEqual]. */
infix fun ObservableStringValue.neq(op: ObservableStringValue): BooleanBinding =
    Bindings.notEqual(this, op)

/** Infix typing for [Bindings.notEqual]. */
infix fun ObservableStringValue.neq(op: String): BooleanBinding =
    Bindings.notEqual(this, op)

/** Infix typing for [Bindings.notEqual]. */
infix fun String.neq(op: ObservableStringValue): BooleanBinding =
    Bindings.notEqual(this, op)

/** Infix typing for [Bindings.equalIgnoreCase]. */
infix fun ObservableStringValue.eqIg(op: ObservableStringValue): BooleanBinding =
    Bindings.equalIgnoreCase(this, op)

/** Infix typing for [Bindings.equalIgnoreCase]. */
infix fun ObservableStringValue.eqIg(op: String): BooleanBinding =
    Bindings.equalIgnoreCase(this, op)

/** Infix typing for [Bindings.equalIgnoreCase]. */
infix fun String.eqIg(op: ObservableStringValue): BooleanBinding =
    Bindings.equalIgnoreCase(this, op)

/** Infix typing for [Bindings.notEqualIgnoreCase]. */
infix fun ObservableStringValue.neqIg(op: ObservableStringValue): BooleanBinding =
    Bindings.notEqualIgnoreCase(this, op)

/** Infix typing for [Bindings.notEqualIgnoreCase]. */
infix fun ObservableStringValue.neqIg(op: String): BooleanBinding =
    Bindings.notEqualIgnoreCase(this, op)

/** Infix typing for [Bindings.notEqualIgnoreCase]. */
infix fun String.neqIg(op: ObservableStringValue): BooleanBinding =
    Bindings.notEqualIgnoreCase(this, op)

/** Infix typing for [Bindings.greaterThan]. */
infix fun ObservableStringValue.greater(op: ObservableStringValue): BooleanBinding =
    Bindings.greaterThan(this, op)

/** Infix typing for [Bindings.greaterThan]. */
infix fun ObservableStringValue.greater(op: String): BooleanBinding =
    Bindings.greaterThan(this, op)

/** Infix typing for [Bindings.greaterThan]. */
infix fun String.greater(op: ObservableStringValue): BooleanBinding =
    Bindings.greaterThan(this, op)

/** Infix typing for [Bindings.lessThan]. */
infix fun ObservableStringValue.less(op: ObservableStringValue): BooleanBinding =
    Bindings.lessThan(this, op)

/** Infix typing for [Bindings.lessThan]. */
infix fun ObservableStringValue.less(op: String): BooleanBinding =
    Bindings.lessThan(this, op)

/** Infix typing for [Bindings.lessThan]. */
infix fun String.less(op: ObservableStringValue): BooleanBinding =
    Bindings.lessThan(this, op)

/** Infix typing for [Bindings.greaterThanOrEqual]. */
infix fun ObservableStringValue.greaterEq(op: ObservableStringValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, op)

/** Infix typing for [Bindings.greaterThanOrEqual]. */
infix fun ObservableStringValue.greaterEq(op: String): BooleanBinding =
    Bindings.greaterThanOrEqual(this, op)

/** Infix typing for [Bindings.greaterThanOrEqual]. */
infix fun String.greaterEq(op: ObservableStringValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, op)

/** Infix typing for [Bindings.lessThanOrEqual]. */
infix fun ObservableStringValue.lessEq(op: ObservableStringValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, op)

/** Infix typing for [Bindings.lessThanOrEqual]. */
infix fun ObservableStringValue.lessEq(op: String): BooleanBinding =
    Bindings.lessThanOrEqual(this, op)

/** Infix typing for [Bindings.lessThanOrEqual]. */
infix fun String.lessEq(op: ObservableStringValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, op)
