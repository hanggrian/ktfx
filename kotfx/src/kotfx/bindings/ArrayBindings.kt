@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.binding.Bindings.*
import javafx.beans.binding.FloatBinding
import javafx.beans.value.ObservableNumberValue
import javafx.collections.ObservableArray
import javafx.collections.ObservableFloatArray
import kotfx.collections.ObservableIntArray
import kotfx.properties.ObservableIntValue

inline val ObservableArray<*>.sizeBinding: IntBinding get() = size(this)

inline fun ObservableFloatArray.floatValueAt(index: Int): FloatBinding = floatValueAt(this, index)
inline fun ObservableFloatArray.floatValueAt(index: ObservableIntValue): FloatBinding = floatValueAt(this, index)
inline fun ObservableFloatArray.floatValueAt(index: ObservableNumberValue): FloatBinding = floatValueAt(this, index)

inline fun ObservableIntArray.intValueAt(index: Int): IntBinding = integerValueAt(this, index)
inline fun ObservableIntArray.intValueAt(index: ObservableIntValue): IntBinding = integerValueAt(this, index)
inline fun ObservableIntArray.intValueAt(index: ObservableNumberValue): IntBinding = integerValueAt(this, index)