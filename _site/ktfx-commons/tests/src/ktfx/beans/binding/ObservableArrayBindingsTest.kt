package ktfx.beans.binding

import javafx.beans.binding.Bindings
import javafx.collections.ObservableArray
import javafx.collections.ObservableFloatArray
import javafx.collections.ObservableIntegerArray
import ktfx.collections.getBinding
import ktfx.collections.sizeBinding

class ObservableArrayBindingsTest {

    fun sizeBinding(array: ObservableArray<*>) {
        Bindings.size(array)
        array.sizeBinding()
    }

    fun floatValueAt(array: ObservableFloatArray) {
        Bindings.floatValueAt(array, 0)
        array.getBinding(0)
    }

    fun integerValueAt(array: ObservableIntegerArray) {
        Bindings.integerValueAt(array, 0)
        array.getBinding(0)
    }
}