package kotfx.bindings

import javafx.beans.binding.Bindings
import javafx.collections.ObservableMap

class ObservableMapBindingsTest {

    fun sizeBinding(map: ObservableMap<*, *>) {
        Bindings.size(map)
        map.sizeBinding
    }

    fun emptyBinding(map: ObservableMap<*, *>) {
        Bindings.isEmpty(map)
        map.emptyBinding
    }

    fun notEmptyBinding(map: ObservableMap<*, *>) {
        Bindings.isNotEmpty(map)
        map.notEmptyBinding
    }

    fun valueAt(map: ObservableMap<Int, *>) {
        Bindings.valueAt(map, 0)
        map.valueAt(0)
    }

    fun booleanValueAt(map: ObservableMap<Int, Boolean>) {
        Bindings.booleanValueAt(map, 0)
        map.booleanValueAt(0)
    }

    fun doubleValueAt(map: ObservableMap<Int, Double>) {
        Bindings.doubleValueAt(map, 0)
        map.doubleValueAt(0)
    }

    fun floatValueAt(map: ObservableMap<Int, Float>) {
        Bindings.floatValueAt(map, 0)
        map.floatValueAt(0)
    }

    fun integerValueAt(map: ObservableMap<Int, Int>) {
        Bindings.integerValueAt(map, 0)
        map.intValueAt(0)
    }

    fun longValueAt(map: ObservableMap<Int, Long>) {
        Bindings.longValueAt(map, 0)
        map.longValueAt(0)
    }

    fun stringValueAt(map: ObservableMap<Int, String>) {
        Bindings.stringValueAt(map, 0)
        map.stringValueAt(0)
    }
}