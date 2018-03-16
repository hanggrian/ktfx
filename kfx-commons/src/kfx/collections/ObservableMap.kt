@file:Suppress("NOTHING_TO_INLINE")

package kfx.collections

import javafx.beans.binding.Bindings.bindContent
import javafx.beans.binding.Bindings.bindContentBidirectional
import javafx.beans.binding.Bindings.booleanValueAt
import javafx.beans.binding.Bindings.doubleValueAt
import javafx.beans.binding.Bindings.floatValueAt
import javafx.beans.binding.Bindings.integerValueAt
import javafx.beans.binding.Bindings.isEmpty
import javafx.beans.binding.Bindings.isNotEmpty
import javafx.beans.binding.Bindings.longValueAt
import javafx.beans.binding.Bindings.size
import javafx.beans.binding.Bindings.stringValueAt
import javafx.beans.binding.Bindings.unbindContent
import javafx.beans.binding.Bindings.unbindContentBidirectional
import javafx.beans.binding.Bindings.valueAt
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.LongBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding
import javafx.beans.value.ObservableValue
import javafx.collections.FXCollections
import javafx.collections.FXCollections.observableHashMap
import javafx.collections.FXCollections.observableMap
import javafx.collections.FXCollections.unmodifiableObservableMap
import javafx.collections.ObservableMap

/** Returns an empty immutable [ObservableMap]. */
inline fun <K, V> emptyObservableMap(): ObservableMap<K, V> = FXCollections.emptyObservableMap()

/** Returns an empty immutable [ObservableMap]. */
inline fun <K, V> observableMapOf(): ObservableMap<K, V> = emptyObservableMap()

/** Returns an empty observable map of containing all [pairs]. */
fun <K, V> observableMapOf(vararg pairs: Pair<K, V>): ObservableMap<K, V> = when {
    pairs.isNotEmpty() -> unmodifiableObservableMap(mutableObservableMapOf(*pairs))
    else -> emptyObservableMap()
}

/** Converts this map to immutable [ObservableMap]. */
inline fun <K, V> Map<K, V>.toObservableMap(): ObservableMap<K, V> = unmodifiableObservableMap(toMutableObservableMap())

/** Returns an empty [[ObservableMap]]. */
inline fun <K, V> mutableObservableMapOf(): ObservableMap<K, V> = observableHashMap()

/** Returns an [[ObservableMap]] of [pairs]. */
fun <K, V> mutableObservableMapOf(vararg pairs: Pair<K, V>): ObservableMap<K, V> = observableMap(HashMap<K, V>().apply {
    for ((key, value) in pairs) put(key, value)
})

/** Converts this map to [[ObservableMap]]. */
inline fun <K, V> Map<K, V>.toMutableObservableMap(): ObservableMap<K, V> = observableMap(this)

inline fun <K, V> ObservableMap<K, V>.bindContentBidirectional(other: ObservableMap<K, V>) =
    bindContentBidirectional(this, other)

inline fun <K, V> ObservableMap<K, V>.unbindContentBidirectional(other: ObservableMap<K, V>) =
    unbindContentBidirectional(this, other)

inline fun <K, V> Map<K, V>.bindContent(other: ObservableMap<K, V>) = bindContent(this, other)

inline fun <K, V> Map<K, V>.unbindContent(other: ObservableMap<K, V>) = unbindContent(this, other)

inline fun <K, V> ObservableMap<K, V>.sizeBinding(): IntegerBinding = size(this)

inline fun <K, V> ObservableMap<K, V>.emptyBinding(): BooleanBinding = isEmpty(this)

inline fun <K, V> ObservableMap<K, V>.notEmptyBinding(): BooleanBinding = isNotEmpty(this)

inline fun <K, V> ObservableMap<K, V>.getBinding(key: K): ObjectBinding<V> = valueAt(this, key)
inline fun <K, V> ObservableMap<K, V>.getBinding(key: ObservableValue<K>): ObjectBinding<V> = valueAt(this, key)

inline fun <K> ObservableMap<K, Boolean>.getBinding(key: K): BooleanBinding = booleanValueAt(this, key)
inline fun <K> ObservableMap<K, Boolean>.getBinding(key: ObservableValue<K>): BooleanBinding = booleanValueAt(this, key)

inline fun <K> ObservableMap<K, Double>.getBinding(key: K): DoubleBinding = doubleValueAt(this, key)
inline fun <K> ObservableMap<K, Double>.getBinding(key: ObservableValue<K>): DoubleBinding = doubleValueAt(this, key)

inline fun <K> ObservableMap<K, Float>.getBinding(key: K): FloatBinding = floatValueAt(this, key)
inline fun <K> ObservableMap<K, Float>.getBinding(key: ObservableValue<K>): FloatBinding = floatValueAt(this, key)

inline fun <K> ObservableMap<K, Int>.getBinding(key: K): IntegerBinding = integerValueAt(this, key)
inline fun <K> ObservableMap<K, Int>.getBinding(key: ObservableValue<K>): IntegerBinding = integerValueAt(this, key)

inline fun <K> ObservableMap<K, Long>.getBinding(key: K): LongBinding = longValueAt(this, key)
inline fun <K> ObservableMap<K, Long>.getBinding(key: ObservableValue<K>): LongBinding = longValueAt(this, key)

inline fun <K> ObservableMap<K, String>.getBinding(key: K): StringBinding = stringValueAt(this, key)
inline fun <K> ObservableMap<K, String>.getBinding(key: ObservableValue<K>): StringBinding = stringValueAt(this, key)