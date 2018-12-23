package ktfx

import javafx.beans.binding.Bindings
import javafx.collections.ObservableMap
import ktfx.collections.getBinding
import ktfx.collections.isEmptyBinding
import ktfx.collections.isNotEmptyBinding
import ktfx.collections.sizeBinding

class ObservableMapBindingsTest {

    fun sizeBinding(map: ObservableMap<*, *>) {
        Bindings.size(map)
        map.sizeBinding
    }

    fun isEmpty(map: ObservableMap<*, *>) {
        Bindings.isEmpty(map)
        map.isEmptyBinding
    }

    fun isNotEmpty(map: ObservableMap<*, *>) {
        Bindings.isNotEmpty(map)
        map.isNotEmptyBinding
    }

    fun valueAt(map: ObservableMap<Int, *>) {
        Bindings.valueAt(map, 0)
        map.getBinding(0)
    }

    fun booleanValueAt(map: ObservableMap<Int, Boolean>) {
        Bindings.booleanValueAt(map, 0)
        map.getBinding(0)
    }

    fun doubleValueAt(map: ObservableMap<Int, Double>) {
        Bindings.doubleValueAt(map, 0)
        map.getBinding(0)
    }

    fun floatValueAt(map: ObservableMap<Int, Float>) {
        Bindings.floatValueAt(map, 0)
        map.getBinding(0)
    }

    fun integerValueAt(map: ObservableMap<Int, Int>) {
        Bindings.integerValueAt(map, 0)
        map.getBinding(0)
    }

    fun longValueAt(map: ObservableMap<Int, Long>) {
        Bindings.longValueAt(map, 0)
        map.getBinding(0)
    }

    fun stringValueAt(map: ObservableMap<Int, String>) {
        Bindings.stringValueAt(map, 0)
        map.getBinding(0)
    }
}