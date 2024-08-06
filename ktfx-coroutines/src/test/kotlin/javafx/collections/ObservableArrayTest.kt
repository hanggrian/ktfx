package ktfx.coroutines

import javafx.collections.FXCollections
import kotlinx.coroutines.Dispatchers
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableArrayTest {
    @Test
    fun listener() {
        val array = FXCollections.observableIntegerArray()
        array.listener(Dispatchers.Unconfined) { observable, changed, from, to ->
            assertEquals(observable, array)
            assertTrue(changed)
            assertEquals(0, from)
            assertEquals(1, to)
        }
        array.addAll(1)
    }
}
