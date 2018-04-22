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

    @Test fun listener() = observable.run {
        val s = "Hello world"
        val listener = listener { observable, oldValue, value ->
            assertTrue(observable is StringProperty)
            assertNull(oldValue)
            assertEquals(value, s)
        }
        (this as StringProperty).set(s)
        removeListener(listener)
    }
}