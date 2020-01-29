@file:JvmMultifileClass
@file:JvmName("ObservableCollectionKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import java.util.Comparator
import java.util.Random
import javafx.collections.FXCollections
import javafx.collections.ObservableList

/**
 * Returns an empty immutable [ObservableList].
 *
 * @see emptyList
 */
fun <T> emptyObservableList(): ObservableList<T> = FXCollections.emptyObservableList()

/**
 * Alias of [emptyObservableList].
 *
 * @see listOf
 */
inline fun <T> observableListOf(): ObservableList<T> = emptyObservableList()

/**
 * Returns an immutable [ObservableList] of one [element].
 *
 * @see listOf
 */
fun <T> observableListOf(element: T): ObservableList<T> = FXCollections.singletonObservableList(element)

/**
 * Returns an immutable [ObservableList] containing all [elements].
 *
 * @see listOf
 */
fun <T> observableListOf(vararg elements: T): ObservableList<T> =
    if (elements.isNotEmpty()) FXCollections.unmodifiableObservableList(elements.toMutableObservableList()) else emptyObservableList()

/**
 * Returns an empty [ObservableList].
 *
 * @see mutableListOf
 */
fun <T> mutableObservableListOf(): ObservableList<T> = FXCollections.observableArrayList()

/**
 * Returns an [ObservableList] containing all [elements].
 *
 * @see mutableListOf
 */
fun <T> mutableObservableListOf(vararg elements: T): ObservableList<T> =
    if (elements.isEmpty()) mutableObservableListOf() else FXCollections.observableArrayList(*elements)

/**
 * Converts this array to immutable [ObservableList].
 *
 * @see Array.toList
 */
fun <T> Array<out T>.toObservableList(): ObservableList<T> {
    return when (size) {
        0 -> emptyObservableList()
        1 -> observableListOf(this[0])
        else -> FXCollections.unmodifiableObservableList(this.toMutableObservableList())
    }
}

/**
 * Converts this array to [ObservableList].
 *
 * @see Array.toMutableList
 */
fun <T> Array<out T>.toMutableObservableList(): ObservableList<T> = FXCollections.observableArrayList(*this)

/**
 * Converts this iterable to immutable [ObservableList].
 *
 * @see Iterable.toList
 */
fun <T> Iterable<T>.toObservableList(): ObservableList<T> {
    if (this is Collection) {
        return when (size) {
            0 -> emptyObservableList()
            1 -> observableListOf(if (this is List) get(0) else iterator().next())
            else -> FXCollections.unmodifiableObservableList(this.toMutableObservableList())
        }
    }
    return this.toMutableObservableList().optimizeReadOnlyList()
}

/**
 * Converts this iterable to [ObservableList].
 *
 * @see Iterable.toMutableList
 */
fun <T> Iterable<T>.toMutableObservableList(): ObservableList<T> {
    if (this is Collection)
        return this.toMutableObservableList()
    return toCollection(FXCollections.observableArrayList())
}

/**
 * Converts this collection to [ObservableList].
 *
 * @see Collection.toMutableList
 */
fun <T> Collection<T>.toMutableObservableList(): ObservableList<T> = FXCollections.observableArrayList(this)

/**
 * Converts this sequence to immutable [ObservableList].
 *
 * @see Sequence.toList
 */
fun <T> Sequence<T>.toObservableList(): ObservableList<T> = toMutableObservableList().optimizeReadOnlyList()

/**
 * Converts this sequence to [ObservableList].
 *
 * @see Sequence.toMutableList
 */
fun <T> Sequence<T>.toMutableObservableList(): ObservableList<T> = toCollection(FXCollections.observableArrayList())

/** Copies elements from src to list, firing change notification once. */
inline fun <T> ObservableList<T>.copy(src: List<T>): Unit = FXCollections.copy(this, src)

/** Fills the list with obj, firing change notification once. */
inline fun <T> ObservableList<T>.fill(obj: T): Unit = FXCollections.fill(this, obj)

/** Replace all oldVal elements in the list with newVal element, firing change notification once. */
inline fun <T> ObservableList<T>.replaceAll(oldVal: T, newVal: T): Boolean =
    FXCollections.replaceAll(this, oldVal, newVal)

/** Reverse the order in the list, firing change notification once. */
inline fun ObservableList<*>.reverse(): Unit = FXCollections.reverse(this)

/** Rotates the list by distance, firing change notification once. */
inline fun ObservableList<*>.rotate(distance: Int): Unit = FXCollections.rotate(this, distance)

/** Shuffles all elements in the observable list, firing change notification once. */
inline fun ObservableList<*>.shuffle(rnd: Random? = null): Unit = FXCollections.shuffle(this, rnd)

/** Sorts the provided observable list, firing change notification once. */
inline fun <T : Comparable<T>> ObservableList<T>.sort(): Unit = FXCollections.sort(this)

/** Sorts the provided observable list using the c comparator, firing change notification once. */
infix fun <T> ObservableList<T>.sort(c: Comparator<T>): Unit = FXCollections.sort(this, c)
