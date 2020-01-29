@file:JvmMultifileClass
@file:JvmName("ObservableArrayKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableFloatArray
import javafx.collections.ObservableIntegerArray

/**
 * Returns an empty [ObservableFloatArray].
 *
 * @see floatArrayOf
 */
fun observableFloatArrayOf(): ObservableFloatArray = FXCollections.observableFloatArray()

/**
 * Returns an [ObservableFloatArray] of [elements].
 *
 * @see floatArrayOf
 */
fun observableFloatArrayOf(vararg elements: Float): ObservableFloatArray =
    if (elements.isNotEmpty()) elements.toObservableArray() else observableFloatArrayOf()

/** Converts this array of float to [ObservableFloatArray]. */
fun FloatArray.toObservableArray(): ObservableFloatArray = FXCollections.observableFloatArray(*this)

/** Converts this typed array of float to [ObservableIntegerArray]. */
inline fun Array<Float>.toObservableArray(): ObservableFloatArray = toFloatArray().toObservableArray()

/** Creates a copy of this [ObservableFloatArray]. */
fun ObservableFloatArray.toObservableArray(): ObservableFloatArray = FXCollections.observableFloatArray(this)

/** Returns true if [element] exists in this observable array. */
operator fun ObservableFloatArray.contains(element: Float): Boolean = (0 until size).any { get(it) == element }

/** Adds the specified [element] to this observable array. */
inline operator fun ObservableFloatArray.plusAssign(element: Float): Unit = addAll(element)

/** Adds all elements of the given [elements] array to this observable array. */
inline operator fun ObservableFloatArray.plusAssign(elements: FloatArray): Unit = addAll(*elements)

/** Adds all elements of the given [elements] observable array to this observable array. */
inline operator fun ObservableFloatArray.plusAssign(elements: ObservableFloatArray): Unit = addAll(elements)

/** Performs the given [action] on each element. */
inline fun ObservableFloatArray.forEach(action: (Float) -> Unit) {
    for (index in 0 until size) {
        action(get(index))
    }
}

/** Performs the given [action] on each element, accompanied with the index of the element. */
inline fun ObservableFloatArray.forEachIndexed(action: (index: Int, Float) -> Unit) {
    for (index in 0 until size) {
        action(index, get(index))
    }
}
