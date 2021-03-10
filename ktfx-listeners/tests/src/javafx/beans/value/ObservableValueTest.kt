package ktfx.listeners

import javafx.beans.Observable
import javafx.beans.value.ObservableValue
import io.github.hendraanggrian.ktfx.test.BaseObservableValueTest

class ObservableValueTest : BaseObservableValueTest() {

    override fun ObservableValue<String>.callListener(action: (Observable, String, String) -> Unit) {
        listener(action)
    }
}