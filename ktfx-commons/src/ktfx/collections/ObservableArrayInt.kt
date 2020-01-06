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

/**
 * Returns an empty [ObservableIntegerArray].
 *
 * @see intArrayOf
 */
fun observableIntArrayOf(): ObservableIntegerArray = FXCollections.observableIntegerArray()

/**
 * Returns an [ObservableIntegerArray] of [elements].
 *
 * @see intArrayOf
 */
fun observableIntArrayOf(vararg elements: Int): ObservableIntegerArray =
    if (elements.isNotEmpty()) elements.toObservableArray() else observableIntArrayOf()

/** Converts this integer array to [ObservableIntegerArray]. */
fun IntArray.toObservableArray(): ObservableIntegerArray = FXCollections.observableIntegerArray(*this)

/** Converts this typed array of integer to [ObservableIntegerArray]. */
inline fun Array<Int>.toObservableArray(): ObservableIntegerArray = toIntArray().toObservableArray()

/** Creates a copy of this [ObservableIntegerArray]. */
fun ObservableIntegerArray.toObservableArray(): ObservableIntegerArray = FXCollections.observableIntegerArray(this)

/** Creates a new [IntegerBinding] that contains the element of an [ObservableIntegerArray] at the specified position. */
fun ObservableIntegerArray.getBinding(index: Int): IntegerBinding = Bindings.integerValueAt(this, index)

/** Creates a new [IntegerBinding] that contains the element of an [ObservableIntegerArray] at the specified position. */
fun ObservableIntegerArray.getBinding(index: ObservableNumberValue): IntegerBinding =
    Bindings.integerValueAt(this, index)

/** Creates a new [IntegerBinding] that contains the element of an [ObservableIntegerArray] at the specified position. */
inline fun ObservableIntegerArray.getBinding(index: ObservableIntegerValue): IntegerBinding =
    getBinding(index as ObservableNumberValue)

/** Returns true if [element] exists in this observable array. */
operator fun ObservableIntegerArray.contains(element: Int): Boolean = (0 until size).any { get(it) == element }

/** Adds the specified [element] to this observable array. */
inline operator fun ObservableIntegerArray.plusAssign(element: Int): Unit = addAll(element)

/** Adds all elements of the given [elements] array to this observable array. */
inline operator fun ObservableIntegerArray.plusAssign(elements: IntArray): Unit = addAll(*elements)

/** Adds all elements of the given [elements] observable array to this observable array. */
inline operator fun ObservableIntegerArray.plusAssign(elements: ObservableIntegerArray): Unit = addAll(elements)

/** Performs the given [action] on each element. */
inline fun ObservableIntegerArray.forEach(action: (Int) -> Unit) {
    for (index in 0 until size) {
        action(get(index))
    }
}

/** Performs the given [action] on each element, accompanied with the index of the element. */
inline fun ObservableIntegerArray.forEachIndexed(action: (index: Int, Int) -> Unit) {
    for (index in 0 until size) {
        action(index, get(index))
    }
}

/** Performs the given [action] on each element binding. */
inline fun ObservableIntegerArray.forEachBinding(action: (IntegerBinding) -> Unit) {
    for (index in 0 until size) {
        action(getBinding(index))
    }
}

/** Performs the given [action] on each element binding, accompanied with the index of the element. */
inline fun ObservableIntegerArray.forEachBindingIndexed(action: (index: Int, IntegerBinding) -> Unit) {
    for (index in 0 until size) {
        action(index, getBinding(index))
    }
}
