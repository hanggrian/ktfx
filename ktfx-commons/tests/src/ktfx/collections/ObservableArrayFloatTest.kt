package ktfx.collections

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ObservableArrayFloatTest : ObservableArrayTest {

    @Test override fun of() {
        val empty = observableFloatArrayOf()
        assertTrue(empty.isEmpty())

        val filled = observableFloatArrayOf(1f, 2f, 3f)
        assertFalse(filled.isEmpty())
    }

    @Test override fun to() {
        val array = floatArrayOf(1f, 2f, 3f).toObservableArray()
        assertEquals(3, array.size())

        val typedArray = arrayOf(1f, 2f, 3f).toObservableArray()
        assertEquals(3, typedArray.size())
    }
}