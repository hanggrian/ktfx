package kotfx.bindings

import javafx.beans.binding.Bindings
import javafx.collections.ObservableSet

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
class ObservableSetBindingsTest {

    fun size2(set: ObservableSet<*>) {
        Bindings.size(set)
        set.size2
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