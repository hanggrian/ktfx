package javafxx.coroutines.collections

import javafx.collections.ObservableSet
import javafxx.collections.mutableObservableSetOf
import javafxx.coroutines.listener
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableSetTest {

    private val observable: ObservableSet<String> = mutableObservableSetOf()

    @Test fun listener() = observable.run {
        val s = "Hello"
        val listener = listener<String> {
            assertTrue(it.wasAdded())
            assertEquals(it.elementAdded, s)
        }
        add(s)
        removeListener(listener)
    }
}