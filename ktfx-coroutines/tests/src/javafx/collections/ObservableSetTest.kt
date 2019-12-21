package ktfx.coroutines

import javafx.collections.ObservableSet
import javafx.collections.SetChangeListener
import kotlinx.coroutines.Dispatchers
import ktfx.test.BaseObservableSetTest

class ObservableSetTest : BaseObservableSetTest() {

    override fun <E> ObservableSet<E>.callListener(action: (SetChangeListener.Change<out E>) -> Unit) {
        listener<E>(Dispatchers.Unconfined) { action(it) }
    }
}