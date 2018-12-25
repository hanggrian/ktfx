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

/** Wrap this list in modifiable property. */
inline fun <E> list(list: ObservableList<E>): ListProperty<E> = SimpleListProperty(list)

/** Wrap this list in unmodifiable property. */
inline fun <E> finalList(list: ObservableList<E>): ReadOnlyListProperty<E> = ReadOnlyListWrapper(list)

/** Wrap this list in modifiable property. */
inline fun <E> set(set: ObservableSet<E>): SetProperty<E> = SimpleSetProperty(set)

/** Wrap this list in unmodifiable property. */
inline fun <E> finalSet(set: ObservableSet<E>): ReadOnlySetProperty<E> = ReadOnlySetWrapper(set)

/** Wrap this map in modifiable property. */
inline fun <K, V> map(map: ObservableMap<K, V>? = null): MapProperty<K, V> = SimpleMapProperty(map)

/** Wrap this map in unmodifiable property. */
inline fun <K, V> finalMap(map: ObservableMap<K, V>? = null): ReadOnlyMapProperty<K, V> = ReadOnlyMapWrapper(map)