@file:Suppress("NOTHING_TO_INLINE")

package kotlinfx.collections

import javafx.beans.binding.Bindings.integerValueAt
import javafx.beans.binding.IntegerBinding
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableNumberValue
import javafx.collections.FXCollections.observableIntegerArray
import javafx.collections.ObservableIntegerArray

/** Returns an empty [ObservableIntegerArray]. */
inline fun observableIntArrayOf(): ObservableIntegerArray = observableIntegerArray()

/** Returns an [ObservableIntegerArray] of [elements]. */
inline fun observableIntArrayOf(vararg elements: Int): ObservableIntegerArray = observableIntegerArray(*elements)

/** Converts this [IntArray] to [ObservableIntegerArray]. */
inline fun IntArray.toObservableArray(): ObservableIntegerArray = observableIntegerArray(*this)

/** Creates a copy of this [ObservableIntegerArray]. */
inline fun ObservableIntegerArray.toObservableArray(): ObservableIntegerArray = observableIntegerArray(this)

inline fun ObservableIntegerArray.getBinding(index: Int): IntegerBinding = integerValueAt(this, index)
inline fun ObservableIntegerArray.getBinding(index: ObservableIntegerValue): IntegerBinding = integerValueAt(this, index)
inline fun ObservableIntegerArray.getBinding(index: ObservableNumberValue): IntegerBinding = integerValueAt(this, index)

inline operator fun ObservableIntegerArray.contains(value: Int): Boolean = (0 until size).any { get(it) == value }

inline operator fun ObservableIntegerArray.plusAssign(value: Int) = addAll(value)
inline operator fun ObservableIntegerArray.plusAssign(array: IntArray) = addAll(*array)
inline operator fun ObservableIntegerArray.plusAssign(array: ObservableIntegerArray) = addAll(array)

inline fun ObservableIntegerArray.forEach(action: (value: Int) -> Unit) {
    for (index in 0 until size) action(get(index))
}

inline fun ObservableIntegerArray.forEachIndexed(action: (index: Int, value: Int) -> Unit) {
    for (index in 0 until size) action(index, get(index))
}

inline fun ObservableIntegerArray.forEachBinding(action: (value: IntegerBinding) -> Unit) {
    for (index in 0 until size) action(getBinding(index))
}

inline fun ObservableIntegerArray.forEachBindingIndexed(action: (index: Int, value: IntegerBinding) -> Unit) {
    for (index in 0 until size) action(index, getBinding(index))
}