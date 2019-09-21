@file:JvmMultifileClass
@file:JvmName("PropertiesKt")

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
fun <E> ObservableList<E>?.asProperty(): ListProperty<E> =
    SimpleListProperty(this)

/** Wrap this list in unmodifiable property. */
fun <E> ObservableList<E>?.asFinalProperty(): ReadOnlyListProperty<E> =
    ReadOnlyListWrapper(this)

/** Wrap this list in modifiable property. */
fun <E> ObservableSet<E>?.asProperty(): SetProperty<E> =
    SimpleSetProperty(this)

/** Wrap this list in unmodifiable property. */
fun <E> ObservableSet<E>?.asFinalProperty(): ReadOnlySetProperty<E> =
    ReadOnlySetWrapper(this)

/** Wrap this map in modifiable property. */
fun <K, V> ObservableMap<K, V>?.asProperty(): MapProperty<K, V> =
    SimpleMapProperty(this)

/** Wrap this map in unmodifiable property. */
fun <K, V> ObservableMap<K, V>?.asFinalProperty(): ReadOnlyMapProperty<K, V> =
    ReadOnlyMapWrapper(this)
