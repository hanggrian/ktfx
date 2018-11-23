package ktfx.coroutines.collections

import ktfx.collections.mutableObservableMapOf
import ktfx.coroutines.listener
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableMapTest {

    private val observable = mutableObservableMapOf<Int, String>()

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