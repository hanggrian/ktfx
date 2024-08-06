package ktfx.coroutines

import javafx.collections.FXCollections
import kotlinx.coroutines.Dispatchers
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableListTest {
    @Test
    fun listener() {
        val collection = FXCollections.observableArrayList<String>()
        collection.listener<String>(Dispatchers.Unconfined) {
            it.next()
            assertEquals(0, it.from)
            assertEquals(1, it.to)
            assertTrue(it.wasAdded())
            assertEquals("Hello world", it.addedSubList.single())
        }
        collection.add("Hello world")
    }
}
