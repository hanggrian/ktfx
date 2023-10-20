package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseObservableValueTest
import javafx.beans.Observable
import javafx.beans.value.ObservableValue
import kotlinx.coroutines.Dispatchers

class ObservableValueTest : BaseObservableValueTest() {
    override fun ObservableValue<String>.callListener(
        action: (Observable, String, String) -> Unit,
    ) {
        listener(Dispatchers.Unconfined) { observable, oldValue, value ->
            action(observable, oldValue, value)
        }
    }
}
