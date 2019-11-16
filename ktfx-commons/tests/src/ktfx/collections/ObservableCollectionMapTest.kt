package ktfx.collections

import ktfx.testing.assertContains
import ktfx.testing.assertEmpty
import kotlin.test.Test
import kotlin.test.assertFails

class ObservableCollectionMapTest : ObservableCollectionTest {

    @Test override fun empty() {
        val emptyMap = emptyObservableMap<Int, Int>()
        assertEmpty(emptyMap.keys)
        assertFails { emptyMap += 1 to 1 }
    }

    @Test override fun of() {
        val emptyMap = observableMapOf<Int, Int>()
        assertEmpty(emptyMap.keys)
        assertFails { emptyMap += 1 to 1 }

        val map = observableMapOf(1 to 1, 2 to 2, 3 to 3)
        assertContains(map.keys, 1, 2, 3).inOrder()
        assertFails { map += 1 to 1 }
    }

    @Test override fun mutableOf() {
        val emptyMap = mutableObservableMapOf<Int, Int>()
        emptyMap += 1 to 1
        emptyMap += 2 to 2
        assertContains(emptyMap.keys, 1, 2).inOrder()

        val filledMap = mutableObservableMapOf(1 to 1, 2 to 2)
        filledMap += 3 to 3
        assertContains(filledMap.keys, 1, 2, 3).inOrder()
    }

    @Test override fun to() {
        val map = mapOf(1 to 1, 2 to 2, 3 to 3).toObservableMap()
        assertContains(map.keys, 1, 2, 3).inOrder()
        assertFails { map += 4 to 4 }
    }

    @Test override fun toMutable() {
        val map = mapOf(1 to 1, 2 to 2).toMutableObservableMap()
        map += 3 to 3
        assertContains(map.keys, 1, 2, 3).inOrder()
    }
}