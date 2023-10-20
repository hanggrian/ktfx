package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseObservableSetTest
import javafx.collections.ObservableSet
import javafx.collections.SetChangeListener
import kotlinx.coroutines.Dispatchers

class ObservableSetTest : BaseObservableSetTest() {
    override fun <E> ObservableSet<E>.callListener(
        action: (SetChangeListener.Change<out E>) -> Unit,
    ) {
        listener<E>(Dispatchers.Unconfined) { action(it) }
    }
}
