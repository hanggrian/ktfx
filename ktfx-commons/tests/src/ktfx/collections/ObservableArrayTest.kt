package ktfx.collections

import ktfx.testing.assertContains
import kotlin.test.Test

class ObservableArrayTest {

    private val array = arrayOf(1, 2, 2, 3)

    @Test
    fun toObservableList() {
        val list = array.toObservableList()
        assertContains(list, 1, 2, 2, 3).inOrder()
    }

    @Test
    fun toMutableObservableList() {
        val list = array.toMutableObservableList()
        list += 4
        assertContains(list, 1, 2, 2, 3, 4).inOrder()
    }

    @Test
    fun toObservableSet() {
        val set = array.toObservableSet()
        assertContains(set, 1, 2, 3).inOrder()
    }

    @Test
    fun toMutableObservableSet() {
        val set = array.toMutableObservableSet()
        set += 3
        set += 4
        assertContains(set, 1, 2, 3, 4).inOrder()
    }
}