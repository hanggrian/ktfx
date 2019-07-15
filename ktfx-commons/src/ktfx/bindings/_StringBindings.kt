@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings.equal
import javafx.beans.binding.Bindings.equalIgnoreCase
import javafx.beans.binding.Bindings.greaterThan
import javafx.beans.binding.Bindings.greaterThanOrEqual
import javafx.beans.binding.Bindings.lessThan
import javafx.beans.binding.Bindings.lessThanOrEqual
import javafx.beans.binding.Bindings.notEqual
import javafx.beans.binding.Bindings.notEqualIgnoreCase
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding
import javafx.beans.value.ObservableStringValue

/** Infix typing for [equal]. */
inline infix fun ObservableStringValue.eq(op: ObservableStringValue): BooleanBinding = equal(this, op)

/** Infix typing for [equal]. */
inline infix fun ObservableStringValue.eq(op: String): BooleanBinding = equal(this, op)

/** Infix typing for [equal]. */
inline infix fun String.eq(op: ObservableStringValue): BooleanBinding = equal(this, op)

/** Infix typing for [notEqual]. */
inline infix fun ObservableStringValue.neq(op: ObservableStringValue): BooleanBinding = notEqual(this, op)

/** Infix typing for [notEqual]. */
inline infix fun ObservableStringValue.neq(op: String): BooleanBinding = notEqual(this, op)

/** Infix typing for [notEqual]. */
inline infix fun String.neq(op: ObservableStringValue): BooleanBinding = notEqual(this, op)

/** Infix typing for [equalIgnoreCase]. */
inline infix fun ObservableStringValue.eqIg(op: ObservableStringValue): BooleanBinding = equalIgnoreCase(this, op)

/** Infix typing for [equalIgnoreCase]. */
inline infix fun ObservableStringValue.eqIg(op: String): BooleanBinding = equalIgnoreCase(this, op)

/** Infix typing for [equalIgnoreCase]. */
inline infix fun String.eqIg(op: ObservableStringValue): BooleanBinding = equalIgnoreCase(this, op)

/** Infix typing for [notEqualIgnoreCase]. */
inline infix fun ObservableStringValue.neqIg(op: ObservableStringValue): BooleanBinding = notEqualIgnoreCase(this, op)

/** Infix typing for [notEqualIgnoreCase]. */
inline infix fun ObservableStringValue.neqIg(op: String): BooleanBinding = notEqualIgnoreCase(this, op)

/** Infix typing for [notEqualIgnoreCase]. */
inline infix fun String.neqIg(op: ObservableStringValue): BooleanBinding = notEqualIgnoreCase(this, op)

/** Infix typing for [greaterThan]. */
inline infix fun ObservableStringValue.greater(op: ObservableStringValue): BooleanBinding = greaterThan(this, op)

/** Infix typing for [greaterThan]. */
inline infix fun ObservableStringValue.greater(op: String): BooleanBinding = greaterThan(this, op)

/** Infix typing for [greaterThan]. */
inline infix fun String.greater(op: ObservableStringValue): BooleanBinding = greaterThan(this, op)

/** Infix typing for [lessThan]. */
inline infix fun ObservableStringValue.less(op: ObservableStringValue): BooleanBinding = lessThan(this, op)

/** Infix typing for [lessThan]. */
inline infix fun ObservableStringValue.less(op: String): BooleanBinding = lessThan(this, op)

/** Infix typing for [lessThan]. */
inline infix fun String.less(op: ObservableStringValue): BooleanBinding = lessThan(this, op)

/** Infix typing for [greaterThanOrEqual]. */
inline infix fun ObservableStringValue.greaterEq(op: ObservableStringValue): BooleanBinding =
    greaterThanOrEqual(this, op)

/** Infix typing for [greaterThanOrEqual]. */
inline infix fun ObservableStringValue.greaterEq(op: String): BooleanBinding = greaterThanOrEqual(this, op)

/** Infix typing for [greaterThanOrEqual]. */
inline infix fun String.greaterEq(op: ObservableStringValue): BooleanBinding = greaterThanOrEqual(this, op)

/** Infix typing for [lessThanOrEqual]. */
inline infix fun ObservableStringValue.lessEq(op: ObservableStringValue): BooleanBinding = lessThanOrEqual(this, op)

/** Infix typing for [lessThanOrEqual]. */
inline infix fun ObservableStringValue.lessEq(op: String): BooleanBinding = lessThanOrEqual(this, op)

/** Infix typing for [lessThanOrEqual]. */
inline infix fun String.lessEq(op: ObservableStringValue): BooleanBinding = lessThanOrEqual(this, op)

/** Binding of [String.trim]. */
inline fun ObservableStringValue.trim(
    noinline predicate: (Char) -> Boolean
): StringBinding = buildStringBinding(this) { get().trim(predicate) }

/** Binding of [String.trimStart]. */
inline fun ObservableStringValue.trimStart(
    noinline predicate: (Char) -> Boolean
): StringBinding = buildStringBinding(this) { get().trimStart(predicate) }

/** Binding of [String.trimEnd]. */
inline fun ObservableStringValue.trimEnd(
    noinline predicate: (Char) -> Boolean
): StringBinding = buildStringBinding(this) { get().trimEnd(predicate) }

/** Binding of [String.trim]. */
inline fun ObservableStringValue.trim(): StringBinding = buildStringBinding(this) { get().trim() }

/** Binding of [String.trimStart]. */
inline fun ObservableStringValue.trimStart(): StringBinding =
    buildStringBinding(this) { get().trimStart() }

/** Binding of [String.trimEnd]. */
inline fun ObservableStringValue.trimEnd(): StringBinding = buildStringBinding(this) { get().trimEnd() }

/** Binding of [String.padStart]. */
inline fun ObservableStringValue.padStart(
    length: Int,
    padChar: Char = ' '
): StringBinding = buildStringBinding(this) { get().padStart(length, padChar) }

/** Binding of [String.padEnd]. */
inline fun ObservableStringValue.padEnd(
    length: Int,
    padChar: Char = ' '
): StringBinding = buildStringBinding(this) { get().padEnd(length, padChar) }

/** Binding of [String.isNullOrBlank]. */
inline fun ObservableStringValue.isNullOrBlank(): BooleanBinding =
    buildBooleanBinding(this) { get().isNullOrBlank() }

/** Binding of [String.isNullOrEmpty]. */
inline fun ObservableStringValue.isNullOrEmpty(): BooleanBinding =
    buildBooleanBinding(this) { get().isNullOrEmpty() }

/** Binding of [String.orEmpty]. */
inline fun ObservableStringValue.orEmpty(): StringBinding = buildStringBinding(this) { get().orEmpty() }

/** Binding of [String.indices]. */
inline val ObservableStringValue.indices: ObjectBinding<IntRange> get() = buildBinding(this) { get().indices }

/** Binding of [String.indices]. */
inline val ObservableStringValue.lastIndex: IntegerBinding get() = buildIntBinding(this) { get().lastIndex }

/** Binding of [String.isBlank]. */
inline fun ObservableStringValue.isBlank(): BooleanBinding = buildBooleanBinding(this) { get().isBlank() }

/** Binding of [String.isNotBlank]. */
inline fun ObservableStringValue.isNotBlank(): BooleanBinding =
    buildBooleanBinding(this) { get().isNotBlank() }
