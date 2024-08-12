package ktfx.collections

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ObservableArraysIntTest {
    @Test
    fun emptyObservableIntArray() =
        assertEquals(0, ktfx.collections.emptyObservableIntArray().size())

    @Test
    fun observableIntArrayOf() {
        assertEquals(0, ktfx.collections.observableIntArrayOf().size())
        assertEquals(0, observableIntArrayOf(*intArrayOf()).size())
        assertEquals(2, observableIntArrayOf(1, 2).size())
    }

    @Test
    fun toObservableIntArray() {
        val ints = intArrayOf(1, 2).toObservableArray()
        assertEquals(1, ints[0])
        assertEquals(2, ints[1])
    }

    @Test
    fun toIntArray() {
        val ints = observableIntArrayOf(1, 2).toIntArray()
        assertEquals(1, ints[0])
        assertEquals(2, ints[1])
    }

    @Test
    fun copyOf() {
        val ints = observableIntArrayOf(1, 2)
        val ints2 = ints.copyOf()
        assertEquals(ints[0], ints2[0])
        assertEquals(ints[1], ints2[1])
    }

    @Test
    fun contains() {
        val ints = observableIntArrayOf(1, 2)
        assertTrue(1 in ints)
        assertTrue(2 in ints)
    }

    @Test
    fun indexOf() {
        val ints = observableIntArrayOf(1, 2)
        assertEquals(-1, ints.indexOf(0))
        assertEquals(0, ints.indexOf(1))
        assertEquals(1, ints.indexOf(2))
    }

    @Test
    fun lastIndexOf() {
        val ints = observableIntArrayOf(1, 2, 1, 2)
        assertEquals(-1, ints.lastIndexOf(0))
        assertEquals(2, ints.lastIndexOf(1))
        assertEquals(3, ints.lastIndexOf(2))
    }

    @Test
    fun getOrElse() {
        val ints = observableIntArrayOf(1, 2)
        assertEquals(3, ints.getOrElse(-1) { 3 })
        assertEquals(3, ints.getOrElse(2) { 3 })
    }

    @Test
    fun getOrNull() {
        val ints = observableIntArrayOf(1, 2)
        assertNull(ints.getOrNull(-1))
        assertNull(ints.getOrNull(2))
    }

    @Test
    fun plusAssign() {
        val ints = ktfx.collections.observableIntArrayOf()
        ints += 1
        assertEquals(1, ints[0])
        ints += intArrayOf(2, 3)
        assertEquals(2, ints[1])
        assertEquals(3, ints[2])
        ints += observableIntArrayOf(4, 5)
        assertEquals(4, ints[3])
        assertEquals(5, ints[4])
    }

    @Test
    fun forEach() {
        var total = 0
        observableIntArrayOf(1, 2).forEach { total += it }
        assertEquals(3, total)
    }

    @Test
    fun forEachIndexed() {
        val indexToInt = mutableMapOf<Int, Int>()
        observableIntArrayOf(1, 2).forEachIndexed { i, i2 -> indexToInt += i to i2 }
        assertThat(indexToInt)
            .containsExactly(0, 1, 1, 2)
    }

    @Test
    fun iterator() {
        var total = 0
        for (f in observableIntArrayOf(1, 2)) {
            total += f
        }
        assertEquals(3, total)
    }
}
