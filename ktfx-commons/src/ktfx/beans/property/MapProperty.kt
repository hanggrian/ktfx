@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.property

import javafx.beans.property.MapProperty
import javafx.beans.property.ReadOnlyMapProperty
import javafx.beans.property.ReadOnlyMapWrapper
import javafx.beans.property.SimpleMapProperty
import javafx.collections.ObservableMap

/** Wrap this map in unmodifiable property. */
inline fun <K, V> ObservableMap<K, V>?.toProperty(): ReadOnlyMapProperty<K, V> = ReadOnlyMapWrapper(this)

/** Wrap this map in modifiable property. */
inline fun <K, V> ObservableMap<K, V>?.toMutableProperty(): MapProperty<K, V> = SimpleMapProperty(this)