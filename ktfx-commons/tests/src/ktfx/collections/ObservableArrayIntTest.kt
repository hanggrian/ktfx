package ktfx.collections

import ktfx.test.ObservableArrayTest
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ObservableArrayIntTest : ObservableArrayTest() {

    override fun observableArrayOf() {
        val empty = observableIntArrayOf()
        assertTrue(empty.isEmpty())

        val filled = observableIntArrayOf(1, 2, 3)
        assertFalse(filled.isEmpty())
    }

    override fun toObservableArray() {
        val array = intArrayOf(1, 2, 3).toObservableArray()
        assertEquals(3, array.size())

        val typedArray = arrayOf(1, 2, 3).toObservableArray()
        assertEquals(3, typedArray.size())
    }
}