@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

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
import javafx.collections.ObservableMap

inline fun <K, V> ObservableMap<K, V>.bindContentBidirectional(other: ObservableMap<K, V>) = bindContentBidirectional(this, other)

inline fun <K, V> ObservableMap<K, V>.unbindContentBidirectional(other: ObservableMap<K, V>) = unbindContentBidirectional(this, other)

inline fun <K, V> Map<K, V>.bindContent(other: ObservableMap<K, V>) = bindContent(this, other)

inline fun <K, V> Map<K, V>.unbindContent(other: ObservableMap<K, V>) = unbindContent(this, other)

inline val <K, V> ObservableMap<K, V>.sizeBinding: IntegerBinding get() = size(this)

inline val <K, V> ObservableMap<K, V>.isEmpty: BooleanBinding get() = isEmpty(this)

inline val <K, V> ObservableMap<K, V>.isNotEmpty: BooleanBinding get() = isNotEmpty(this)

inline fun <K, V> ObservableMap<K, V>.valueAt(key: K): ObjectBinding<V> = valueAt(this, key)
inline fun <K, V> ObservableMap<K, V>.valueAt(key: ObservableValue<K>): ObjectBinding<V> = valueAt(this, key)

inline fun <K> ObservableMap<K, Boolean>.booleanValueAt(key: K): BooleanBinding = booleanValueAt(this, key)
inline fun <K> ObservableMap<K, Boolean>.booleanValueAt(key: ObservableValue<K>): BooleanBinding = booleanValueAt(this, key)

inline fun <K> ObservableMap<K, Double>.doubleValueAt(key: K): DoubleBinding = doubleValueAt(this, key)
inline fun <K> ObservableMap<K, Double>.doubleValueAt(key: ObservableValue<K>): DoubleBinding = doubleValueAt(this, key)

inline fun <K> ObservableMap<K, Float>.floatValueAt(key: K): FloatBinding = floatValueAt(this, key)
inline fun <K> ObservableMap<K, Float>.floatValueAt(key: ObservableValue<K>): FloatBinding = floatValueAt(this, key)

inline fun <K> ObservableMap<K, Int>.intValueAt(key: K): IntegerBinding = integerValueAt(this, key)
inline fun <K> ObservableMap<K, Int>.intValueAt(key: ObservableValue<K>): IntegerBinding = integerValueAt(this, key)

inline fun <K> ObservableMap<K, Long>.longValueAt(key: K): LongBinding = longValueAt(this, key)
inline fun <K> ObservableMap<K, Long>.longValueAt(key: ObservableValue<K>): LongBinding = longValueAt(this, key)

inline fun <K> ObservableMap<K, String>.stringValueAt(key: K): StringBinding = stringValueAt(this, key)
inline fun <K> ObservableMap<K, String>.stringValueAt(key: ObservableValue<K>): StringBinding = stringValueAt(this, key)