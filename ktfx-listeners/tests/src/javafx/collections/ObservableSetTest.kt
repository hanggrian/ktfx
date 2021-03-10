package ktfx.listeners

import javafx.collections.ObservableSet
import javafx.collections.SetChangeListener
import io.github.hendraanggrian.ktfx.test.BaseObservableSetTest

class ObservableSetTest : BaseObservableSetTest() {

    override fun <E> ObservableSet<E>.callListener(action: (SetChangeListener.Change<out E>) -> Unit) {
        listener(action)
    }
}