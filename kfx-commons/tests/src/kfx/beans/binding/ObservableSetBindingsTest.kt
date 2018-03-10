package kfx.beans.binding

import javafx.beans.binding.Bindings
import javafx.collections.ObservableSet
import kfx.collections.emptyBinding
import kfx.collections.notEmptyBinding
import kfx.collections.sizeBinding

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