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
import javafx.beans.binding.LongBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding
import javafx.beans.value.ObservableNumberValue
import javafx.collections.ObservableList
import kotfx.properties.ObservableIntValue

inline fun <E> ObservableList<E>.bindContentBidirectional(other: ObservableList<E>) = bindContentBidirectional(this, other)

inline fun <E> ObservableList<E>.unbindContentBidirectional(other: ObservableList<E>) = unbindContentBidirectional(this, other)

inline fun <E> List<E>.bindContent(other: ObservableList<E>) = bindContent(this, other)

inline fun <E> List<E>.unbindContent(other: ObservableList<E>) = unbindContent(this, other)

inline val <E> ObservableList<E>.sizeBinding: IntBinding get() = size(this)

inline val <E> ObservableList<E>.isEmpty: BooleanBinding get() = isEmpty(this)

inline val <E> ObservableList<E>.isNotEmpty: BooleanBinding get() = isNotEmpty(this)

inline fun <E> ObservableList<E>.valueAt(index: Int): ObjectBinding<E> = valueAt(this, index)
inline fun <E> ObservableList<E>.valueAt(index: ObservableIntValue): ObjectBinding<E> = valueAt(this, index)
inline fun <E> ObservableList<E>.valueAt(index: ObservableNumberValue): ObjectBinding<E> = valueAt(this, index)

inline fun ObservableList<Boolean>.booleanValueAt(index: Int): BooleanBinding = booleanValueAt(this, index)
inline fun ObservableList<Boolean>.booleanValueAt(index: ObservableIntValue): BooleanBinding = booleanValueAt(this, index)
inline fun ObservableList<Boolean>.booleanValueAt(index: ObservableNumberValue): BooleanBinding = booleanValueAt(this, index)

inline fun ObservableList<Double>.doubleValueAt(index: Int): DoubleBinding = doubleValueAt(this, index)
inline fun ObservableList<Double>.doubleValueAt(index: ObservableIntValue): DoubleBinding = doubleValueAt(this, index)
inline fun ObservableList<Double>.doubleValueAt(index: ObservableNumberValue): DoubleBinding = doubleValueAt(this, index)

inline fun ObservableList<Float>.floatValueAt(index: Int): FloatBinding = floatValueAt(this, index)
inline fun ObservableList<Float>.floatValueAt(index: ObservableIntValue): FloatBinding = floatValueAt(this, index)
inline fun ObservableList<Float>.floatValueAt(index: ObservableNumberValue): FloatBinding = floatValueAt(this, index)

inline fun ObservableList<Int>.intValueAt(index: Int): IntBinding = integerValueAt(this, index)
inline fun ObservableList<Int>.intValueAt(index: ObservableIntValue): IntBinding = integerValueAt(this, index)
inline fun ObservableList<Int>.intValueAt(index: ObservableNumberValue): IntBinding = integerValueAt(this, index)

inline fun ObservableList<Long>.longValueAt(index: Int): LongBinding = longValueAt(this, index)
inline fun ObservableList<Long>.longValueAt(index: ObservableIntValue): LongBinding = longValueAt(this, index)
inline fun ObservableList<Long>.longValueAt(index: ObservableNumberValue): LongBinding = longValueAt(this, index)

inline fun ObservableList<String>.stringValueAt(index: Int): StringBinding = stringValueAt(this, index)
inline fun ObservableList<String>.stringValueAt(index: ObservableIntValue): StringBinding = stringValueAt(this, index)
inline fun ObservableList<String>.stringValueAt(index: ObservableNumberValue): StringBinding = stringValueAt(this, index)