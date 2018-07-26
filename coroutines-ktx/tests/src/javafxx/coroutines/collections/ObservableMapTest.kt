package javafxx.coroutines.collections

import javafx.collections.ObservableMap
import javafxx.collections.mutableObservableMapOf
import javafxx.coroutines.listener
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableMapTest {

    private val observable: ObservableMap<Int, String> = mutableObservableMapOf()

    @Test fun listener() = observable.run {
        val i = 1
        val s = "Hello"
        val listener = listener<Int, String> {
            assertTrue(it.wasAdded())
            assertEquals(it.key, i)
            assertEquals(it.valueAdded, s)
        }
        put(i, s)
        removeListener(listener)
    }
}