package ktfx.collections

import ktfx.test.assertContains
import ktfx.test.assertEmpty
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
        assertEmpty(empty.keys)
        assertFails { empty[ADD_VALUE] = null }

        val unfilled = of()
        assertEmpty(unfilled.keys)
        assertFails { unfilled[ADD_VALUE] = null }

        val singleton = of(SINGLETON_VALUE)
        assertContains(
            singleton.keys,
            SINGLETON_VALUE
        )
        assertFails { singleton[ADD_VALUE] = null }

        val filled = of(*FILL_VALUES)
        assertContains(
            filled.keys,
            *FILL_VALUES
        )
        assertFails { filled[ADD_VALUE] = null }

        val mutableUnfilled = mutableOf()
        mutableUnfilled[ADD_VALUE] = null
        assertContains(
            mutableUnfilled.keys,
            ADD_VALUE
        )

        val mutableFilled = mutableOf(*FILL_VALUES)
        mutableFilled[ADD_VALUE] = null
        assertContains(
            mutableFilled.keys,
            *FILL_VALUES,
            ADD_VALUE
        )
    }

    abstract fun Map<String, Any?>.to(): T
    abstract fun Map<String, Any?>.toMutable(): T

    @Test fun converting() {
        val fromArray = MAP.to()
        assertContains(
            fromArray.keys,
            *FILL_VALUES
        )
        assertFails { fromArray[ADD_VALUE] = null }

        val mutableFromArray = MAP.toMutable()
        mutableFromArray[ADD_VALUE] = null
        assertContains(
            mutableFromArray.keys,
            *FILL_VALUES,
            ADD_VALUE
        )
    }
}
