package ktfx.coroutines.collections

import ktfx.collections.mutableObservableSetOf
import ktfx.coroutines.listener
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableSetTest {

    private val observable = mutableObservableSetOf<String>()

    @Test
    fun listener() = observable.run {
        val s = "Hello"
        val listener = listener<String> {
            assertTrue(it.wasAdded())
            assertEquals(it.elementAdded, s)
        }
        add(s)
        removeListener(listener)
    }
}