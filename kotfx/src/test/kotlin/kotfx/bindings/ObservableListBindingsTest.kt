package kotfx.bindings

import javafx.beans.binding.Bindings
import javafx.collections.ObservableList

class ObservableListBindingsTest {

    fun sizeBinding(list: ObservableList<*>) {
        Bindings.size(list)
        list.sizeBinding
    }

    fun isEmpty(list: ObservableList<*>) {
        Bindings.isEmpty(list)
        list.isEmpty
    }

    fun isNotEmpty(list: ObservableList<*>) {
        Bindings.isNotEmpty(list)
        list.isNotEmpty
    }

    fun valueAt(list: ObservableList<*>) {
        Bindings.valueAt(list, 0)
        list.valueAt(0)
    }

    fun booleanValueAt(list: ObservableList<Boolean>) {
        Bindings.booleanValueAt(list, 0)
        list.booleanValueAt(0)
    }

    fun doubleValueAt(list: ObservableList<Double>) {
        Bindings.doubleValueAt(list, 0)
        list.doubleValueAt(0)
    }

    fun floatValueAt(list: ObservableList<Float>) {
        Bindings.floatValueAt(list, 0)
        list.floatValueAt(0)
    }

    fun integerValueAt(list: ObservableList<Int>) {
        Bindings.integerValueAt(list, 0)
        list.intValueAt(0)
    }

    fun longValueAt(list: ObservableList<Long>) {
        Bindings.longValueAt(list, 0)
        list.longValueAt(0)
    }

    fun stringValueAt(list: ObservableList<String>) {
        Bindings.stringValueAt(list, 0)
        list.stringValueAt(0)
    }
}