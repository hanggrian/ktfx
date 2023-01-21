package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseObservableSetTest
import javafx.collections.ObservableSet
import javafx.collections.SetChangeListener

class ObservableSetTest : BaseObservableSetTest() {
    override fun <E> ObservableSet<E>.callListener(
        action: (SetChangeListener.Change<out E>) -> Unit
    ) {
        listener(action)
    }
}
