package ktfx.listeners

import javafx.beans.Observable
import javafx.collections.ObservableArray
import ktfx.test.BaseObservableArrayTest

class ObservableArrayTest : BaseObservableArrayTest() {

    override fun <T : ObservableArray<T>> ObservableArray<T>.callListener(action: (Observable, Boolean, Int, Int) -> Unit) {
        listener(action)
    }
}