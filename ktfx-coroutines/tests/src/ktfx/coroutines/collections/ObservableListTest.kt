package ktfx.coroutines.collections

import javafx.collections.ObservableList
import ktfx.collections.mutableObservableListOf
import ktfx.coroutines.listener
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableListTest {

    private val observable: ObservableList<String> = mutableObservableListOf()

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