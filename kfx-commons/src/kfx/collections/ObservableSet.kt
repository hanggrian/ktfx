@file:Suppress("NOTHING_TO_INLINE")

package kfx.collections

import javafx.beans.binding.Bindings.bindContent
import javafx.beans.binding.Bindings.bindContentBidirectional
import javafx.beans.binding.Bindings.isEmpty
import javafx.beans.binding.Bindings.isNotEmpty
import javafx.beans.binding.Bindings.size
import javafx.beans.binding.Bindings.unbindContent
import javafx.beans.binding.Bindings.unbindContentBidirectional
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.IntegerBinding
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.collections.ObservableSet

/** Returns an empty immutable [ObservableSet]. */
inline fun <T> emptyObservableSet(): ObservableSet<T> = FXCollections.emptyObservableSet()

/** Returns an empty immutable [ObservableSet]. */
inline fun <T> observableSetOf(): ObservableSet<T> = emptyObservableSet()

/** Returns an immutable [ObservableList] containing all [elements]. */
inline fun <T> observableSetOf(vararg elements: T): ObservableSet<T> = elements.toObservableSet()

/** Returns an [ObservableList] containing all [elements]. */
inline fun <T> mutableObservableSetOf(vararg elements: T): ObservableSet<T> = elements.toMutableObservableSet()

inline fun <E> ObservableSet<E>.bindContentBidirectional(other: ObservableSet<E>) =
    bindContentBidirectional(this, other)

inline fun <E> ObservableSet<E>.unbindContentBidirectional(other: ObservableSet<E>) =
    unbindContentBidirectional(this, other)

inline fun <E> Set<E>.bindContent(other: ObservableSet<E>) = bindContent(this, other)

inline fun <E> Set<E>.unbindContent(other: ObservableSet<E>) = unbindContent(this, other)

inline fun <E> ObservableSet<E>.sizeBinding(): IntegerBinding = size(this)

inline fun <E> ObservableSet<E>.emptyBinding(): BooleanBinding = isEmpty(this)

inline fun <E> ObservableSet<E>.notEmptyBinding(): BooleanBinding = isNotEmpty(this)