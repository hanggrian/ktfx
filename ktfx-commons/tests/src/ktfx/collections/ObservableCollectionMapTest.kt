package ktfx.collections

import ktfx.test.ObservableCollectionTest
import ktfx.test.assertContains
import ktfx.test.assertEmpty
import kotlin.test.assertFails

class ObservableCollectionMapTest : ObservableCollectionTest() {

    override fun emptyObservableCollection() {
        val emptyMap = emptyObservableMap<Int, Int>()
        assertEmpty(emptyMap.keys)
        assertFails { emptyMap += 1 to 1 }
    }

    override fun observableCollectionOf() {
        val emptyMap = observableMapOf<Int, Int>()
        assertEmpty(emptyMap.keys)
        assertFails { emptyMap += 1 to 1 }

        val map = observableMapOf(1 to 1, 2 to 2, 3 to 3)
        assertContains(map.keys, 1, 2, 3).inOrder()
        assertFails { map += 1 to 1 }
    }

    override fun mutableObservableCollectionOf() {
        val emptyMap = mutableObservableMapOf<Int, Int>()
        emptyMap += 1 to 1
        emptyMap += 2 to 2
        assertContains(emptyMap.keys, 1, 2).inOrder()

        val filledMap = mutableObservableMapOf(1 to 1, 2 to 2)
        filledMap += 3 to 3
        assertContains(filledMap.keys, 1, 2, 3).inOrder()
    }

    override fun toObservableCollection() {
        val map = mapOf(1 to 1, 2 to 2, 3 to 3).toObservableMap()
        assertContains(map.keys, 1, 2, 3).inOrder()
        assertFails { map += 4 to 4 }
    }

    override fun toMutableObservableCollection() {
        val map = mapOf(1 to 1, 2 to 2).toMutableObservableMap()
        map += 3 to 3
        assertContains(map.keys, 1, 2, 3).inOrder()
    }
}