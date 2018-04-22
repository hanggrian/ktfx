package ktfx.coroutines.collections

import javafx.collections.ObservableSet
import ktfx.collections.mutableObservableSetOf
import ktfx.coroutines.listener
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableSetTest {

    private val observable: ObservableSet<String> = mutableObservableSetOf()

    /*@Test fun listener() = observable.run {
        val s = "Hello"
        val listener = listener {
            assertTrue(it.wasAdded())
            assertEquals(it.elementAdded, s)
        }
        add(s)
        removeListener(listener)
    }*/
}