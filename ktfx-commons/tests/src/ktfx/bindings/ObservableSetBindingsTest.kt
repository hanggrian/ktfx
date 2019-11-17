package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.collections.ObservableSet
import ktfx.collections.emptyBinding
import ktfx.collections.notEmptyBinding
import ktfx.collections.sizeBinding

class ObservableSetBindingsTest {

    fun sizeBinding(set: ObservableSet<*>) {
        Bindings.size(set)
        set.sizeBinding
    }

    fun isEmpty(set: ObservableSet<*>) {
        Bindings.isEmpty(set)
        set.emptyBinding
    }

    fun isNotEmpty(set: ObservableSet<*>) {
        Bindings.isNotEmpty(set)
        set.notEmptyBinding
    }
}