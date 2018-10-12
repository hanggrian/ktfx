package ktfx.coroutines.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import ktfx.coroutines.listener
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableListTest {

    private val observable: ObservableList<String> = FXCollections.observableArrayList()

    @Test fun listener() = observable.run {
        val s = "Hello"
        val listener = listener<String> {
            it.next()
            assertEquals(it.from, 0)
            assertEquals(it.to, 1)
            assertTrue(it.wasAdded())
            assertEquals(it.addedSubList.single(), s)
        }
        add(s)
        removeListener(listener)
    }
}