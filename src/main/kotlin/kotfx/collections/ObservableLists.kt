@file:JvmMultifileClass
@file:JvmName("CollectionsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import java.util.*

/** Returns an empty read-only observable list. */
inline fun <T> emptyObservableList(): ObservableList<T> = FXCollections.emptyObservableList()

/** Returns an empty read-only observable list. */
inline fun <T> observableListOf(): ObservableList<T> = emptyObservableList()

/** Returns a read-only observable list of one element. */
inline fun <T> observableListOf(element: T): ObservableList<T> = FXCollections.singletonObservableList(element)

/** Returns a read-only observable list of [elements]. */
inline fun <T> observableListOf(vararg elements: T): ObservableList<T> = when (elements.size) {
    0 -> observableListOf()
    1 -> observableListOf(elements[0])
    else -> FXCollections.unmodifiableObservableList(mutableObservableListOf(*elements))
}

/** Converts this collection to read-only observable list. */
inline fun <T> Collection<T>.toObservableList(): ObservableList<T> = FXCollections.unmodifiableObservableList(toMutableObservableList())

/** Returns an empty observable list. */
inline fun <T> mutableObservableListOf(): ObservableList<T> = FXCollections.observableArrayList()

/** Returns an empty observable list of [elements]. */
inline fun <T> mutableObservableListOf(vararg elements: T): ObservableList<T> = FXCollections.observableArrayList(*elements)

/** Converts this collection to observable list. */
inline fun <T> Collection<T>.toMutableObservableList(): ObservableList<T> = FXCollections.observableArrayList(this)

/** Copies elements from src to list, firing change notification once. */
inline fun <T> ObservableList<T>.copy(src: List<T>) = FXCollections.copy(this, src)

/** Fills the list with obj, firing change notification once. */
inline fun <T> ObservableList<T>.fill(obj: T) = FXCollections.fill(this, obj)

/** Replace all oldVal elements in the list with newVal element, firing change notification once. */
inline fun <T> ObservableList<T>.replaceAll(oldVal: T, newVal: T): Boolean = FXCollections.replaceAll(this, oldVal, newVal)

/** Reverse the order in the list, firing change notification once. */
inline fun ObservableList<*>.reverse() = FXCollections.reverse(this)

/** Rotates the list by distance, firing change notification once. */
inline fun ObservableList<*>.rotate(distance: Int) = FXCollections.rotate(this, distance)

/** Shuffles all elements in the observable list, firing change notification once. */
@JvmOverloads
inline fun ObservableList<*>.shuffle(rnd: Random? = null) = if (rnd == null) FXCollections.shuffle(this) else FXCollections.shuffle(this, rnd)

/** Sorts the provided observable list, firing change notification once. */
inline fun <T : Comparable<T>> ObservableList<T>.sort() = FXCollections.sort(this)

/** Sorts the provided observable list using the c comparator, firing change notification once. */
inline fun <T> ObservableList<T>.sort2(c: Comparator<T>) = FXCollections.sort(this, c)