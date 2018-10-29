package ktfx.collections

import ktfx.test.assertContains
import org.junit.Test
import kotlin.test.assertTrue

class ObservableListTest {

    @Test fun emptyObservableList() {
        assertTrue(emptyObservableList<Int>().isEmpty())
    }

    @Test fun observableListOf() {
        assertTrue(observableListOf<Int>().isEmpty())
        assertContains(observableListOf(1), 1).inOrder()
        assertContains(observableListOf(1, 2, 3), 1, 2, 3).inOrder()
    }

    @Test fun mutableObservableListOf() {
        val list1 = mutableObservableListOf<Int>()
        list1 += 1
        list1 += 2
        assertContains(list1, 1, 2).inOrder()
        val list2 = mutableObservableListOf(1, 2)
        list2 += 3
        assertContains(list2, 1, 2, 3).inOrder()
    }

    @Test fun toObservableList() {
        val list = listOf(1, 2).toObservableList()
        assertContains(list, 1, 2).inOrder()
    }

    @Test fun toMutableObservableList() {
        val list = listOf(1, 2).toMutableObservableList()
        list += 3
        assertContains(list, 1, 2, 3).inOrder()
    }

    @Test fun toObservableSet() {
        val set = listOf(1, 2, 2).toObservableSet()
        assertContains(set, 1, 2).inOrder()
    }

    @Test fun toMutableObservableSet() {
        val set = listOf(1, 2, 2).toMutableObservableSet()
        set += 3
        set += 3
        assertContains(set, 1, 2, 3).inOrder()
    }
}