@file:JvmMultifileClass
@file:JvmName("CollectionsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.collections.FXCollections
import javafx.collections.FXCollections.observableSet
import javafx.collections.FXCollections.unmodifiableObservableSet
import javafx.collections.ObservableSet

/** Returns an empty read-only observable set. */
inline fun <T> emptyObservableSet(): ObservableSet<T> = FXCollections.emptyObservableSet()

/** Returns an empty read-only observable set. */
inline fun <T> observableSetOf(): ObservableSet<T> = emptyObservableSet()

/** Returns an read-only observable set of [elements]. */
inline fun <T> observableSetOf(vararg elements: T): ObservableSet<T> = if (elements.isNotEmpty()) unmodifiableObservableSet(mutableObservableSetOf(*elements)) else emptyObservableSet()

/** Converts this set to read-only observable set. */
inline fun <T> Iterable<T>.toObservableSet(): ObservableSet<T> = unmodifiableObservableSet(toMutableObservableSet())

/** Returns an empty observable set. */
inline fun <T> mutableObservableSetOf(): ObservableSet<T> = observableSet()

/** Returns an empty observable set of [elements]. */
inline fun <T> mutableObservableSetOf(vararg elements: T): ObservableSet<T> = observableSet(*elements)

/** Converts this set to observable set. */
inline fun <T> Iterable<T>.toMutableObservableSet(): ObservableSet<T> = observableSet(this as? Set ?: toCollection(LinkedHashSet()))