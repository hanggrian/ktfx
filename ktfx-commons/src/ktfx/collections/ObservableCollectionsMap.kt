@file:JvmMultifileClass
@file:JvmName("ObservableCollectionsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.LongBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding
import javafx.beans.value.ObservableValue
import javafx.collections.FXCollections
import javafx.collections.ObservableMap

/** Returns an empty immutable [ObservableMap]. */
inline fun <K, V> emptyObservableMap(): ObservableMap<K, V> = FXCollections.emptyObservableMap()

/** Returns an empty immutable [ObservableMap]. */
inline fun <K, V> observableMapOf(): ObservableMap<K, V> = emptyObservableMap()

/** Returns an empty observable map of containing all [pairs]. */
fun <K, V> observableMapOf(vararg pairs: Pair<K, V>): ObservableMap<K, V> = when {
    pairs.isEmpty() -> emptyObservableMap()
    else -> FXCollections.unmodifiableObservableMap(mutableObservableMapOf(*pairs))
}

/** Converts this map to immutable [ObservableMap]. */
inline fun <K, V> Map<K, V>.toObservableMap(): ObservableMap<K, V> =
    FXCollections.unmodifiableObservableMap(toMutableObservableMap())

/** Returns an empty [[ObservableMap]]. */
inline fun <K, V> mutableObservableMapOf(): ObservableMap<K, V> = FXCollections.observableHashMap()

/** Returns an [[ObservableMap]] of [pairs]. */
fun <K, V> mutableObservableMapOf(vararg pairs: Pair<K, V>): ObservableMap<K, V> =
    FXCollections.observableMap(HashMap<K, V>().apply { for ((key, value) in pairs) put(key, value) })

/** Converts this map to [[ObservableMap]]. */
inline fun <K, V> Map<K, V>.toMutableObservableMap(): ObservableMap<K, V> = FXCollections.observableMap(this)

inline fun <K, V> ObservableMap<K, V>.bindContentBidirectional(other: ObservableMap<K, V>): Unit =
    Bindings.bindContentBidirectional(this, other)

inline fun <K, V> ObservableMap<K, V>.unbindContentBidirectional(other: ObservableMap<K, V>): Unit =
    Bindings.unbindContentBidirectional(this, other)

inline fun <K, V> Map<K, V>.bindContent(other: ObservableMap<K, V>): Unit = Bindings.bindContent(this, other)

inline fun <K, V> Map<K, V>.unbindContent(other: ObservableMap<K, V>): Unit = Bindings.unbindContent(this, other)

inline val <K, V> ObservableMap<K, V>.sizeBinding: IntegerBinding get() = Bindings.size(this)

inline val <K, V> ObservableMap<K, V>.isEmptyBinding: BooleanBinding get() = Bindings.isEmpty(this)

inline val <K, V> ObservableMap<K, V>.isNotEmptyBinding: BooleanBinding get() = Bindings.isNotEmpty(this)

inline fun <K, V> ObservableMap<K, V>.getBinding(key: K): ObjectBinding<V> = Bindings.valueAt(this, key)
inline fun <K, V> ObservableMap<K, V>.getBinding(key: ObservableValue<K>): ObjectBinding<V> =
    Bindings.valueAt(this, key)

inline fun <K> ObservableMap<K, Boolean>.getBinding(key: K): BooleanBinding = Bindings.booleanValueAt(this, key)
inline fun <K> ObservableMap<K, Boolean>.getBinding(key: ObservableValue<K>): BooleanBinding =
    Bindings.booleanValueAt(this, key)

inline fun <K> ObservableMap<K, Double>.getBinding(key: K): DoubleBinding = Bindings.doubleValueAt(this, key)
inline fun <K> ObservableMap<K, Double>.getBinding(key: ObservableValue<K>): DoubleBinding =
    Bindings.doubleValueAt(this, key)

inline fun <K> ObservableMap<K, Float>.getBinding(key: K): FloatBinding = Bindings.floatValueAt(this, key)
inline fun <K> ObservableMap<K, Float>.getBinding(key: ObservableValue<K>): FloatBinding =
    Bindings.floatValueAt(this, key)

inline fun <K> ObservableMap<K, Int>.getBinding(key: K): IntegerBinding = Bindings.integerValueAt(this, key)
inline fun <K> ObservableMap<K, Int>.getBinding(key: ObservableValue<K>): IntegerBinding =
    Bindings.integerValueAt(this, key)

inline fun <K> ObservableMap<K, Long>.getBinding(key: K): LongBinding = Bindings.longValueAt(this, key)
inline fun <K> ObservableMap<K, Long>.getBinding(key: ObservableValue<K>): LongBinding = Bindings.longValueAt(this, key)

inline fun <K> ObservableMap<K, String>.getBinding(key: K): StringBinding = Bindings.stringValueAt(this, key)
inline fun <K> ObservableMap<K, String>.getBinding(key: ObservableValue<K>): StringBinding =
    Bindings.stringValueAt(this, key)