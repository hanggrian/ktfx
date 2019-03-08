@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.property.MapProperty
import javafx.beans.property.ReadOnlyMapProperty
import javafx.beans.property.ReadOnlyMapWrapper
import javafx.beans.property.SimpleMapProperty
import javafx.collections.ObservableMap

/** Wrap this map in modifiable property. */
inline fun <K, V> mapPropertyOf(map: ObservableMap<K, V>? = null): MapProperty<K, V> = SimpleMapProperty(map)

/** Wrap this map in unmodifiable property. */
inline fun <K, V> finalMapPropertyOf(map: ObservableMap<K, V>? = null): ReadOnlyMapProperty<K, V> =
    ReadOnlyMapWrapper(map)