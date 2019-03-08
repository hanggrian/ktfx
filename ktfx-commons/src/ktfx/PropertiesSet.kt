@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.property.ReadOnlySetProperty
import javafx.beans.property.ReadOnlySetWrapper
import javafx.beans.property.SetProperty
import javafx.beans.property.SimpleSetProperty
import javafx.collections.ObservableSet
import ktfx.collections.emptyObservableSet
import ktfx.collections.observableSetOf

/** Wrap this list in modifiable property. */
inline fun <E> setPropertyOf(set: ObservableSet<E>? = null): SetProperty<E> = SimpleSetProperty(set)

/** Create an empty set modifiable property. */
inline fun <E> emptySetProperty(): SetProperty<E> = setPropertyOf(emptyObservableSet())

/** Create an empty set modifiable property. */
inline fun <E> setPropertyOf(): SetProperty<E> = emptySetProperty()

/** Create a singleton set modifiable property. */
inline fun <E> setPropertyOf(element: E): SetProperty<E> = setPropertyOf(observableSetOf(element))

/** Create a set modifiable property. */
inline fun <E> setPropertyOf(vararg elements: E): SetProperty<E> = setPropertyOf(observableSetOf(*elements))

/** Wrap this list in unmodifiable property. */
inline fun <E> finalSetPropertyOf(set: ObservableSet<E>? = null): ReadOnlySetProperty<E> = ReadOnlySetWrapper(set)

/** Create an empty set unmodifiable property. */
inline fun <E> finalEmptySetProperty(): ReadOnlySetProperty<E> = finalSetPropertyOf(emptyObservableSet())

/** Create an empty set unmodifiable property. */
inline fun <E> finalSetPropertyOf(): ReadOnlySetProperty<E> = finalEmptySetProperty()

/** Create a singleton set unmodifiable property. */
inline fun <E> finalSetPropertyOf(element: E): ReadOnlySetProperty<E> = finalSetPropertyOf(observableSetOf(element))

/** Create a set unmodifiable property. */
inline fun <E> finalSetPropertyOf(vararg elements: E): ReadOnlySetProperty<E> =
    finalSetPropertyOf(observableSetOf(*elements))