package ktfx.listeners

import javafx.collections.MapChangeListener
import javafx.collections.ObservableMap
import com.hendraanggrian.ktfx.test.BaseObservableMapTest

class ObservableMapTest : BaseObservableMapTest() {

    override fun <K, V> ObservableMap<K, V>.callListener(action: (MapChangeListener.Change<out K, out V>) -> Unit) {
        listener(action)
    }
}