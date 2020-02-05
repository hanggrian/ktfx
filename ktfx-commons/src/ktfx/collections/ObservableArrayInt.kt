@file:JvmMultifileClass
@file:JvmName("ObservableArrayKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableIntegerArray

/**
 * Creates a new empty observable [Int] array.
 *
 * @see emptyArray
 */
inline fun emptyObservableIntArray(): ObservableIntegerArray = FXCollections.observableIntegerArray()

/**
 * Creates a new empty observable [Int] array.
 *
 * @see intArrayOf
 */
inline fun observableIntArrayOf(): ObservableIntegerArray = FXCollections.observableIntegerArray()

/**
 * Returns an observable array containing the specified [Int] numbers.
 *
 * @see intArrayOf
 */
fun observableIntArrayOf(vararg elements: Int): ObservableIntegerArray = when {
    elements.isNotEmpty() -> FXCollections.observableIntegerArray(*elements)
    else -> FXCollections.observableIntegerArray()
}

/**
 * Returns an observable array containing all of the [Int] numbers of this primitive array.
 *
 * @see toTypedArray
 */
inline fun IntArray.toObservableArray(): ObservableIntegerArray = FXCollections.observableIntegerArray(*this)

/**
 * Returns an observable array containing all of the [Int] numbers of this generic array.
 *
 * @see toIntArray
 */
fun Array<Int>.toObservableArray(): ObservableIntegerArray = FXCollections.observableIntegerArray(*toIntArray())

/**
 * Returns new observable array which is a copy of the original array.
 *
 * @see IntArray.copyOf
 */
inline fun ObservableIntegerArray.copyOf(): ObservableIntegerArray = FXCollections.observableIntegerArray(this)

/**
 * Returns `true` if [element] is found in the array.
 *
 * @see IntArray.contains
 */
operator fun ObservableIntegerArray.contains(element: Int): Boolean = indexOf(element) >= 0

/**
 * Returns first index of [element], or -1 if the array does not contain element.
 *
 * @see IntArray.indexOf
 */
fun ObservableIntegerArray.indexOf(element: Int): Int {
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
 * @see IntArray.lastIndexOf
 */
fun ObservableIntegerArray.lastIndexOf(element: Int): Int {
    for (index in indices.reversed()) {
        if (element == this[index]) {
            return index
        }
    }
    return -1
}

/** Adds the specified [element] to this observable array. */
inline operator fun ObservableIntegerArray.plusAssign(element: Int): Unit = addAll(element)

/** Adds all elements of the given [elements] array to this observable array. */
inline operator fun ObservableIntegerArray.plusAssign(elements: IntArray): Unit = addAll(*elements)

/** Adds all elements of the given [elements] observable array to this observable array. */
inline operator fun ObservableIntegerArray.plusAssign(elements: ObservableIntegerArray): Unit = addAll(elements)

/**
 * Performs the given [action] on each element.
 *
 * @see IntArray.forEach
 */
inline fun ObservableIntegerArray.forEach(action: (Int) -> Unit) {
    for (index in 0 until size()) {
        action(this[index])
    }
}

/**
 * Performs the given [action] on each element, providing sequential index with the element.
 *
 * @see IntArray.forEachIndexed
 */
inline fun ObservableIntegerArray.forEachIndexed(action: (index: Int, Int) -> Unit) {
    for (index in 0 until size()) {
        action(index, this[index])
    }
}

/**
 * Creates an iterator over the elements of the array.
 *
 * @see IntArray.iterator
 */
operator fun ObservableIntegerArray.iterator(): IntIterator = object : IntIterator() {
    var index = 0
    override fun hasNext() = index < size()
    override fun nextInt() = get(index++)
}
