@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.binding.*
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableNumberValue
import javafx.collections.ObservableList

inline fun <E> ObservableList<E>.bindContentBidirectional(other: ObservableList<E>) = Bindings.bindContentBidirectional(this, other)

inline fun <E> ObservableList<E>.unbindContentBidirectional(other: ObservableList<E>) = Bindings.unbindContentBidirectional(this, other)

inline fun <E> List<E>.bindContent(other: ObservableList<E>) = Bindings.bindContent(this, other)

inline fun <E> List<E>.unbindContent(other: ObservableList<E>) = Bindings.unbindContent(this, other)

inline val <E> ObservableList<E>.size2: IntegerBinding get() = Bindings.size(this)

inline val <E> ObservableList<E>.isEmpty: BooleanBinding get() = Bindings.isEmpty(this)

inline val <E> ObservableList<E>.isNotEmpty: BooleanBinding get() = Bindings.isNotEmpty(this)

inline fun <E> ObservableList<E>.valueAt(index: Int): ObjectBinding<E> = Bindings.valueAt(this, index)
inline fun <E> ObservableList<E>.valueAt(index: ObservableIntegerValue): ObjectBinding<E> = Bindings.valueAt(this, index)
inline fun <E> ObservableList<E>.valueAt(index: ObservableNumberValue): ObjectBinding<E> = Bindings.valueAt(this, index)

inline fun ObservableList<Boolean>.booleanValueAt(index: Int): BooleanBinding = Bindings.booleanValueAt(this, index)
inline fun ObservableList<Boolean>.booleanValueAt(index: ObservableIntegerValue): BooleanBinding = Bindings.booleanValueAt(this, index)
inline fun ObservableList<Boolean>.booleanValueAt(index: ObservableNumberValue): BooleanBinding = Bindings.booleanValueAt(this, index)

inline fun ObservableList<Double>.doubleValueAt(index: Int): DoubleBinding = Bindings.doubleValueAt(this, index)
inline fun ObservableList<Double>.doubleValueAt(index: ObservableIntegerValue): DoubleBinding = Bindings.doubleValueAt(this, index)
inline fun ObservableList<Double>.doubleValueAt(index: ObservableNumberValue): DoubleBinding = Bindings.doubleValueAt(this, index)

inline fun ObservableList<Float>.floatValueAt(index: Int): FloatBinding = Bindings.floatValueAt(this, index)
inline fun ObservableList<Float>.floatValueAt(index: ObservableIntegerValue): FloatBinding = Bindings.floatValueAt(this, index)
inline fun ObservableList<Float>.floatValueAt(index: ObservableNumberValue): FloatBinding = Bindings.floatValueAt(this, index)

inline fun ObservableList<Int>.integerValueAt(index: Int): IntegerBinding = Bindings.integerValueAt(this, index)
inline fun ObservableList<Int>.integerValueAt(index: ObservableIntegerValue): IntegerBinding = Bindings.integerValueAt(this, index)
inline fun ObservableList<Int>.integerValueAt(index: ObservableNumberValue): IntegerBinding = Bindings.integerValueAt(this, index)

inline fun ObservableList<Long>.longValueAt(index: Int): LongBinding = Bindings.longValueAt(this, index)
inline fun ObservableList<Long>.longValueAt(index: ObservableIntegerValue): LongBinding = Bindings.longValueAt(this, index)
inline fun ObservableList<Long>.longValueAt(index: ObservableNumberValue): LongBinding = Bindings.longValueAt(this, index)

inline fun ObservableList<String>.stringValueAt(index: Int): StringBinding = Bindings.stringValueAt(this, index)
inline fun ObservableList<String>.stringValueAt(index: ObservableIntegerValue): StringBinding = Bindings.stringValueAt(this, index)
inline fun ObservableList<String>.stringValueAt(index: ObservableNumberValue): StringBinding = Bindings.stringValueAt(this, index)