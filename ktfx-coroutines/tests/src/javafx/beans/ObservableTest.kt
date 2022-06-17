package ktfx.coroutines

import javafx.beans.Observable
import kotlinx.coroutines.Dispatchers
import com.hendraanggrian.ktfx.test.BaseObservableTest

class ObservableTest : BaseObservableTest() {

    override fun Observable.callListener(action: (Observable) -> Unit) {
        listener(Dispatchers.Unconfined) { action(it) }
    }
}
