package ktfx.listeners

import javafx.beans.Observable
import javafx.beans.value.ObservableValue
import ktfx.test.BaseObservableValueTest

class ObservableValueTest : BaseObservableValueTest() {

    override fun ObservableValue<String>.callListener(action: (Observable, String, String) -> Unit) {
        listener(action)
    }
}