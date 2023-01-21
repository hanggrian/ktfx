package com.hendraanggrian.ktfx.test

import javafx.collections.ObservableArray
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

/** All observable array tests must follow this convention. */
abstract class BaseArraysTest<T : ObservableArray<T>, PrimitiveArray, E> {
    abstract val typedArray: Array<E>
    abstract val primitiveArray: PrimitiveArray

    abstract fun of(): T
    abstract fun of(values: Array<E>): T

    @Test
    fun creating() {
        val empty = of()
        assertEquals(0, empty.size())

        val filled = of(typedArray)
        assertNotEquals(0, filled.size())
    }

    abstract fun PrimitiveArray.to(): T

    @Test
    fun converting() {
        val typedArray = primitiveArray.to()
        assertNotEquals(0, typedArray.size())
    }
}
