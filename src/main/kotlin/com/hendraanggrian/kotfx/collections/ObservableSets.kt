@file:JvmMultifileClass
@file:JvmName("FxCollectionsKt")
@file:Suppress("NOTHING_TO_INLINE")

package com.hendraanggrian.kotfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableSet

/** Returns an empty read-only observable set. */
inline fun <T> emptyObservableSet(): ObservableSet<T> = FXCollections.emptyObservableSet()

inline fun <T> observableSetOf(): ObservableSet<T> = emptyObservableSet()

// inline fun <T> observableSetOf(vararg elements: T): ObservableSet<T> = FXCollections.unmodifiableObservableSet()

inline fun <T> Set<T>.toObservableSet(): ObservableSet<T> = FXCollections.unmodifiableObservableSet(toMutableObservableSet())

inline fun <T> mutableObservableSetOf(): ObservableSet<T> = FXCollections.observableSet()

inline fun <T> mutableObservableSetOf(vararg elements: T): ObservableSet<T> = FXCollections.observableSet(*elements)

inline fun <T> Set<T>.toMutableObservableSet(): ObservableSet<T> = FXCollections.observableSet(this)