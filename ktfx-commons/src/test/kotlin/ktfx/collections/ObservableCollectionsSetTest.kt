package ktfx.collections

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test
import kotlin.test.assertEquals

class ObservableCollectionsSetTest {
    @Test
    fun emptyObservableSet() = assertEquals(0, emptyObservableSet<Int>().size)

    @Test
    fun observableSetOf() {
        assertEquals(0, observableSetOf<Int>().size)
        assertEquals(0, observableSetOf(*intArrayOf().toTypedArray()).size)
        assertEquals(1, observableSetOf(1).size)
        assertEquals(2, observableSetOf(1, 2).size)
    }

    @Test
    fun mutableObservableSetOf() {
        assertEquals(0, mutableObservableSetOf<Int>().size)
        assertEquals(2, mutableObservableSetOf(1, 2).size)
    }

    @Test
    fun observableListOfNotNull() {
        assertEquals(0, observableSetOfNotNull(null).size)
        assertEquals(2, observableSetOfNotNull(null, 1, null, 2).size)
    }

    @Test
    @OptIn(ExperimentalStdlibApi::class)
    fun buildObservableSet() {
        val ints =
            buildObservableSet {
                add(1)
                add(2)
            }
        assertEquals(1, ints.first())
        assertEquals(2, ints.last())
    }

    @Test
    fun toObservableSet() {
        assertThat(arrayOf<String>().toObservableSet())
            .isEmpty()
        assertThat(arrayOf("Hello").toObservableSet())
            .containsExactly("Hello")
        assertThat(arrayOf("Hello", "World").toObservableSet())
            .containsExactly("Hello", "World")

        assertThat(byteArrayOf().toObservableSet())
            .isEmpty()
        assertThat(byteArrayOf(0x00).toObservableSet())
            .containsExactly(0x00.toByte())
        assertThat(byteArrayOf(0x00, 0x01).toObservableSet())
            .containsExactly(0x00.toByte(), 0x01.toByte())

        assertThat(charArrayOf().toObservableSet())
            .isEmpty()
        assertThat(charArrayOf('a').toObservableSet())
            .containsExactly('a')
        assertThat(charArrayOf('a', 'b').toObservableSet())
            .containsExactly('a', 'b')

        assertThat(shortArrayOf().toObservableSet())
            .isEmpty()
        assertThat(shortArrayOf(1).toObservableSet())
            .containsExactly(1.toShort())
        assertThat(shortArrayOf(1, 2).toObservableSet())
            .containsExactly(1.toShort(), 2.toShort())

        assertThat(intArrayOf().toObservableSet())
            .isEmpty()
        assertThat(intArrayOf(1).toObservableSet())
            .containsExactly(1)
        assertThat(intArrayOf(1, 2).toObservableSet())
            .containsExactly(1, 2)

        assertThat(longArrayOf().toObservableSet())
            .isEmpty()
        assertThat(longArrayOf(1L).toObservableSet())
            .containsExactly(1L)
        assertThat(longArrayOf(1L, 2L).toObservableSet())
            .containsExactly(1L, 2L)

        assertThat(floatArrayOf().toObservableSet())
            .isEmpty()
        assertThat(floatArrayOf(1f).toObservableSet())
            .containsExactly(1f)
        assertThat(floatArrayOf(1f, 2f).toObservableSet())
            .containsExactly(1f, 2f)

        assertThat(doubleArrayOf().toObservableSet())
            .isEmpty()
        assertThat(doubleArrayOf(1.0).toObservableSet())
            .containsExactly(1.0)
        assertThat(doubleArrayOf(1.0, 2.0).toObservableSet())
            .containsExactly(1.0, 2.0)

        assertThat(booleanArrayOf().toObservableSet())
            .isEmpty()
        assertThat(booleanArrayOf(true).toObservableSet())
            .containsExactly(true)
        assertThat(booleanArrayOf(true, false).toObservableSet())
            .containsExactly(true, false)

        assertThat(emptyList<String>().toObservableSet())
            .isEmpty()
        assertThat(listOf("Hello").toObservableSet())
            .containsExactly("Hello")
        assertThat(listOf("Hello", "World").toObservableSet())
            .containsExactly("Hello", "World")

        assertThat(sequenceOf("Hello", "World").toObservableSet())
            .containsExactly("Hello", "World")
    }

    @Test
    fun toMutableObservableList() {
        assertThat(arrayOf("Hello", "World").toMutableObservableSet())
            .containsExactly("Hello", "World")

        assertThat(byteArrayOf(0x00, 0x01).toMutableObservableSet())
            .containsExactly(0x00.toByte(), 0x01.toByte())

        assertThat(charArrayOf('a', 'b').toMutableObservableSet())
            .containsExactly('a', 'b')

        assertThat(shortArrayOf(1, 2).toMutableObservableSet())
            .containsExactly(1.toShort(), 2.toShort())

        assertThat(intArrayOf(1, 2).toMutableObservableSet())
            .containsExactly(1, 2)

        assertThat(longArrayOf(1L, 2L).toMutableObservableSet())
            .containsExactly(1L, 2L)

        assertThat(floatArrayOf(1f, 2f).toMutableObservableSet())
            .containsExactly(1f, 2f)

        assertThat(doubleArrayOf(1.0, 2.0).toMutableObservableSet())
            .containsExactly(1.0, 2.0)

        assertThat(booleanArrayOf(true, false).toMutableObservableSet())
            .containsExactly(true, false)

        assertThat(listOf("Hello", "World").toMutableObservableSet())
            .containsExactly("Hello", "World")

        assertThat(sequenceOf("Hello", "World").toMutableObservableSet())
            .containsExactly("Hello", "World")
    }
}
