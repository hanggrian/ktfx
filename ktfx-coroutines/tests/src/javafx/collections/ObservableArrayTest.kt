package ktfx.coroutines

import javafx.beans.Observable
import javafx.collections.ObservableArray
import kotlinx.coroutines.Dispatchers
import com.hendraanggrian.ktfx.test.BaseObservableArrayTest

class ObservableArrayTest : BaseObservableArrayTest() {

    override fun <T : ObservableArray<T>> ObservableArray<T>.callListener(action: (Observable, Boolean, Int, Int) -> Unit) {
        listener(Dispatchers.Unconfined) { observable, changed, from, to ->
            action(observable, changed, from, to)
        }
    }
}