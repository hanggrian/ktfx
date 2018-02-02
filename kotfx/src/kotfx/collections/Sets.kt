@file:Suppress("NOTHING_TO_INLINE")

package kotfx.collections

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