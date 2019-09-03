@file:JvmMultifileClass
@file:JvmName("ObservableCollectionsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import java.util.LinkedHashSet
import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.IntegerBinding
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.collections.ObservableSet

/** Returns an empty immutable [ObservableSet]. */
inline fun <T> emptyObservableSet(): ObservableSet<T> =
    FXCollections.emptyObservableSet()

/** Returns an empty immutable [ObservableSet]. */
inline fun <T> observableSetOf(): ObservableSet<T> =
    emptyObservableSet()

/** Returns an immutable [ObservableList] containing all [elements]. */
fun <T> observableSetOf(vararg elements: T): ObservableSet<T> =
    when (elements.size) {
        0 -> emptyObservableSet()
        else -> FXCollections.unmodifiableObservableSet(mutableObservableSetOf(*elements))
    }

/** Returns an [ObservableList] containing all [elements]. */
inline fun <T> mutableObservableSetOf(vararg elements: T): ObservableSet<T> =
    FXCollections.observableSet(*elements)

/** Converts this collection to immutable [ObservableSet]. */
inline fun <T> Iterable<T>.toObservableSet(): ObservableSet<T> =
    FXCollections.unmodifiableObservableSet(toMutableObservableSet())

/** Converts this collection to [ObservableSet]. */
fun <T> Iterable<T>.toMutableObservableSet(): ObservableSet<T> =
    FXCollections.observableSet(this as? Set ?: toCollection(LinkedHashSet()))

inline fun <E> ObservableSet<E>.bindContentBidirectional(other: ObservableSet<E>): Unit =
    Bindings.bindContentBidirectional(this, other)

inline fun <E> ObservableSet<E>.unbindContentBidirectional(other: ObservableSet<E>): Unit =
    Bindings.unbindContentBidirectional(this, other)

inline fun <E> Set<E>.bindContent(other: ObservableSet<E>): Unit =
    Bindings.bindContent(this, other)

inline fun <E> Set<E>.unbindContent(other: ObservableSet<E>): Unit =
    Bindings.unbindContent(this, other)

inline val <E> ObservableSet<E>.sizeBinding: IntegerBinding
    get() = Bindings.size(this)

inline val <E> ObservableSet<E>.isEmptyBinding: BooleanBinding
    get() = Bindings.isEmpty(this)

inline val <E> ObservableSet<E>.isNotEmptyBinding: BooleanBinding
    get() = Bindings.isNotEmpty(this)
