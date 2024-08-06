package ktfx.coroutines

import javafx.collections.FXCollections
import kotlinx.coroutines.Dispatchers
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableMapTest {
    @Test
    fun listener() {
        val collection = FXCollections.observableHashMap<Int, String>()
        collection.listener<Int, String>(Dispatchers.Unconfined) {
            assertTrue(it.wasAdded())
            assertEquals(1, it.key)
            assertEquals("Hello world", it.valueAdded)
        }
        collection[1] = "Hello world"
    }
}
