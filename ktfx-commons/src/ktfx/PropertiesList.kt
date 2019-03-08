@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.property.ListProperty
import javafx.beans.property.ReadOnlyListProperty
import javafx.beans.property.ReadOnlyListWrapper
import javafx.beans.property.SimpleListProperty
import javafx.collections.ObservableList
import ktfx.collections.emptyObservableList
import ktfx.collections.observableListOf

/** Wrap this list in modifiable property. */
inline fun <E> listPropertyOf(list: ObservableList<E>? = null): ListProperty<E> = SimpleListProperty(list)

/** Create an empty list modifiable property. */
inline fun <E> emptyListProperty(): ListProperty<E> = listPropertyOf(emptyObservableList())

/** Create an empty list modifiable property. */
inline fun <E> listPropertyOf(): ListProperty<E> = emptyListProperty()

/** Create a singleton list modifiable property. */
inline fun <E> listPropertyOf(element: E): ListProperty<E> = listPropertyOf(observableListOf(element))

/** Create a list modifiable property. */
inline fun <E> listPropertyOf(vararg elements: E): ListProperty<E> = listPropertyOf(observableListOf(*elements))

/** Wrap this list in unmodifiable property. */
inline fun <E> finalListPropertyOf(list: ObservableList<E>? = null): ReadOnlyListProperty<E> = ReadOnlyListWrapper(list)

/** Create an empty list unmodifiable property. */
inline fun <E> finalEmptyListProperty(): ReadOnlyListProperty<E> = finalListPropertyOf(emptyObservableList())

/** Create an empty list unmodifiable property. */
inline fun <E> finalListPropertyOf(): ReadOnlyListProperty<E> = finalEmptyListProperty()

/** Create a singleton list unmodifiable property. */
inline fun <E> finalListPropertyOf(element: E): ReadOnlyListProperty<E> = finalListPropertyOf(observableListOf(element))

/** Create a list unmodifiable property. */
inline fun <E> finalListPropertyOf(vararg elements: E): ReadOnlyListProperty<E> =
    finalListPropertyOf(observableListOf(*elements))