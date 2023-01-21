package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseObservableValueTest
import javafx.beans.Observable
import javafx.beans.value.ObservableValue

class ObservableValueTest : BaseObservableValueTest() {
    override fun ObservableValue<String>.callListener(
        action: (Observable, String, String) -> Unit
    ) {
        listener(action)
    }
}
