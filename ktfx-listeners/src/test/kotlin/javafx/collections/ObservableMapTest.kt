package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseObservableMapTest
import javafx.collections.MapChangeListener
import javafx.collections.ObservableMap

class ObservableMapTest : BaseObservableMapTest() {
    override fun <K, V> ObservableMap<K, V>.callListener(
        action: (MapChangeListener.Change<out K, out V>) -> Unit
    ) {
        listener(action)
    }
}
