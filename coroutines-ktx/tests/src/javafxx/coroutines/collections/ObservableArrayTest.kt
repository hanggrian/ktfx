package javafxx.coroutines.collections

import javafx.collections.ObservableIntegerArray
import javafxx.collections.observableIntArrayOf
import javafxx.coroutines.listener
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableArrayTest {

    private val observable: ObservableIntegerArray = observableIntArrayOf()

    @Test fun listener() = observable.run {
        val i = 1
        val listener = listener<ObservableIntegerArray> { array, changed, from, to ->
            assertEquals(array, observable)
            assertTrue(changed)
            assertEquals(from, 0)
            assertEquals(to, 1)
        }
        addAll(i)
        removeListener(listener)
    }
}