package ktfx.collections

import ktfx.test.ObservableArrayTest
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ObservableArrayFloatTest : ObservableArrayTest() {

    override fun observableArrayOf() {
        val empty = observableFloatArrayOf()
        assertTrue(empty.isEmpty())

        val filled = observableFloatArrayOf(1f, 2f, 3f)
        assertFalse(filled.isEmpty())
    }

    override fun toObservableArray() {
        val array = floatArrayOf(1f, 2f, 3f).toObservableArray()
        assertEquals(3, array.size())

        val typedArray = arrayOf(1f, 2f, 3f).toObservableArray()
        assertEquals(3, typedArray.size())
    }
}