@file:JvmMultifileClass
@file:JvmName("ObservableCollectionKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableSet

/**
 * Returns an empty immutable [ObservableSet].
 *
 * @see emptySet
 */
inline fun <T> emptyObservableSet(): ObservableSet<T> = FXCollections.emptyObservableSet()

/**
 * Alias of [emptyObservableSet].
 *
 * @see setOf
 */
inline fun <T> observableSetOf(): ObservableSet<T> = emptyObservableSet()

/**
 * Returns an immutable [ObservableSet] containing all [elements].
 *
 * @see setOf
 */
fun <T> observableSetOf(vararg elements: T): ObservableSet<T> = when {
    elements.isNotEmpty() -> FXCollections.unmodifiableObservableSet(elements.toMutableObservableSet())
    else -> emptyObservableSet()
}

/**
 * Returns an empty [ObservableSet].
 *
 * @see mutableSetOf
 */
inline fun <T> mutableObservableSetOf(): ObservableSet<T> = FXCollections.observableSet()

/**
 * Returns an [ObservableSet] containing all [elements].
 *
 * @see mutableSetOf
 */
fun <T> mutableObservableSetOf(vararg elements: T): ObservableSet<T> = when {
    elements.isEmpty() -> mutableObservableSetOf()
    else -> FXCollections.observableSet(*elements)
}

/**
 * Converts this array to immutable [ObservableSet].
 *
 * @see Array.toSet
 */
fun <T> Array<out T>.toObservableSet(): ObservableSet<T> = when (size) {
    0 -> emptyObservableSet()
    else -> FXCollections.unmodifiableObservableSet(this.toMutableObservableSet())
}

/**
 * Converts this array to [ObservableSet].
 *
 * @see Array.toMutableSet
 */
inline fun <T> Array<out T>.toMutableObservableSet(): ObservableSet<T> = FXCollections.observableSet<T>(*this)

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
fun <T> Iterable<T>.toMutableObservableSet(): ObservableSet<T> = when (this) {
    is Set<T> -> FXCollections.observableSet(this)
    else -> toCollection(FXCollections.observableSet())
}

/**
 * Converts this sequence to immutable [ObservableSet].
 *
 * @see Sequence.toSet
 */
fun <T> Sequence<T>.toObservableSet(): ObservableSet<T> = toMutableObservableSet().optimizeReadOnlySet()

/**
 * Converts this sequence to [ObservableSet].
 *
 * @see Sequence.toMutableSet
 */
fun <T> Sequence<T>.toMutableObservableSet(): ObservableSet<T> = toCollection(FXCollections.observableSet())
