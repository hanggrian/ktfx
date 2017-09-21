package kotfx.bindings

import javafx.beans.binding.Bindings
import javafx.collections.ObservableArray
import javafx.collections.ObservableFloatArray
import javafx.collections.ObservableIntegerArray

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
class ObservableArrayBindingsTest {

    fun size2(array: ObservableArray<*>) {
        Bindings.size(array)
        array.size2
    }

    fun floatValueAt(array: ObservableFloatArray) {
        Bindings.floatValueAt(array, 0)
        array.floatValueAt(0)
    }

    fun integerValueAt(array: ObservableIntegerArray) {
        Bindings.integerValueAt(array, 0)
        array.integerValueAt(0)
    }
}