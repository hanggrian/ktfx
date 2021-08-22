@file:JvmMultifileClass
@file:JvmName("ObservableCollectionsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import java.util.Comparator
import java.util.Random
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Returns an empty read-only [ObservableList].
 * @see emptyList
 */
inline fun <T> emptyObservableList(): ObservableList<T> = FXCollections.emptyObservableList()

/**
 * Returns a new read-only [ObservableList] of given elements.
 * @see listOf
 */
fun <T> observableListOf(vararg elements: T): ObservableList<T> =
    if (elements.isNotEmpty()) FXCollections.unmodifiableObservableList(elements.toMutableObservableList())
    else emptyObservableList()

/**
 * Returns an empty read-only [ObservableList] of one element.
 * @see listOf
 */
inline fun <T> observableListOf(element: T): ObservableList<T> = FXCollections.singletonObservableList(element)

/**
 * Returns an empty read-only [ObservableList].
 * @see listOf
 */
inline fun <T> observableListOf(): ObservableList<T> = emptyObservableList()

/**
 * Returns an empty [ObservableList].
 * @see mutableListOf
 */
inline fun <T> mutableObservableListOf(): ObservableList<T> = FXCollections.observableArrayList()

/**
 * Returns a new [ObservableList] with the given elements.
 * @see mutableListOf
 */
fun <T> mutableObservableListOf(vararg elements: T): ObservableList<T> =
    if (elements.isEmpty()) mutableObservableListOf() else FXCollections.observableArrayList(*elements)

/**
 * Returns a new read-only [ObservableList] either of single given element, if it is not null,
 * or empty list if the element is null.
 * @see listOfNotNull
 */
fun <T : Any> observableListOfNotNull(element: T?): ObservableList<T> =
    if (element != null) observableListOf(element) else emptyObservableList()

/**
 * Returns a new read-only [ObservableList] only of those given elements, that are not null.
 * @see listOfNotNull
 */
fun <T : Any> observableListOfNotNull(vararg elements: T?): ObservableList<T> =
    elements.filterNotNullTo(mutableObservableListOf())

/**
 * Builds a new read-only [ObservableList] by populating a [MutableList]
 * using the given [builderAction] and returning a read-only list with the same elements.
 * @see buildList
 */
@ExperimentalStdlibApi
inline fun <T> buildObservableList(builderAction: MutableList<T>.() -> Unit): List<T> {
    contract { callsInPlace(builderAction, InvocationKind.EXACTLY_ONCE) }
    return buildList(builderAction).toObservableList()
}

/**
 * Returns an [ObservableList] containing all elements.
 * @see Array.toList
 */
fun <T> Array<out T>.toObservableList(): ObservableList<T> = when (size) {
    0 -> emptyObservableList()
    1 -> observableListOf(this[0])
    else -> FXCollections.unmodifiableObservableList(this.toMutableObservableList())
}

/**
 * Returns a new [ObservableList] filled with all elements of this array.
 * @see Array.toMutableList
 */
inline fun <T> Array<out T>.toMutableObservableList(): ObservableList<T> = FXCollections.observableArrayList(*this)

/**
 * Returns an [ObservableList] containing all elements.
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
 * Returns a new [ObservableList] filled with all elements of this collection.
 * @see Iterable.toMutableList
 */
fun <T> Iterable<T>.toMutableObservableList(): ObservableList<T> {
    if (this is Collection)
        return this.toMutableObservableList()
    return toCollection(FXCollections.observableArrayList())
}

/**
 * Returns a new [ObservableList] filled with all elements of this collection.
 * @see Collection.toMutableList
 */
inline fun <T> Collection<T>.toMutableObservableList(): ObservableList<T> = FXCollections.observableArrayList(this)

/**
 * Returns a [ObservableList] containing all elements.
 * @see Sequence.toList
 */
fun <T> Sequence<T>.toObservableList(): ObservableList<T> = toMutableObservableList().optimizeReadOnlyList()

/**
 * Returns a new [ObservableList] filled with all elements of this sequence.
 * @see Sequence.toMutableList
 */
fun <T> Sequence<T>.toMutableObservableList(): ObservableList<T> = toCollection(FXCollections.observableArrayList())

/** Copies elements from src to list, firing change notification once. */
inline fun <T> ObservableList<T>.copyTo(src: List<T>): Unit = FXCollections.copy(this, src)

/** Fills the list with obj, firing change notification once. */
inline fun <T> ObservableList<T>.fillTo(obj: T): Unit = FXCollections.fill(this, obj)

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
inline infix fun <T> ObservableList<T>.sort(c: Comparator<T>): Unit = FXCollections.sort(this, c)
