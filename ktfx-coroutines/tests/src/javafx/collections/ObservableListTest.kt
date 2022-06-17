package ktfx.coroutines

import javafx.collections.ListChangeListener
import javafx.collections.ObservableList
import kotlinx.coroutines.Dispatchers
import com.hendraanggrian.ktfx.test.BaseObservableListTest

class ObservableListTest : BaseObservableListTest() {

    override fun <E> ObservableList<E>.callListener(action: (ListChangeListener.Change<out E>) -> Unit) {
        listener<E>(Dispatchers.Unconfined) { action(it) }
    }
}
