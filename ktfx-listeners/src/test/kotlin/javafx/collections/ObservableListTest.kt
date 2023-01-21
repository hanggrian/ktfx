package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseObservableListTest
import javafx.collections.ListChangeListener
import javafx.collections.ObservableList

class ObservableListTest : BaseObservableListTest() {
    override fun <E> ObservableList<E>.callListener(
        action: (ListChangeListener.Change<out E>) -> Unit
    ) {
        listener(action)
    }
}
