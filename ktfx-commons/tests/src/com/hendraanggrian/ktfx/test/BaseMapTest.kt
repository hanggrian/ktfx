package com.hendraanggrian.ktfx.test

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test
import kotlin.test.assertFails

abstract class BaseMapTest<T : MutableMap<String, Any?>> {

    private companion object {
        const val SINGLETON_VALUE = "Lonely text"
        val FILL_VALUES = arrayOf("I'm", "a", "little", "piggy")
        const val ADD_VALUE = "Oink"

        val MAP = mapOf(*FILL_VALUES.map { it to null }.toTypedArray())
    }

    abstract fun empty(): T
    abstract fun of(): T
    abstract fun of(value: String): T
    abstract fun of(vararg values: String): T
    abstract fun mutableOf(): T
    abstract fun mutableOf(vararg values: String): T

    @Test fun creating() {
        val empty = empty()
        assertThat(empty.keys).isEmpty()
        assertFails { empty[ADD_VALUE] = null }

        val unfilled = of()
        assertThat(unfilled.keys).isEmpty()
        assertFails { unfilled[ADD_VALUE] = null }

        val singleton = of(SINGLETON_VALUE)
        assertThat(singleton.keys).containsExactly(SINGLETON_VALUE)
        assertFails { singleton[ADD_VALUE] = null }

        val filled = of(*FILL_VALUES)
        assertThat(filled.keys).containsExactly(*FILL_VALUES)
        assertFails { filled[ADD_VALUE] = null }

        val mutableUnfilled = mutableOf()
        mutableUnfilled[ADD_VALUE] = null
        assertThat(mutableUnfilled.keys).containsExactly(ADD_VALUE)

        val mutableFilled = mutableOf(*FILL_VALUES)
        mutableFilled[ADD_VALUE] = null
        assertThat(mutableFilled.keys).containsExactly(*FILL_VALUES, ADD_VALUE)
    }

    abstract fun Map<String, Any?>.to(): T
    abstract fun Map<String, Any?>.toMutable(): T

    @Test fun converting() {
        val fromArray = MAP.to()
        assertThat(fromArray.keys).containsExactly(*FILL_VALUES)
        assertFails { fromArray[ADD_VALUE] = null }

        val mutableFromArray = MAP.toMutable()
        mutableFromArray[ADD_VALUE] = null
        assertThat(mutableFromArray.keys).containsExactly(*FILL_VALUES, ADD_VALUE)
    }
}
