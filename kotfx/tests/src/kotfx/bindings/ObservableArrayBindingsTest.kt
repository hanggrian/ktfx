package kotfx.bindings

import javafx.beans.binding.Bindings
import javafx.collections.ObservableArray
import javafx.collections.ObservableFloatArray
import javafx.collections.ObservableIntegerArray

class ObservableArrayBindingsTest {

    fun sizeBinding(array: ObservableArray<*>) {
        Bindings.size(array)
        array.sizeBinding
    }

    fun floatValueAt(array: ObservableFloatArray) {
        Bindings.floatValueAt(array, 0)
        array.floatValueAt(0)
    }

    fun integerValueAt(array: ObservableIntegerArray) {
        Bindings.integerValueAt(array, 0)
        array.intValueAt(0)
    }
}