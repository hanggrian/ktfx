@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.properties

import javafx.beans.property.MapProperty
import javafx.beans.property.ReadOnlyMapWrapper
import javafx.beans.property.SimpleMapProperty
import javafx.beans.value.ObservableValue
import javafx.collections.ObservableMap

/** Wrap this map in modifiable property. */
inline fun <K, V> ObservableMap<K, V>?.asMutableProperty(): MapProperty<K, V> = SimpleMapProperty(this)

/** Wrap this map in unmodifiable property. */
inline fun <K, V> ObservableMap<K, V>?.asProperty(): MapProperty<K, V> = ReadOnlyMapWrapper(this)

/** Returns this map property as an observable. */
inline fun <K, V> MapProperty<K, V>.asObservable(): ObservableValue<ObservableMap<K, V>> = this