@file:JvmMultifileClass
@file:JvmName("ObservableArrayKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.beans.binding.Bindings
import javafx.beans.binding.IntegerBinding
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableNumberValue
import javafx.collections.FXCollections
import javafx.collections.ObservableIntegerArray

/** Returns an empty [ObservableIntegerArray]. */
fun observableIntArrayOf(): ObservableIntegerArray =
    FXCollections.observableIntegerArray()

/** Returns an [ObservableIntegerArray] of [elements]. */
fun observableIntArrayOf(vararg elements: Int): ObservableIntegerArray =
    FXCollections.observableIntegerArray(*elements)

/** Converts this [IntArray] to [ObservableIntegerArray]. */
inline fun IntArray.toObservableArray(): ObservableIntegerArray =
    observableIntArrayOf(*this)

/** Creates a copy of this [ObservableIntegerArray]. */
fun ObservableIntegerArray.toObservableArray(): ObservableIntegerArray =
    FXCollections.observableIntegerArray(this)

fun ObservableIntegerArray.getBinding(index: Int): IntegerBinding =
    Bindings.integerValueAt(this, index)

fun ObservableIntegerArray.getBinding(index: ObservableIntegerValue): IntegerBinding =
    Bindings.integerValueAt(this, index)

fun ObservableIntegerArray.getBinding(index: ObservableNumberValue): IntegerBinding =
    Bindings.integerValueAt(this, index)

operator fun ObservableIntegerArray.contains(value: Int): Boolean =
    (0 until size).any { get(it) == value }

inline operator fun ObservableIntegerArray.plusAssign(value: Int): Unit =
    addAll(value)

inline operator fun ObservableIntegerArray.plusAssign(array: IntArray): Unit =
    addAll(*array)

inline operator fun ObservableIntegerArray.plusAssign(array: ObservableIntegerArray): Unit =
    addAll(array)

inline fun ObservableIntegerArray.forEach(action: (value: Int) -> Unit) {
    for (index in 0 until size) {
        action(get(index))
    }
}

inline fun ObservableIntegerArray.forEachIndexed(action: (index: Int, value: Int) -> Unit) {
    for (index in 0 until size) {
        action(index, get(index))
    }
}

inline fun ObservableIntegerArray.forEachBinding(action: (value: IntegerBinding) -> Unit) {
    for (index in 0 until size) {
        action(getBinding(index))
    }
}

inline fun ObservableIntegerArray.forEachBindingIndexed(action: (index: Int, value: IntegerBinding) -> Unit) {
    for (index in 0 until size) {
        action(index, getBinding(index))
    }
}
