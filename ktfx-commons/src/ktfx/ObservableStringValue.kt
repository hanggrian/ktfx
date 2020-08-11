@file:JvmMultifileClass
@file:JvmName("ObservableStringValueKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableStringValue
import javafx.beans.value.WritableStringValue
import kotlin.reflect.KProperty

/** Delegated property of this read-only [String] value, use with `by` keyword. */
inline operator fun ObservableStringValue.getValue(
    thisRef: Any?,
    property: KProperty<*>
): String? = get()

/** Delegated property of this writable [String] value, use with `by` keyword. */
inline operator fun WritableStringValue.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: String?
): Unit = set(value)

/** Infix alias of [Bindings.equal]. */
inline infix fun ObservableStringValue.eq(other: ObservableStringValue): BooleanBinding = Bindings.equal(this, other)

/** Infix alias of [Bindings.equal]. */
inline infix fun ObservableStringValue.eq(other: String): BooleanBinding = Bindings.equal(this, other)

/** Infix alias of [Bindings.equal]. */
inline infix fun String.eq(other: ObservableStringValue): BooleanBinding = Bindings.equal(this, other)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun ObservableStringValue.neq(other: ObservableStringValue): BooleanBinding =
    Bindings.notEqual(this, other)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun ObservableStringValue.neq(other: String): BooleanBinding = Bindings.notEqual(this, other)

/** Infix alias of [Bindings.notEqual]. */
inline infix fun String.neq(other: ObservableStringValue): BooleanBinding = Bindings.notEqual(this, other)

/** Infix alias of [Bindings.equalIgnoreCase]. */
inline infix fun ObservableStringValue.eqIg(other: ObservableStringValue): BooleanBinding =
    Bindings.equalIgnoreCase(this, other)

/** Infix alias of [Bindings.equalIgnoreCase]. */
inline infix fun ObservableStringValue.eqIg(other: String): BooleanBinding = Bindings.equalIgnoreCase(this, other)

/** Infix alias of [Bindings.equalIgnoreCase]. */
inline infix fun String.eqIg(other: ObservableStringValue): BooleanBinding = Bindings.equalIgnoreCase(this, other)

/** Infix alias of [Bindings.notEqualIgnoreCase]. */
inline infix fun ObservableStringValue.neqIg(other: ObservableStringValue): BooleanBinding =
    Bindings.notEqualIgnoreCase(this, other)

/** Infix alias of [Bindings.notEqualIgnoreCase]. */
inline infix fun ObservableStringValue.neqIg(other: String): BooleanBinding = Bindings.notEqualIgnoreCase(this, other)

/** Infix alias of [Bindings.notEqualIgnoreCase]. */
inline infix fun String.neqIg(other: ObservableStringValue): BooleanBinding = Bindings.notEqualIgnoreCase(this, other)

/** Infix alias of [Bindings.greaterThan]. */
inline infix fun ObservableStringValue.greater(other: ObservableStringValue): BooleanBinding =
    Bindings.greaterThan(this, other)

/** Infix alias of [Bindings.greaterThan]. */
inline infix fun ObservableStringValue.greater(other: String): BooleanBinding = Bindings.greaterThan(this, other)

/** Infix alias of [Bindings.greaterThan]. */
inline infix fun String.greater(other: ObservableStringValue): BooleanBinding = Bindings.greaterThan(this, other)

/** Infix alias of [Bindings.lessThan]. */
inline infix fun ObservableStringValue.less(other: ObservableStringValue): BooleanBinding =
    Bindings.lessThan(this, other)

/** Infix alias of [Bindings.lessThan]. */
inline infix fun ObservableStringValue.less(other: String): BooleanBinding = Bindings.lessThan(this, other)

/** Infix alias of [Bindings.lessThan]. */
inline infix fun String.less(other: ObservableStringValue): BooleanBinding = Bindings.lessThan(this, other)

/** Infix alias of [Bindings.greaterThanOrEqual]. */
inline infix fun ObservableStringValue.greaterEq(other: ObservableStringValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/** Infix alias of [Bindings.greaterThanOrEqual]. */
inline infix fun ObservableStringValue.greaterEq(other: String): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/** Infix alias of [Bindings.greaterThanOrEqual]. */
inline infix fun String.greaterEq(other: ObservableStringValue): BooleanBinding =
    Bindings.greaterThanOrEqual(this, other)

/** Infix alias of [Bindings.lessThanOrEqual]. */
inline infix fun ObservableStringValue.lessEq(other: ObservableStringValue): BooleanBinding =
    Bindings.lessThanOrEqual(this, other)

/** Infix alias of [Bindings.lessThanOrEqual]. */
inline infix fun ObservableStringValue.lessEq(other: String): BooleanBinding = Bindings.lessThanOrEqual(this, other)

/** Infix alias of [Bindings.lessThanOrEqual]. */
inline infix fun String.lessEq(other: ObservableStringValue): BooleanBinding = Bindings.lessThanOrEqual(this, other)
