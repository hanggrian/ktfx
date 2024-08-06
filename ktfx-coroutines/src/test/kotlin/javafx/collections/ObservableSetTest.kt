package ktfx.coroutines

import javafx.collections.FXCollections
import kotlinx.coroutines.Dispatchers
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableSetTest {
    @Test
    fun listener() {
        val collection = FXCollections.observableSet<String>()
        collection.listener<String>(Dispatchers.Unconfined) {
            assertTrue(it.wasAdded())
            assertEquals("Hello world", it.elementAdded)
        }
        collection.add("Hello world")
    }
}
