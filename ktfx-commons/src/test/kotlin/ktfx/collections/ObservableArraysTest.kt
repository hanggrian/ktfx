package ktfx.collections

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ObservableArraysTest {
    @Test
    fun indices() {
        assertThat(observableIntArrayOf(1, 2).indices)
            .containsExactly(0, 1)
    }

    @Test
    fun lastIndex() {
        assertEquals(1, observableIntArrayOf(1, 2).lastIndex)
    }

    @Test
    fun isEmpty() {
        assertFalse(observableIntArrayOf(1, 2).isEmpty())
    }

    @Test
    fun isNotEmpty() {
        assertTrue(observableIntArrayOf(1, 2).isNotEmpty())
    }

    @Test
    fun sizeBinding() {
        val ints = observableIntArrayOf(1, 2)
        val binding = ints.sizeBinding
        assertEquals(2, binding.value)
        ints += 3
        assertEquals(3, binding.value)
    }
}
