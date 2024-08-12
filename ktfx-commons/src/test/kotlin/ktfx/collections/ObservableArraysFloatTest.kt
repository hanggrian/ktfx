package ktfx.collections

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ObservableArraysFloatTest {
    @Test
    fun emptyObservableFloatArray() =
        assertEquals(0, ktfx.collections.emptyObservableFloatArray().size())

    @Test
    fun observableFloatArrayOf() {
        assertEquals(0, ktfx.collections.observableFloatArrayOf().size())
        assertEquals(0, observableFloatArrayOf(*floatArrayOf()).size())
        assertEquals(2, observableFloatArrayOf(1f, 2f).size())
    }

    @Test
    fun toObservableFloatArray() {
        val floats = floatArrayOf(1f, 2f).toObservableArray()
        assertEquals(1f, floats[0])
        assertEquals(2f, floats[1])
    }

    @Test
    fun toFloatArray() {
        val floats = observableFloatArrayOf(1f, 2f).toFloatArray()
        assertEquals(1f, floats[0])
        assertEquals(2f, floats[1])
    }

    @Test
    fun copyOf() {
        val floats = observableFloatArrayOf(1f, 2f)
        val floats2 = floats.copyOf()
        assertEquals(floats[0], floats2[0])
        assertEquals(floats[1], floats2[1])
    }

    @Test
    fun contains() {
        val floats = observableFloatArrayOf(1f, 2f)
        assertTrue(1f in floats)
        assertTrue(2f in floats)
    }

    @Test
    fun indexOf() {
        val floats = observableFloatArrayOf(1f, 2f)
        assertEquals(-1, floats.indexOf(0f))
        assertEquals(0, floats.indexOf(1f))
        assertEquals(1, floats.indexOf(2f))
    }

    @Test
    fun lastIndexOf() {
        val floats = observableFloatArrayOf(1f, 2f, 1f, 2f)
        assertEquals(-1, floats.lastIndexOf(0f))
        assertEquals(2, floats.lastIndexOf(1f))
        assertEquals(3, floats.lastIndexOf(2f))
    }

    @Test
    fun getOrElse() {
        val floats = observableFloatArrayOf(1f, 2f)
        assertEquals(3f, floats.getOrElse(-1) { 3f })
        assertEquals(3f, floats.getOrElse(2) { 3f })
    }

    @Test
    fun getOrNull() {
        val floats = observableFloatArrayOf(1f, 2f)
        assertNull(floats.getOrNull(-1))
        assertNull(floats.getOrNull(2))
    }

    @Test
    fun plusAssign() {
        val floats = ktfx.collections.observableFloatArrayOf()
        floats += 1f
        assertEquals(1f, floats[0])
        floats += floatArrayOf(2f, 3f)
        assertEquals(2f, floats[1])
        assertEquals(3f, floats[2])
        floats += observableFloatArrayOf(4f, 5f)
        assertEquals(4f, floats[3])
        assertEquals(5f, floats[4])
    }

    @Test
    fun forEach() {
        var total = 0f
        observableFloatArrayOf(1f, 2f).forEach { total += it }
        assertEquals(3f, total)
    }

    @Test
    fun forEachIndexed() {
        val indexToFloat = mutableMapOf<Int, Float>()
        observableFloatArrayOf(1f, 2f).forEachIndexed { i, f -> indexToFloat += i to f }
        assertThat(indexToFloat)
            .containsExactly(0, 1f, 1, 2f)
    }

    @Test
    fun iterator() {
        var total = 0f
        for (f in observableFloatArrayOf(1f, 2f)) {
            total += f
        }
        assertEquals(3f, total)
    }
}
