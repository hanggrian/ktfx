@file:JvmMultifileClass
@file:JvmName("ObservableArrayKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableIntegerArray

/**
 * Returns an empty [ObservableIntegerArray].
 *
 * @see intArrayOf
 */
inline fun observableIntArrayOf(): ObservableIntegerArray = FXCollections.observableIntegerArray()

/**
 * Returns an [ObservableIntegerArray] of [elements].
 *
 * @see intArrayOf
 */
fun observableIntArrayOf(vararg elements: Int): ObservableIntegerArray =
    if (elements.isNotEmpty()) elements.toObservableArray() else observableIntArrayOf()

/** Converts this integer array to [ObservableIntegerArray]. */
inline fun IntArray.toObservableArray(): ObservableIntegerArray = FXCollections.observableIntegerArray(*this)

/** Converts this typed array of integer to [ObservableIntegerArray]. */
fun Array<Int>.toObservableArray(): ObservableIntegerArray = toIntArray().toObservableArray()

/** Creates a copy of this [ObservableIntegerArray]. */
inline fun ObservableIntegerArray.toObservableArray(): ObservableIntegerArray =
    FXCollections.observableIntegerArray(this)

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
