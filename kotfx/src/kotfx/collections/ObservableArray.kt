@file:Suppress("NOTHING_TO_INLINE")

package kotfx.collections

import javafx.beans.binding.Bindings.size
import javafx.beans.binding.IntegerBinding
import javafx.collections.FXCollections
import javafx.collections.ObservableArray
import javafx.collections.ObservableList
import javafx.collections.ObservableSet

inline fun ObservableArray<*>.sizeBinding(): IntegerBinding = size(this)

inline val ObservableArray<*>.size: Int get() = size()

inline fun ObservableArray<*>.isEmpty() = size == 0

inline fun ObservableArray<*>.isNotEmpty() = size != 0

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