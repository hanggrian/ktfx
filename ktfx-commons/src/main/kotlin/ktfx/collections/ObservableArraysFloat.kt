@file:JvmMultifileClass
@file:JvmName("ObservableArraysKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableFloatArray

/**
 * Creates a new empty observable [Float] array.
 *
 * @see emptyArray
 */
inline fun emptyObservableFloatArray(): ObservableFloatArray = FXCollections.observableFloatArray()

/**
 * Creates a new empty observable [Float] array.
 *
 * @see floatArrayOf
 */
inline fun observableFloatArrayOf(): ObservableFloatArray = FXCollections.observableFloatArray()

/**
 * Returns an observable array containing the specified [Float] numbers.
 *
 * @see floatArrayOf
 */
fun observableFloatArrayOf(vararg elements: Float): ObservableFloatArray =
    when {
        elements.isNotEmpty() -> FXCollections.observableFloatArray(*elements)
        else -> FXCollections.observableFloatArray()
    }

/**
 * Returns an observable array containing all of the [Float] numbers of this primitive array.
 *
 * @see FloatArray.toTypedArray
 */
inline fun FloatArray.toObservableArray(): ObservableFloatArray =
    FXCollections.observableFloatArray(*this)

/** Returns an array containing copy of the observable array. */
fun ObservableFloatArray.toFloatArray(): FloatArray = toArray(FloatArray(size()))

/**
 * Returns new observable array which is a copy of the original array.
 *
 * @see FloatArray.copyOf
 */
inline fun ObservableFloatArray.copyOf(): ObservableFloatArray =
    FXCollections.observableFloatArray(this)

/**
 * Returns `true` if [element] is found in the array.
 *
 * @see FloatArray.contains
 */
operator fun ObservableFloatArray.contains(element: Float): Boolean = indexOf(element) >= 0

/**
 * Returns first index of [element], or -1 if the array does not contain element.
 *
 * @see FloatArray.indexOf
 */
fun ObservableFloatArray.indexOf(element: Float): Int {
    for (index in indices) {
        if (element == this[index]) {
            return index
        }
    }
    return -1
}

/**
 * Returns last index of [element], or -1 if the array does not contain element.
 *
 * @see FloatArray.lastIndexOf
 */
fun ObservableFloatArray.lastIndexOf(element: Float): Int {
    for (index in indices.reversed()) {
        if (element == this[index]) {
            return index
        }
    }
    return -1
}

/**
 * Returns an element at the given [index] or the result of calling the [defaultValue] function if
 * the [index] is out of bounds of this array.
 *
 * @see FloatArray.getOrElse
 */
inline fun ObservableFloatArray.getOrElse(index: Int, defaultValue: (Int) -> Float): Float =
    if (index in 0..lastIndex) get(index) else defaultValue(index)

/**
 * Returns an element at the given [index] or `null` if the [index] is out of bounds of this array.
 *
 * @see FloatArray.getOrNull
 */
fun ObservableFloatArray.getOrNull(index: Int): Float? =
    if (index in 0..lastIndex) get(index) else null

/** Adds the specified [element] to this observable array. */
inline operator fun ObservableFloatArray.plusAssign(element: Float): Unit = addAll(element)

/** Adds all elements of the given [elements] array to this observable array. */
inline operator fun ObservableFloatArray.plusAssign(elements: FloatArray): Unit = addAll(*elements)

/** Adds all elements of the given [elements] observable array to this observable array. */
inline operator fun ObservableFloatArray.plusAssign(elements: ObservableFloatArray): Unit =
    addAll(elements)

/**
 * Performs the given [action] on each element.
 *
 * @see FloatArray.forEach
 */
inline fun ObservableFloatArray.forEach(action: (Float) -> Unit) {
    for (index in 0 until size()) {
        action(this[index])
    }
}

/**
 * Performs the given [action] on each element, providing sequential index with the element.
 *
 * @see FloatArray.forEachIndexed
 */
inline fun ObservableFloatArray.forEachIndexed(action: (index: Int, Float) -> Unit) {
    for (index in 0 until size()) {
        action(index, this[index])
    }
}

/**
 * Creates an iterator over the elements of the array.
 *
 * @see FloatArray.iterator
 */
operator fun ObservableFloatArray.iterator(): FloatIterator =
    object : FloatIterator() {
        var index = 0

        override fun hasNext(): Boolean = index < size()

        override fun nextFloat(): Float = get(index++)
    }
