package ktfx.listeners

import javafx.beans.Observable
import io.github.hendraanggrian.ktfx.test.BaseObservableTest

class ObservableTest : BaseObservableTest() {

    override fun Observable.callListener(action: (Observable) -> Unit) {
        listener(action)
    }
}