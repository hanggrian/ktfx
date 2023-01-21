package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseObservableTest
import javafx.beans.Observable

class ObservableTest : BaseObservableTest() {
    override fun Observable.callListener(action: (Observable) -> Unit) {
        listener(action)
    }
}
