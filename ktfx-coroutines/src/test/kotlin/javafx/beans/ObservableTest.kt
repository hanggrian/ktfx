package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseObservableTest
import javafx.beans.Observable
import kotlinx.coroutines.Dispatchers

class ObservableTest : BaseObservableTest() {
    override fun Observable.callListener(action: (Observable) -> Unit) {
        listener(Dispatchers.Unconfined) { action(it) }
    }
}
