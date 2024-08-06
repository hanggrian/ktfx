package ktfx.coroutines

import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import kotlinx.coroutines.Dispatchers
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableTest {
    @Test
    fun listener() {
        val property = SimpleStringProperty()
        property.listener(Dispatchers.Unconfined) {
            assertTrue(it is StringProperty)
            assertEquals("Hello world", it.get())
        }
        property.set("Hello world")
    }
}
