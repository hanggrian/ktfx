@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableNumberValue
import javafx.collections.ObservableArray
import javafx.collections.ObservableFloatArray
import javafx.collections.ObservableIntegerArray

inline val ObservableArray<*>.size2: IntegerBinding get() = Bindings.size(this)

inline fun ObservableFloatArray.floatValueAt(index: Int): FloatBinding = Bindings.floatValueAt(this, index)
inline fun ObservableFloatArray.floatValueAt(index: ObservableIntegerValue): FloatBinding = Bindings.floatValueAt(this, index)
inline fun ObservableFloatArray.floatValueAt(index: ObservableNumberValue): FloatBinding = Bindings.floatValueAt(this, index)

inline fun ObservableIntegerArray.integerValueAt(index: Int): IntegerBinding = Bindings.integerValueAt(this, index)
inline fun ObservableIntegerArray.integerValueAt(index: ObservableIntegerValue): IntegerBinding = Bindings.integerValueAt(this, index)
inline fun ObservableIntegerArray.integerValueAt(index: ObservableNumberValue): IntegerBinding = Bindings.integerValueAt(this, index)