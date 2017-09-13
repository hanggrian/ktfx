@file:JvmMultifileClass
@file:JvmName("FXCollectionsKt")
@file:Suppress("NOTHING_TO_INLINE")

package com.hendraanggrian.kotfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableList

/** Returns an empty read-only observable list. */
inline fun <T> emptyObservableList(): ObservableList<T> = FXCollections.emptyObservableList()

/** Returns an empty read-only observable list. */
inline fun <T> observableListOf(): ObservableList<T> = emptyObservableList()

/** Returns a read-only observable list of one element. */
inline fun <T> observableListOf(element: T): ObservableList<T> = FXCollections.singletonObservableList(element)

/** Returns a read-only observable list of [elements]. */
inline fun <T> observableListOf(vararg elements: T): ObservableList<T> = when (elements.size) {
    0 -> observableListOf()
    1 -> observableListOf(elements[0])
    else -> FXCollections.unmodifiableObservableList(mutableObservableListOf(*elements))
}

/** Converts this collection to read-only observable list. */
inline fun <T> Collection<T>.toObservableList(): ObservableList<T> = FXCollections.unmodifiableObservableList(toMutableObservableList())

/** Returns an empty observable list. */
inline fun <T> mutableObservableListOf(): ObservableList<T> = FXCollections.observableArrayList()

/** Returns an empty observable list of [elements]. */
inline fun <T> mutableObservableListOf(vararg elements: T): ObservableList<T> = FXCollections.observableArrayList(*elements)

/** Converts this collection to observable list. */
inline fun <T> Collection<T>.toMutableObservableList(): ObservableList<T> = FXCollections.observableArrayList(this)