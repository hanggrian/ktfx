@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.property.ListProperty
import javafx.beans.property.MapProperty
import javafx.beans.property.ReadOnlyListProperty
import javafx.beans.property.ReadOnlyListWrapper
import javafx.beans.property.ReadOnlyMapProperty
import javafx.beans.property.ReadOnlyMapWrapper
import javafx.beans.property.ReadOnlySetProperty
import javafx.beans.property.ReadOnlySetWrapper
import javafx.beans.property.SetProperty
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleMapProperty
import javafx.beans.property.SimpleSetProperty
import javafx.collections.ObservableList
import javafx.collections.ObservableMap
import javafx.collections.ObservableSet
import ktfx.collections.emptyObservableList
import ktfx.collections.emptyObservableMap
import ktfx.collections.emptyObservableSet
import ktfx.collections.mutableObservableListOf
import ktfx.collections.mutableObservableMapOf
import ktfx.collections.mutableObservableSetOf
import ktfx.collections.observableListOf
import ktfx.collections.observableMapOf
import ktfx.collections.observableSetOf

/** Wrap this list in modifiable property. */
inline fun <E> listPropertyOf(list: ObservableList<E>): ListProperty<E> = SimpleListProperty(list)

inline fun <E> listPropertyOf(vararg items: E): ListProperty<E> = listPropertyOf(mutableObservableListOf(*items))

inline fun <E> listPropertyOf(item: E): ListProperty<E> = listPropertyOf(mutableObservableListOf(item))

/** Wrap this list in unmodifiable property. */
inline fun <E> readOnlyListPropertyOf(list: ObservableList<E>): ReadOnlyListProperty<E> = ReadOnlyListWrapper(list)

inline fun <E> readOnlyListPropertyOf(vararg items: E): ReadOnlyListProperty<E> =
    readOnlyListPropertyOf(observableListOf(*items))

inline fun <E> readOnlyListPropertyOf(item: E): ReadOnlyListProperty<E> =
    readOnlyListPropertyOf(observableListOf(item))

inline fun <E> readOnlyListPropertyOf(): ReadOnlyListProperty<E> =
    readOnlyListPropertyOf(emptyObservableList())

/** Wrap this list in modifiable property. */
inline fun <E> setPropertyOf(set: ObservableSet<E>): SetProperty<E> = SimpleSetProperty(set)

inline fun <E> setPropertyOf(vararg items: E): SetProperty<E> = setPropertyOf(mutableObservableSetOf(*items))

/** Wrap this list in unmodifiable property. */
inline fun <E> readOnlySetPropertyOf(set: ObservableSet<E>): ReadOnlySetProperty<E> = ReadOnlySetWrapper(set)

inline fun <E> readOnlySetPropertyOf(vararg items: E): ReadOnlySetProperty<E> =
    readOnlySetPropertyOf(observableSetOf(*items))

inline fun <E> readOnlySetPropertyOf(): ReadOnlySetProperty<E> =
    readOnlySetPropertyOf(emptyObservableSet())

/** Wrap this map in modifiable property. */
inline fun <K, V> mapPropertyOf(map: ObservableMap<K, V>? = null): MapProperty<K, V> = SimpleMapProperty(map)

inline fun <K, V> mapPropertyOf(vararg pairs: Pair<K, V>): MapProperty<K, V> =
    mapPropertyOf(mutableObservableMapOf(*pairs))

/** Wrap this map in unmodifiable property. */
inline fun <K, V> readOnlyMapPropertyOf(map: ObservableMap<K, V>? = null): ReadOnlyMapProperty<K, V> =
    ReadOnlyMapWrapper(map)

inline fun <K, V> readOnlyMapPropertyOf(vararg pairs: Pair<K, V>): ReadOnlyMapProperty<K, V> =
    readOnlyMapPropertyOf(observableMapOf(*pairs))

inline fun <K, V> readOnlyMapPropertyOf(): ReadOnlyMapProperty<K, V> =
    readOnlyMapPropertyOf(emptyObservableMap())