package ktfx

import ktfx.collections.toMutableObservableList
import ktfx.collections.toObservableList
import org.junit.Test
import kotlin.test.assertEquals

class CollectionsTest {

    private val iterable = listOf<Int>()

    @Test fun immutable() {
        val list = iterable.toObservableList()
        assertEquals(list.size, 0)
    }

    @Test fun mutable() {
        val list = iterable.toMutableObservableList()
        list += 1
        list += 2
        list += 3
        assertEquals(list.size, 3)
    }
}