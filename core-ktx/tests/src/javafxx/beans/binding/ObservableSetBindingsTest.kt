package javafxx.beans.binding

import javafx.beans.binding.Bindings
import javafx.collections.ObservableSet
import javafxx.collections.emptyBinding
import javafxx.collections.notEmptyBinding
import javafxx.collections.sizeBinding

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