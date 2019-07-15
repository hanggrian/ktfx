@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.property.MapProperty
import javafx.beans.property.ReadOnlyMapProperty
import javafx.beans.property.ReadOnlyMapWrapper
import javafx.beans.property.SimpleMapProperty
import javafx.collections.ObservableMap
import ktfx.collections.emptyObservableMap
import ktfx.collections.observableMapOf

/** Wrap this map in modifiable property. */
inline fun <K, V> mapPropertyOf(map: ObservableMap<K, V>? = null): MapProperty<K, V> = SimpleMapProperty(map)

/** Create an empty map modifiable property. */
inline fun <K, V> emptyMapProperty(): MapProperty<K, V> = mapPropertyOf(emptyObservableMap())

/** Create an empty map modifiable property. */
inline fun <K, V> mapPropertyOf(): MapProperty<K, V> = emptyMapProperty()

/** Create a map modifiable property. */
inline fun <K, V> mapPropertyOf(vararg pairs: Pair<K, V>): MapProperty<K, V> = mapPropertyOf(observableMapOf(*pairs))

/** Wrap this map in unmodifiable property. */
inline fun <K, V> finalMapPropertyOf(map: ObservableMap<K, V>? = null): ReadOnlyMapProperty<K, V> =
    ReadOnlyMapWrapper(map)

/** Create an empty map unmodifiable property. */
inline fun <K, V> finalEmptyMapProperty(): ReadOnlyMapProperty<K, V> = finalMapPropertyOf(emptyObservableMap())

/** Create an empty map unmodifiable property. */
inline fun <K, V> finalMapPropertyOf(): ReadOnlyMapProperty<K, V> = finalEmptyMapProperty()

/** Create a map unmodifiable property. */
inline fun <K, V> finalMapPropertyOf(vararg pairs: Pair<K, V>): ReadOnlyMapProperty<K, V> =
    finalMapPropertyOf(observableMapOf(*pairs))

/** Converts this map to property. */
inline fun <K, V> ObservableMap<K, V>?.toProperty(): MapProperty<K, V> = mapPropertyOf(this)

/** Converts this map to final property. */
inline fun <K, V> ObservableMap<K, V>?.toFinalProperty(): ReadOnlyMapProperty<K, V> = finalMapPropertyOf(this)
