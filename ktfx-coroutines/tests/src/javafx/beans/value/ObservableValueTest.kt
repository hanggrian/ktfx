package ktfx.coroutines

import javafx.beans.Observable
import javafx.beans.value.ObservableValue
import kotlinx.coroutines.Dispatchers
import io.github.hendraanggrian.ktfx.test.BaseObservableValueTest

class ObservableValueTest : BaseObservableValueTest() {

    override fun ObservableValue<String>.callListener(action: (Observable, String, String) -> Unit) {
        listener(Dispatchers.Unconfined) { observable, oldValue, value -> action(observable, oldValue, value) }
    }
}