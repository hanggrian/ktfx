package ktfx.test

import javafx.collections.ObservableArray
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

/** All observable array tests must follow this convention. */
abstract class BaseArrayTest<T : ObservableArray<T>, UnboxedArray, E> {

    abstract val boxedArray: Array<E>
    abstract val unboxedArray: UnboxedArray

    abstract fun of(): T
    abstract fun of(values: Array<E>): T

    @Test fun creating() {
        val empty = of()
        assertEquals(0, empty.size())

        val filled = of(boxedArray)
        assertNotEquals(0, filled.size())
    }

    abstract fun Array<E>.to(): T
    abstract fun UnboxedArray.to(): T

    @Test fun converting() {
        val array = boxedArray.to()
        assertNotEquals(0, array.size())

        val typedArray = unboxedArray.to()
        assertNotEquals(0, typedArray.size())
    }
}
