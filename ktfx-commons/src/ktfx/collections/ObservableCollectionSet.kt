@file:JvmMultifileClass
@file:JvmName("ObservableCollectionKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.IntegerBinding
import javafx.collections.FXCollections
import javafx.collections.ObservableSet

/**
 * Returns an empty immutable [ObservableSet].
 *
 * @see emptySet
 */
fun <T> emptyObservableSet(): ObservableSet<T> =
    FXCollections.emptyObservableSet()

/**
 * Alias of [emptyObservableSet].
 *
 * @see setOf
 */
inline fun <T> observableSetOf(): ObservableSet<T> =
    emptyObservableSet()

/**
 * Returns an immutable [ObservableSet] containing all [elements].
 *
 * @see setOf
 */
fun <T> observableSetOf(vararg elements: T): ObservableSet<T> =
    if (elements.isNotEmpty()) FXCollections.unmodifiableObservableSet(elements.toMutableObservableSet()) else emptyObservableSet()

/**
 * Returns an empty [ObservableSet].
 *
 * @see mutableSetOf
 */
fun <T> mutableObservableSetOf(): ObservableSet<T> =
    FXCollections.observableSet()

/**
 * Returns an [ObservableSet] containing all [elements].
 *
 * @see mutableSetOf
 */
fun <T> mutableObservableSetOf(vararg elements: T): ObservableSet<T> =
    if (elements.isEmpty()) mutableObservableSetOf() else FXCollections.observableSet(*elements)

/**
 * Converts this array to immutable [ObservableSet].
 *
 * @see Array.toSet
 */
fun <T> Array<out T>.toObservableSet(): ObservableSet<T> {
    return when (size) {
        0 -> emptyObservableSet()
        else -> FXCollections.unmodifiableObservableSet(this.toMutableObservableSet())
    }
}

/**
 * Converts this array to [ObservableSet].
 *
 * @see Array.toMutableSet
 */
fun <T> Array<out T>.toMutableObservableSet(): ObservableSet<T> =
    FXCollections.observableSet<T>(*this)

/**
 * Converts this iterable to immutable [ObservableSet].
 *
 * @see Iterable.toSet
 */
fun <T> Iterable<T>.toObservableSet(): ObservableSet<T> {
    if (this is Collection) {
        return when (size) {
            0 -> emptyObservableSet()
            else -> FXCollections.unmodifiableObservableSet(this.toMutableObservableSet())
        }
    }
    return toCollection(FXCollections.observableSet()).optimizeReadOnlySet()
}

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

/**
 * Converts this sequence to immutable [ObservableSet].
 *
 * @see Sequence.toSet
 */
fun <T> Sequence<T>.toObservableSet(): ObservableSet<T> =
    toMutableObservableSet().optimizeReadOnlySet()

/**
 * Converts this sequence to [ObservableSet].
 *
 * @see Sequence.toMutableSet
 */
fun <T> Sequence<T>.toMutableObservableSet(): ObservableSet<T> =
    toCollection(FXCollections.observableSet())

/** Generates a bidirectional binding between two instances of [ObservableSet]. */
fun <E> ObservableSet<E>.bindContentBidirectional(other: ObservableSet<E>): Unit =
    Bindings.bindContentBidirectional(this, other)

/** Remove a bidirectional binding between two instances of [ObservableSet]. */
fun <E> ObservableSet<E>.unbindContentBidirectional(other: ObservableSet<E>): Unit =
    Bindings.unbindContentBidirectional(this, other)

/** Generates a bidirectional binding between an [ObservableSet] and a [Set]. */
fun <E> Set<E>.bindContent(other: ObservableSet<E>): Unit =
    Bindings.bindContent(this, other)

/** Remove a bidirectional binding between an [ObservableSet] and a [Set]. */
fun <E> Set<E>.unbindContent(other: ObservableSet<E>): Unit =
    Bindings.unbindContent(this, other)

/** Creates a new [IntegerBinding] that contains the size [ObservableSet]. */
val <E> ObservableSet<E>.sizeBinding: IntegerBinding
    get() = Bindings.size(this)

/** Creates a new [BooleanBinding] that holds `true` if a given [ObservableSet] is empty. */
val <E> ObservableSet<E>.emptyBinding: BooleanBinding
    get() = Bindings.isEmpty(this)

/** Creates a new [BooleanBinding] that holds `true` if a given [ObservableSet] is not empty. */
val <E> ObservableSet<E>.notEmptyBinding: BooleanBinding
    get() = Bindings.isNotEmpty(this)
