@file:JvmMultifileClass
@file:JvmName("ObservableArraysKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.beans.binding.Bindings
import javafx.beans.binding.IntegerBinding
import javafx.collections.ObservableArray
import javafx.collections.ObservableList
import javafx.collections.ObservableSet

/** Length of data in this array. */
inline val ObservableArray<*>.size: Int
    get() = size()

/** Returns `true` if the array is empty. */
inline fun ObservableArray<*>.isEmpty(): Boolean =
    size == 0

/** Returns `true` if the array is not empty. */
inline fun ObservableArray<*>.isNotEmpty(): Boolean =
    size != 0

/** Creates a new [IntegerBinding] that contains the size of this array. */
val ObservableArray<*>.sizeBinding: IntegerBinding
    get() = Bindings.size(this)

/** Converts this array to immutable [ObservableList]. */
inline fun <T> Array<out T>.toObservableList(): ObservableList<T> =
    observableListOf(*this)

/** Converts this array to [ObservableList]. */
inline fun <T> Array<out T>.toMutableObservableList(): ObservableList<T> =
    mutableObservableListOf(*this)

/** Converts this array to immutable [ObservableSet]. */
inline fun <T> Array<out T>.toObservableSet(): ObservableSet<T> =
    observableSetOf(*this)

/** Converts this array to [ObservableSet]. */
inline fun <T> Array<out T>.toMutableObservableSet(): ObservableSet<T> =
    mutableObservableSetOf(*this)
