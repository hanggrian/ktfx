@file:JvmMultifileClass
@file:JvmName("CollectionsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.collections.FXCollections
import javafx.collections.FXCollections.*
import javafx.collections.ObservableList
import java.util.*
import kotlin.collections.ArrayList

/** Returns an empty immutable [ObservableList]. */
inline fun <T> emptyObservableList(): ObservableList<T> = FXCollections.emptyObservableList()

/** Returns an empty immutable [ObservableList]. */
inline fun <T> observableListOf(): ObservableList<T> = emptyObservableList()

/** Returns an immutable [ObservableList] of one [element]. */
inline fun <T> observableListOf(element: T): ObservableList<T> = singletonObservableList(element)

/** Returns an immutable [ObservableList] containing all [elements]. */
inline fun <T> observableListOf(vararg elements: T): ObservableList<T> = when (elements.size) {
    0 -> emptyObservableList()
    1 -> observableListOf(elements[0])
    else -> unmodifiableObservableList(elements.toMutableObservableList())
}

/** Converts this array to immutable [ObservableList]. */
inline fun <T> Array<out T>.toObservableList(): ObservableList<T> = observableListOf(*this)

/** Converts this collection to immutable [ObservableList]. */
inline fun <T> Iterable<T>.toObservableList(): ObservableList<T> = unmodifiableObservableList(toMutableObservableList())

/** Returns an empty [ObservableList]. */
inline fun <T> mutableObservableListOf(): ObservableList<T> = observableArrayList()

/** Returns an [ObservableList] containing all [elements]. */
inline fun <T> mutableObservableListOf(vararg elements: T): ObservableList<T> = observableArrayList(*elements)

/** Converts this array to [ObservableList]. */
inline fun <T> Array<out T>.toMutableObservableList(): ObservableList<T> = mutableObservableListOf(*this)

/** Converts this collection to [ObservableList]. */
inline fun <T> Iterable<T>.toMutableObservableList(): ObservableList<T> = observableArrayList(this as? Collection
        ?: toCollection(ArrayList()))

/** Copies elements from src to list, firing change notification once. */
inline fun <T> ObservableList<T>.copy(src: List<T>) = copy(this, src)

/** Fills the list with obj, firing change notification once. */
inline fun <T> ObservableList<T>.fill(obj: T) = fill(this, obj)

/** Replace all oldVal elements in the list with newVal element, firing change notification once. */
inline fun <T> ObservableList<T>.replaceAll(oldVal: T, newVal: T): Boolean = replaceAll(this, oldVal, newVal)

/** Reverse the order in the list, firing change notification once. */
inline fun ObservableList<*>.reverse() = reverse(this)

/** Rotates the list by distance, firing change notification once. */
inline fun ObservableList<*>.rotate(distance: Int) = rotate(this, distance)

/** Shuffles all elements in the observable list, firing change notification once. */
@JvmOverloads
inline fun ObservableList<*>.shuffle(rnd: Random? = null) = if (rnd == null) shuffle(this) else shuffle(this, rnd)

/** Sorts the provided observable list, firing change notification once. */
inline fun <T : Comparable<T>> ObservableList<T>.sort() = sort(this)

/** Sorts the provided observable list using the c comparator, firing change notification once. */
inline infix fun <T> ObservableList<T>.sort(c: Comparator<T>) = sort(this, c)