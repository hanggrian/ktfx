package ktfx.coroutines.beans.value

import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.beans.value.ObservableValue
import ktfx.coroutines.listener
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ObservableValueTest {

    private val observable: ObservableValue<String> = SimpleStringProperty()

    @Test fun listener() {
        val s = "Hello world"
        val listener = observable.listener { observable, oldValue, value ->
            assertTrue(observable is StringProperty)
            assertNull(oldValue)
            assertEquals(value, s)
        }
        (observable as StringProperty).set(s)
        observable.removeListener(listener)
    }
}