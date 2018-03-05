package kotlinfx.beans.binding

import javafx.beans.binding.Bindings
import javafx.collections.ObservableSet
import kotlinfx.collections.emptyBinding
import kotlinfx.collections.notEmptyBinding
import kotlinfx.collections.sizeBinding

class ObservableSetBindingsTest {

    fun sizeBinding(set: ObservableSet<*>) {
        Bindings.size(set)
        set.sizeBinding()
    }

    fun isEmpty(set: ObservableSet<*>) {
        Bindings.isEmpty(set)
        set.emptyBinding()
    }

    fun isNotEmpty(set: ObservableSet<*>) {
        Bindings.isNotEmpty(set)
        set.notEmptyBinding()
    }
}