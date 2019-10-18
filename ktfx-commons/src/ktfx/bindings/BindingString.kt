@file:JvmMultifileClass
@file:JvmName("BindingKt")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding
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

/** Binding of [String.trim]. */
fun ObservableStringValue.trim(predicate: (Char) -> Boolean): StringBinding =
    buildStringBinding(this) { get().trim(predicate) }

/** Binding of [String.trimStart]. */
fun ObservableStringValue.trimStart(predicate: (Char) -> Boolean): StringBinding =
    buildStringBinding(this) { get().trimStart(predicate) }

/** Binding of [String.trimEnd]. */
fun ObservableStringValue.trimEnd(predicate: (Char) -> Boolean): StringBinding =
    buildStringBinding(this) { get().trimEnd(predicate) }

/** Binding of [String.trim]. */
fun ObservableStringValue.trim(): StringBinding =
    buildStringBinding(this) { get().trim() }

/** Binding of [String.trimStart]. */
fun ObservableStringValue.trimStart(): StringBinding =
    buildStringBinding(this) { get().trimStart() }

/** Binding of [String.trimEnd]. */
fun ObservableStringValue.trimEnd(): StringBinding =
    buildStringBinding(this) { get().trimEnd() }

/** Binding of [String.padStart]. */
fun ObservableStringValue.padStart(
    length: Int,
    padChar: Char = ' '
): StringBinding = buildStringBinding(this) { get().padStart(length, padChar) }

/** Binding of [String.padEnd]. */
fun ObservableStringValue.padEnd(
    length: Int,
    padChar: Char = ' '
): StringBinding = buildStringBinding(this) { get().padEnd(length, padChar) }

/** Binding of [String.isNullOrBlank]. */
fun ObservableStringValue.isNullOrBlank(): BooleanBinding =
    buildBooleanBinding(this) { get().isNullOrBlank() }

/** Binding of [String.isNullOrEmpty]. */
fun ObservableStringValue.isNullOrEmpty(): BooleanBinding =
    buildBooleanBinding(this) { get().isNullOrEmpty() }

/** Binding of [String.orEmpty]. */
fun ObservableStringValue.orEmpty(): StringBinding =
    buildStringBinding(this) { get().orEmpty() }

/** Binding of [String.indices]. */
val ObservableStringValue.indices: ObjectBinding<IntRange>
    get() = buildBinding(this) { get().indices }

/** Binding of [String.indices]. */
val ObservableStringValue.lastIndex: IntegerBinding
    get() = buildIntBinding(this) { get().lastIndex }

/** Binding of [String.isBlank]. */
fun ObservableStringValue.isBlank(): BooleanBinding =
    buildBooleanBinding(this) { get().isBlank() }

/** Binding of [String.isNotBlank]. */
fun ObservableStringValue.isNotBlank(): BooleanBinding =
    buildBooleanBinding(this) { get().isNotBlank() }
