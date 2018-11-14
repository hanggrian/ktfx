package ktfx.beans.binding

import javafx.beans.binding.Bindings
import javafx.collections.ObservableSet
import ktfx.collections.isEmptyBinding
import ktfx.collections.isNotEmptyBinding
import ktfx.collections.sizeBinding

class ObservableSetBindingsTest {

    fun sizeBinding(set: ObservableSet<*>) {
        Bindings.size(set)
        set.sizeBinding
    }

    fun isEmpty(set: ObservableSet<*>) {
        Bindings.isEmpty(set)
        set.isEmptyBinding
    }

    fun isNotEmpty(set: ObservableSet<*>) {
        Bindings.isNotEmpty(set)
        set.isNotEmptyBinding
    }
}