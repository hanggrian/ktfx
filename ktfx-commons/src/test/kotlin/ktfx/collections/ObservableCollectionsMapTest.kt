package ktfx.collections

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test
import kotlin.test.assertEquals

class ObservableCollectionsMapTest {
    @Test
    fun emptyObservableMap() = assertEquals(0, emptyObservableMap<Int, Float>().size)

    @Test
    fun observableMapOf() {
        assertEquals(0, observableMapOf<Int, Float>().size)
        assertEquals(0, observableMapOf(*emptyArray<Pair<Int, Float>>()).size)
        assertEquals(2, observableMapOf(1 to 1f, 2 to 2f).size)
    }

    @Test
    fun mutableObservableMapOf() {
        assertEquals(0, mutableObservableMapOf<Int, Float>().size)
        assertEquals(2, mutableObservableMapOf(1 to 1f, 2 to 2f).size)
    }

    @Test
    @OptIn(ExperimentalStdlibApi::class)
    fun buildObservableMap() {
        val ints =
            buildObservableMap {
                put(1, 1f)
                put(2, 2f)
            }
        assertEquals(1f, ints.values.first())
        assertEquals(2f, ints.values.last())
    }

    @Test
    fun toObservableMap() {
        assertThat(emptyMap<Int, Float>().toObservableMap())
            .isEmpty()
        assertThat(mapOf(1 to 1f, 2 to 2f).toObservableMap())
            .containsExactly(1, 1f, 2, 2f)
    }

    @Test
    fun toMutableObservableMap() {
        assertThat(mapOf(1 to 1f, 2 to 2f).toMutableObservableMap())
            .containsExactly(1, 1f, 2, 2f)
    }
}
