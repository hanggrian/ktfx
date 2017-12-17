package kotfx.bindings

import javafx.beans.binding.Bindings
import javafx.collections.ObservableSet

class ObservableSetBindingsTest {

    fun sizeBinding(set: ObservableSet<*>) {
        Bindings.size(set)
        set.sizeBinding
    }

    fun emptyBinding(set: ObservableSet<*>) {
        Bindings.isEmpty(set)
        set.emptyBinding
    }

    fun notEmptyBinding(set: ObservableSet<*>) {
        Bindings.isNotEmpty(set)
        set.notEmptyBinding
    }
}