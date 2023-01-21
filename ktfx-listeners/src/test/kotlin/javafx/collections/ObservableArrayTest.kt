package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseObservableArrayTest
import javafx.beans.Observable
import javafx.collections.ObservableArray

class ObservableArrayTest : BaseObservableArrayTest() {
    override fun <T : ObservableArray<T>> ObservableArray<T>.callListener(
        action: (Observable, Boolean, Int, Int) -> Unit
    ) {
        listener(action)
    }
}
