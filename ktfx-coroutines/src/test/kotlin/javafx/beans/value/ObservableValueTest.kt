package ktfx.coroutines

import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import kotlinx.coroutines.Dispatchers
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ObservableValueTest {
    @Test
    fun listen() {
        val property = SimpleStringProperty()
        property.listener(Dispatchers.Unconfined) { observable, oldValue, value ->
            assertTrue(observable is StringProperty)
            assertNull(oldValue)
            assertEquals("Hello world", value)
        }
        property.set("Hello world")
    }
}
