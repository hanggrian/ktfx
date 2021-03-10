package ktfx.listeners

import javafx.collections.ListChangeListener
import javafx.collections.ObservableList
import io.github.hendraanggrian.ktfx.test.BaseObservableListTest

class ObservableListTest : BaseObservableListTest() {

    override fun <E> ObservableList<E>.callListener(action: (ListChangeListener.Change<out E>) -> Unit) {
        listener(action)
    }
}