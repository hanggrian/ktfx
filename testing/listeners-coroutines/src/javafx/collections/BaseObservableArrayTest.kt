package ktfx.test

import javafx.beans.Observable
import javafx.collections.FXCollections
import javafx.collections.ObservableArray
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

abstract class BaseObservableArrayTest {

    abstract fun <T : ObservableArray<T>> ObservableArray<T>.callListener(action: (Observable, Boolean, Int, Int) -> Unit)

    @Test fun listener() {
        val array = FXCollections.observableIntegerArray()
        array.callListener { observable, changed, from, to ->
            assertEquals(observable, array)
            assertTrue(changed)
            assertEquals(0, from)
            assertEquals(1, to)
        }
        array.addAll(1)
    }
}