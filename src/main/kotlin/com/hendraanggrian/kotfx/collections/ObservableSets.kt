@file:JvmMultifileClass
@file:JvmName("FXCollectionsKt")
@file:Suppress("NOTHING_TO_INLINE")

package com.hendraanggrian.kotfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableSet

/** Returns an empty read-only observable set. */
inline fun <T> emptyObservableSet(): ObservableSet<T> = FXCollections.emptyObservableSet()

/** Returns an empty read-only observable set. */
inline fun <T> observableSetOf(): ObservableSet<T> = emptyObservableSet()

/** Returns an read-only observable set of [elements]. */
inline fun <T> observableSetOf(vararg elements: T): ObservableSet<T> = if (elements.isNotEmpty()) FXCollections.unmodifiableObservableSet(mutableObservableSetOf(*elements)) else emptyObservableSet()

/** Converts this set to read-only observable set. */
inline fun <T> Set<T>.toObservableSet(): ObservableSet<T> = FXCollections.unmodifiableObservableSet(toMutableObservableSet())

/** Returns an empty observable set. */
inline fun <T> mutableObservableSetOf(): ObservableSet<T> = FXCollections.observableSet()

/** Returns an empty observable set of [elements]. */
inline fun <T> mutableObservableSetOf(vararg elements: T): ObservableSet<T> = FXCollections.observableSet(*elements)

/** Converts this set to observable set. */
inline fun <T> Set<T>.toMutableObservableSet(): ObservableSet<T> = FXCollections.observableSet(this)