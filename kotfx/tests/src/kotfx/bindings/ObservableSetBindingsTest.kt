package kotfx.bindings

import javafx.beans.binding.Bindings
import javafx.collections.ObservableSet

class ObservableSetBindingsTest {

    fun sizeBinding(set: ObservableSet<*>) {
        Bindings.size(set)
        set.sizeBinding
    }

    fun isEmpty(set: ObservableSet<*>) {
        Bindings.isEmpty(set)
        set.isEmpty
    }

    fun isNotEmpty(set: ObservableSet<*>) {
        Bindings.isNotEmpty(set)
        set.isNotEmpty
    }
}