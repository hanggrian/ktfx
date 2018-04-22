package ktfx.coroutines.beans

import javafx.beans.Observable
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import ktfx.coroutines.listener
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableTest {

    private val observable: Observable = SimpleStringProperty()

    @Test fun listener() = observable.run {
        val s = "Hello world"
        val listener = listener {
            assertTrue(it is StringProperty)
            assertEquals((it as StringProperty).get(), s)
        }
        (this as StringProperty).set(s)
        removeListener(listener)
    }
}