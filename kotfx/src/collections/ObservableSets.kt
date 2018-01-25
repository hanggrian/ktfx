@file:JvmMultifileClass
@file:JvmName("CollectionsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.collections.FXCollections
import javafx.collections.FXCollections.observableSet
import javafx.collections.FXCollections.unmodifiableObservableSet
import javafx.collections.ObservableList
import javafx.collections.ObservableSet

/** Returns an empty immutable [ObservableSet]. */
inline fun <T> emptyObservableSet(): ObservableSet<T> = FXCollections.emptyObservableSet()

/** Returns an empty immutable [ObservableSet]. */
inline fun <T> observableSetOf(): ObservableSet<T> = emptyObservableSet()

/** Returns an immutable [ObservableList] containing all [elements]. */
inline fun <T> observableSetOf(vararg elements: T): ObservableSet<T> = when (elements.size) {
    0 -> emptyObservableSet()
    else -> unmodifiableObservableSet(elements.toMutableObservableSet())
}

/** Converts this array to immutable [ObservableSet]. */
inline fun <T> Array<out T>.toObservableSet(): ObservableSet<T> = observableSetOf(*this)

/** Converts this collection to immutable [ObservableSet]. */
inline fun <T> Iterable<T>.toObservableSet(): ObservableSet<T> = unmodifiableObservableSet(toMutableObservableSet())

/** Returns an [ObservableList] containing all [elements]. */
inline fun <T> mutableObservableSetOf(vararg elements: T): ObservableSet<T> = observableSet(*elements)

/** Converts this array to [ObservableSet]. */
inline fun <T> Array<out T>.toMutableObservableSet(): ObservableSet<T> = mutableObservableSetOf(*this)

/** Converts this collection to [ObservableSet]. */
inline fun <T> Iterable<T>.toMutableObservableSet(): ObservableSet<T> = observableSet(this as? Set
        ?: toCollection(LinkedHashSet()))