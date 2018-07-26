@file:Suppress("NOTHING_TO_INLINE")

package javafxx.collections

import javafx.beans.binding.Bindings.size
import javafx.beans.binding.IntegerBinding
import javafx.collections.FXCollections
import javafx.collections.ObservableArray
import javafx.collections.ObservableList
import javafx.collections.ObservableSet

/** Length of data in this array. */
inline val ObservableArray<*>.size: Int get() = size()

/** Returns `true` if the array is empty. */
inline fun ObservableArray<*>.isEmpty() = size == 0

/** Returns `true` if the array is not empty. */
inline fun ObservableArray<*>.isNotEmpty() = size != 0

/** Creates a new [IntegerBinding] that contains the size of this array. */
inline fun ObservableArray<*>.sizeBinding(): IntegerBinding = size(this)

/** Converts this array to immutable [ObservableList]. */
fun <T> Array<out T>.toObservableList(): ObservableList<T> = when (size) {
    0 -> emptyObservableList()
    1 -> observableListOf(this[0])
    else -> FXCollections.unmodifiableObservableList(toMutableObservableList())
}

/** Converts this array to [ObservableList]. */
inline fun <T> Array<out T>.toMutableObservableList(): ObservableList<T> = FXCollections.observableArrayList(*this)

/** Converts this array to immutable [ObservableSet]. */
fun <T> Array<out T>.toObservableSet(): ObservableSet<T> = when (size) {
    0 -> emptyObservableSet()
    else -> FXCollections.unmodifiableObservableSet(toMutableObservableSet())
}

/** Converts this array to [ObservableSet]. */
inline fun <T> Array<out T>.toMutableObservableSet(): ObservableSet<T> = FXCollections.observableSet(*this)