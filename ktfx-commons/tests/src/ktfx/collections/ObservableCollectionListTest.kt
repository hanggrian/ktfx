package ktfx.collections

import ktfx.testing.assertContains
import ktfx.testing.assertEmpty
import kotlin.test.Test
import kotlin.test.assertFails

class ObservableCollectionListTest : ObservableCollectionTest {

    @Test override fun empty() {
        val empty = emptyObservableList<Int>()
        assertEmpty(empty)
        assertFails { empty += 1 }
    }

    @Test override fun of() {
        val empty = observableListOf<Int>()
        assertEmpty(empty)
        assertFails { empty += 1 }

        val singleton = observableListOf(1)
        assertContains(singleton, 1).inOrder()
        assertFails { singleton += 1 }

        val list = observableListOf(1, 2, 3)
        assertContains(list, 1, 2, 3).inOrder()
        assertFails { list += 1 }
    }

    @Test override fun mutableOf() {
        val empty = mutableObservableListOf<Int>()
        empty += 1
        empty += 2
        assertContains(empty, 1, 2).inOrder()

        val filled = mutableObservableListOf(1, 2)
        filled += 3
        assertContains(filled, 1, 2, 3).inOrder()
    }

    @Test override fun to() {
        val array = arrayOf(1, 2, 3).toObservableList()
        assertContains(array, 1, 2, 3).inOrder()
        assertFails { array += 4 }

        val list = listOf(1, 2, 3).toObservableList()
        assertContains(list, 1, 2, 3).inOrder()
        assertFails { list += 4 }

        val sequence = sequenceOf(1, 2, 3).toObservableList()
        assertContains(sequence, 1, 2, 3)
        assertFails { sequence += 4 }
    }

    @Test override fun toMutable() {
        val array = arrayOf(1, 2).toMutableObservableList()
        array += 3
        assertContains(array, 1, 2, 3).inOrder()

        val list = listOf(1, 2).toMutableObservableList()
        list += 3
        assertContains(list, 1, 2, 3).inOrder()

        val sequence = sequenceOf(1, 2).toMutableObservableList()
        sequence += 3
        assertContains(sequence, 1, 2, 3).inOrder()
    }
}