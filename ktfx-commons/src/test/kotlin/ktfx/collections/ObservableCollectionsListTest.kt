package ktfx.collections

import com.google.common.truth.Truth.assertThat
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class ObservableCollectionsListTest {
    @Test
    fun emptyObservableList() = assertEquals(0, emptyObservableList<Int>().size)

    @Test
    fun observableListOf() {
        assertEquals(0, observableListOf<Int>().size)
        assertEquals(0, observableListOf(*intArrayOf().toTypedArray()).size)
        assertEquals(1, observableListOf(1).size)
        assertEquals(2, observableListOf(1, 2).size)
    }

    @Test
    fun mutableObservableListOf() {
        assertEquals(0, mutableObservableListOf<Int>().size)
        assertEquals(2, mutableObservableListOf(1, 2).size)
    }

    @Test
    fun observableListOfNotNull() {
        assertEquals(0, observableListOfNotNull(null).size)
        assertEquals(2, observableListOfNotNull(null, 1, null, 2).size)
    }

    @Test
    @OptIn(ExperimentalStdlibApi::class)
    fun buildObservableList() {
        val ints =
            buildObservableList {
                add(1)
                add(2)
            }
        assertEquals(1, ints.first())
        assertEquals(2, ints.last())
    }

    @Test
    fun toObservableList() {
        assertThat(arrayOf<String>().toObservableList())
            .isEmpty()
        assertThat(arrayOf("Hello").toObservableList())
            .containsExactly("Hello")
        assertThat(arrayOf("Hello", "World").toObservableList())
            .containsExactly("Hello", "World")

        assertThat(byteArrayOf().toObservableList())
            .isEmpty()
        assertThat(byteArrayOf(0x00).toObservableList())
            .containsExactly(0x00.toByte())
        assertThat(byteArrayOf(0x00, 0x01).toObservableList())
            .containsExactly(0x00.toByte(), 0x01.toByte())

        assertThat(charArrayOf().toObservableList())
            .isEmpty()
        assertThat(charArrayOf('a').toObservableList())
            .containsExactly('a')
        assertThat(charArrayOf('a', 'b').toObservableList())
            .containsExactly('a', 'b')

        assertThat(shortArrayOf().toObservableList())
            .isEmpty()
        assertThat(shortArrayOf(1).toObservableList())
            .containsExactly(1.toShort())
        assertThat(shortArrayOf(1, 2).toObservableList())
            .containsExactly(1.toShort(), 2.toShort())

        assertThat(intArrayOf().toObservableList())
            .isEmpty()
        assertThat(intArrayOf(1).toObservableList())
            .containsExactly(1)
        assertThat(intArrayOf(1, 2).toObservableList())
            .containsExactly(1, 2)

        assertThat(longArrayOf().toObservableList())
            .isEmpty()
        assertThat(longArrayOf(1L).toObservableList())
            .containsExactly(1L)
        assertThat(longArrayOf(1L, 2L).toObservableList())
            .containsExactly(1L, 2L)

        assertThat(floatArrayOf().toObservableList())
            .isEmpty()
        assertThat(floatArrayOf(1f).toObservableList())
            .containsExactly(1f)
        assertThat(floatArrayOf(1f, 2f).toObservableList())
            .containsExactly(1f, 2f)

        assertThat(doubleArrayOf().toObservableList())
            .isEmpty()
        assertThat(doubleArrayOf(1.0).toObservableList())
            .containsExactly(1.0)
        assertThat(doubleArrayOf(1.0, 2.0).toObservableList())
            .containsExactly(1.0, 2.0)

        assertThat(booleanArrayOf().toObservableList())
            .isEmpty()
        assertThat(booleanArrayOf(true).toObservableList())
            .containsExactly(true)
        assertThat(booleanArrayOf(true, false).toObservableList())
            .containsExactly(true, false)

        assertThat(emptyList<String>().toObservableList())
            .isEmpty()
        assertThat(listOf("Hello").toObservableList())
            .containsExactly("Hello")
        assertThat(listOf("Hello", "World").toObservableList())
            .containsExactly("Hello", "World")

        assertThat(sequenceOf("Hello", "World").toObservableList())
            .containsExactly("Hello", "World")
    }

    @Test
    fun toMutableObservableList() {
        assertThat(arrayOf("Hello", "World").toMutableObservableList())
            .containsExactly("Hello", "World")

        assertThat(byteArrayOf(0x00, 0x01).toMutableObservableList())
            .containsExactly(0x00.toByte(), 0x01.toByte())

        assertThat(charArrayOf('a', 'b').toMutableObservableList())
            .containsExactly('a', 'b')

        assertThat(shortArrayOf(1, 2).toMutableObservableList())
            .containsExactly(1.toShort(), 2.toShort())

        assertThat(intArrayOf(1, 2).toMutableObservableList())
            .containsExactly(1, 2)

        assertThat(longArrayOf(1L, 2L).toMutableObservableList())
            .containsExactly(1L, 2L)

        assertThat(floatArrayOf(1f, 2f).toMutableObservableList())
            .containsExactly(1f, 2f)

        assertThat(doubleArrayOf(1.0, 2.0).toMutableObservableList())
            .containsExactly(1.0, 2.0)

        assertThat(booleanArrayOf(true, false).toMutableObservableList())
            .containsExactly(true, false)

        assertThat(listOf("Hello", "World").toMutableObservableList())
            .containsExactly("Hello", "World")

        assertThat(sequenceOf("Hello", "World").toMutableObservableList())
            .containsExactly("Hello", "World")
    }

    @Test
    fun copyFrom() {
        val ints = mutableObservableListOf(1, 2)
        ints.copyFrom(listOf(3, 4))
        assertThat(ints)
            .containsExactly(3, 4)
    }

    @Test
    fun fillWith() {
        val ints = mutableObservableListOf(1, 2)
        ints.fillWith(3)
        assertEquals(3, ints.first())
        assertEquals(3, ints.last())
    }

    @Test
    fun replaceAll() {
        val ints = mutableObservableListOf(1, 2)
        ints.replaceAll(1, 3)
        assertEquals(3, ints.first())
        assertEquals(2, ints.last())
    }

    @Test
    fun reverse() {
        val ints = mutableObservableListOf(1, 2)
        ints.reverse()
        assertEquals(2, ints.first())
        assertEquals(1, ints.last())
    }

    @Test
    fun rotate() {
        val ints = mutableObservableListOf(1, 2, 3)
        ints.rotate(1)
        assertEquals(3, ints.first())
        assertEquals(2, ints.last())
    }

    @Test
    fun shuffle() {
        val ints = mutableObservableListOf(1, 2)
        ints.shuffle()
        assertEquals(2, ints.size)
        ints.shuffle(Random.Default)
        assertEquals(2, ints.size)
    }

    @Test
    fun sort() {
        val ints = mutableObservableListOf(2, 1)
        ints.sort()
        assertEquals(1, ints.first())
        assertEquals(2, ints.last())
    }

    @Test
    fun sortWith() {
        val ints = mutableObservableListOf(2, 1)
        ints.sortWith { a, b -> a.compareTo(b) }
        assertEquals(1, ints.first())
        assertEquals(2, ints.last())
    }
}
