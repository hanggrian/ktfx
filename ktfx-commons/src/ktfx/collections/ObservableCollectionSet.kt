@file:JvmMultifileClass
@file:JvmName("ObservableCollectionKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.IntegerBinding
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.collections.ObservableSet

/**
 * Returns an empty immutable [ObservableSet].
 *
 * @see emptySet
 */
fun <T> emptyObservableSet(): ObservableSet<T> =
    FXCollections.emptyObservableSet()

/**
 * Returns an empty immutable [ObservableSet].
 *
 * @see setOf
 */
inline fun <T> observableSetOf(): ObservableSet<T> =
    emptyObservableSet()

/**
 * Returns an immutable [ObservableList] containing all [elements].
 *
 * @see setOf
 */
fun <T> observableSetOf(vararg elements: T): ObservableSet<T> =
    if (elements.isNotEmpty()) elements.toObservableSet() else emptyObservableSet()

/**
 * Returns an empty [ObservableSet].
 *
 * @see mutableSetOf
 */
fun <T> mutableObservableSetOf(): ObservableSet<T> =
    FXCollections.observableSet()

/**
 * Returns an [ObservableList] containing all [elements].
 *
 * @see mutableSetOf
 */
fun <T> mutableObservableSetOf(vararg elements: T): ObservableSet<T> =
    elements.toCollection(FXCollections.observableSet())

/**
 * Converts this array to immutable [ObservableSet].
 *
 * @see Array.toSet
 */
fun <T> Array<out T>.toObservableSet(): ObservableSet<T> {
    return when (size) {
        0 -> emptyObservableSet()
        1 -> observableSetOf(this[0])
        else -> toCollection(FXCollections.observableSet(LinkedHashSet<T>(mapCapacity(size))))
    }
}

/**
 * Converts this iterable to immutable [ObservableSet].
 *
 * @see Iterable.toSet
 */
fun <T> Iterable<T>.toObservableSet(): ObservableSet<T> {
    if (this is Collection) {
        return when (size) {
            0 -> emptyObservableSet()
            1 -> observableSetOf(if (this is List) this[0] else iterator().next())
            else -> toCollection(FXCollections.observableSet())
        }
    }
    return toCollection(FXCollections.observableSet()).optimizeReadOnlySet()
}

/** Converts this array to [ObservableSet]. */
inline fun <T> Array<out T>.toMutableObservableSet(): ObservableSet<T> =
    mutableObservableSetOf(*this)

/**
 * Converts this iterable to [ObservableSet].
 *
 * @see Iterable.toMutableSet
 */
fun <T> Iterable<T>.toMutableObservableSet(): ObservableSet<T> {
    return when (this) {
        is Set<T> -> FXCollections.observableSet(this)
        else -> toCollection(FXCollections.observableSet())
    }
}

fun <E> ObservableSet<E>.bindContentBidirectional(other: ObservableSet<E>): Unit =
    Bindings.bindContentBidirectional(this, other)

fun <E> ObservableSet<E>.unbindContentBidirectional(other: ObservableSet<E>): Unit =
    Bindings.unbindContentBidirectional(this, other)

fun <E> Set<E>.bindContent(other: ObservableSet<E>): Unit =
    Bindings.bindContent(this, other)

fun <E> Set<E>.unbindContent(other: ObservableSet<E>): Unit =
    Bindings.unbindContent(this, other)

val <E> ObservableSet<E>.sizeBinding: IntegerBinding
    get() = Bindings.size(this)

val <E> ObservableSet<E>.isEmptyBinding: BooleanBinding
    get() = Bindings.isEmpty(this)

val <E> ObservableSet<E>.isNotEmptyBinding: BooleanBinding
    get() = Bindings.isNotEmpty(this)
