@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.binding.*
import javafx.beans.value.ObservableValue
import javafx.collections.ObservableMap

inline fun <K, V> ObservableMap<K, V>.bindContentBidirectional(other: ObservableMap<K, V>) = Bindings.bindContentBidirectional(this, other)

inline fun <K, V> ObservableMap<K, V>.unbindContentBidirectional(other: ObservableMap<K, V>) = Bindings.unbindContentBidirectional(this, other)

inline fun <K, V> Map<K, V>.bindContent(other: ObservableMap<K, V>) = Bindings.bindContent(this, other)

inline fun <K, V> Map<K, V>.unbindContent(other: ObservableMap<K, V>) = Bindings.unbindContent(this, other)

inline val <K, V> ObservableMap<K, V>.size2: IntegerBinding get() = Bindings.size(this)

inline val <K, V> ObservableMap<K, V>.isEmpty: BooleanBinding get() = Bindings.isEmpty(this)

inline val <K, V> ObservableMap<K, V>.isNotEmpty: BooleanBinding get() = Bindings.isNotEmpty(this)

inline fun <K, V> ObservableMap<K, V>.valueAt(key: K): ObjectBinding<V> = Bindings.valueAt(this, key)
inline fun <K, V> ObservableMap<K, V>.valueAt(key: ObservableValue<K>): ObjectBinding<V> = Bindings.valueAt(this, key)

inline fun <K> ObservableMap<K, Boolean>.booleanValueAt(key: K): BooleanBinding = Bindings.booleanValueAt(this, key)
inline fun <K> ObservableMap<K, Boolean>.booleanValueAt(key: ObservableValue<K>): BooleanBinding = Bindings.booleanValueAt(this, key)

inline fun <K> ObservableMap<K, Double>.doubleValueAt(key: K): DoubleBinding = Bindings.doubleValueAt(this, key)
inline fun <K> ObservableMap<K, Double>.doubleValueAt(key: ObservableValue<K>): DoubleBinding = Bindings.doubleValueAt(this, key)

inline fun <K> ObservableMap<K, Float>.floatValueAt(key: K): FloatBinding = Bindings.floatValueAt(this, key)
inline fun <K> ObservableMap<K, Float>.floatValueAt(key: ObservableValue<K>): FloatBinding = Bindings.floatValueAt(this, key)

inline fun <K> ObservableMap<K, Int>.intValueAt(key: K): IntegerBinding = Bindings.integerValueAt(this, key)
inline fun <K> ObservableMap<K, Int>.intValueAt(key: ObservableValue<K>): IntegerBinding = Bindings.integerValueAt(this, key)

inline fun <K> ObservableMap<K, Long>.longValueAt(key: K): LongBinding = Bindings.longValueAt(this, key)
inline fun <K> ObservableMap<K, Long>.longValueAt(key: ObservableValue<K>): LongBinding = Bindings.longValueAt(this, key)

inline fun <K> ObservableMap<K, String>.stringValueAt(key: K): StringBinding = Bindings.stringValueAt(this, key)
inline fun <K> ObservableMap<K, String>.stringValueAt(key: ObservableValue<K>): StringBinding = Bindings.stringValueAt(this, key)