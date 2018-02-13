@file:Suppress("NOTHING_TO_INLINE")

package kotfx.collections

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.FXCollections.observableFloatArray
import javafx.collections.FXCollections.observableIntegerArray
import javafx.collections.FXCollections.observableSet
import javafx.collections.FXCollections.unmodifiableObservableList
import javafx.collections.FXCollections.unmodifiableObservableSet
import javafx.collections.ObservableFloatArray
import javafx.collections.ObservableIntegerArray
import javafx.collections.ObservableList
import javafx.collections.ObservableSet

/** Returns an empty [ObservableIntArray]. */
inline fun observableIntArrayOf(): ObservableIntegerArray = observableIntegerArray()

/** Returns an [ObservableIntArray] of [elements]. */
inline fun observableIntArrayOf(vararg elements: Int): ObservableIntegerArray = observableIntegerArray(*elements)

/** Converts this [IntArray] to [ObservableIntArray]. */
inline fun IntArray.toObservableArray(): ObservableIntegerArray = observableIntegerArray(*this)

/** Creates a copy of this [ObservableIntArray]. */
inline fun ObservableIntegerArray.toObservableArray(): ObservableIntegerArray = observableIntegerArray(this)

/** Returns an empty [ObservableFloatArray]. */
inline fun observableFloatArrayOf(): ObservableFloatArray = observableFloatArray()

/** Returns an [ObservableFloatArray] of [elements]. */
inline fun observableFloatArrayOf(vararg elements: Float): ObservableFloatArray = observableFloatArray(*elements)

/** Converts this [FloatArray] to [ObservableFloatArray]. */
inline fun FloatArray.toObservableArray(): ObservableFloatArray = observableFloatArray(*this)

/** Creates a copy of this [ObservableFloatArray]. */
inline fun ObservableFloatArray.toObservableArray(): ObservableFloatArray = observableFloatArray(this)

/** Converts this array to immutable [ObservableList]. */
fun <T> Array<out T>.toObservableList(): ObservableList<T> = when (size) {
    0 -> emptyObservableList()
    1 -> observableListOf(this[0])
    else -> unmodifiableObservableList(toMutableObservableList())
}

/** Converts this array to [ObservableList]. */
inline fun <T> Array<out T>.toMutableObservableList(): ObservableList<T> = observableArrayList(*this)

/** Converts this array to immutable [ObservableSet]. */
fun <T> Array<out T>.toObservableSet(): ObservableSet<T> = when (size) {
    0 -> emptyObservableSet()
    else -> unmodifiableObservableSet(toMutableObservableSet())
}

/** Converts this array to [ObservableSet]. */
inline fun <T> Array<out T>.toMutableObservableSet(): ObservableSet<T> = observableSet(*this)