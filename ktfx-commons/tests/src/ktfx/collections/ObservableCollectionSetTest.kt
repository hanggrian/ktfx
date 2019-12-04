package ktfx.collections

import ktfx.test.ObservableCollectionTest
import ktfx.test.assertContains
import ktfx.test.assertEmpty
import kotlin.test.assertFails

class ObservableCollectionSetTest : ObservableCollectionTest() {

    override fun emptyObservableCollection() {
        val empty = emptyObservableSet<Int>()
        assertEmpty(empty)
        assertFails { empty += 1 }
    }

    override fun observableCollectionOf() {
        val empty = observableSetOf<Int>()
        assertEmpty(empty)
        assertFails { empty += 1 }

        val filled = observableSetOf(1, 2, 3)
        assertContains(filled, 1, 2, 3).inOrder()
        assertFails { filled += 1 }
    }

    override fun mutableObservableCollectionOf() {
        val empty = mutableObservableSetOf<Int>()
        empty += 1
        empty += 2
        assertContains(empty, 1, 2).inOrder()

        val filled = mutableObservableSetOf(1, 2)
        filled += 3
        assertContains(filled, 1, 2, 3).inOrder()
    }

    override fun toObservableCollection() {
        val array = arrayOf(1, 2, 3).toObservableSet()
        assertContains(array, 1, 2, 3).inOrder()
        assertFails { array += 4 }

        val list = listOf(1, 2, 3).toObservableSet()
        assertContains(list, 1, 2, 3).inOrder()
        assertFails { list += 4 }

        val sequence = sequenceOf(1, 2, 3).toObservableSet()
        assertContains(sequence, 1, 2, 3)
        assertFails { sequence += 4 }
    }

    override fun toMutableObservableCollection() {
        val array = arrayOf(1, 2).toMutableObservableSet()
        array += 3
        assertContains(array, 1, 2, 3).inOrder()

        val list = listOf(1, 2).toMutableObservableSet()
        list += 3
        assertContains(list, 1, 2, 3).inOrder()

        val sequence = sequenceOf(1, 2).toMutableObservableSet()
        sequence += 3
        assertContains(sequence, 1, 2, 3).inOrder()
    }
}