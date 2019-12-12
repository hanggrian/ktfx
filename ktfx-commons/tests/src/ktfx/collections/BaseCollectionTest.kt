package ktfx.collections

import ktfx.test.assertContains
import ktfx.test.assertEmpty
import kotlin.test.Test
import kotlin.test.assertFails

/** All observable collection tests must follow this convention. */
abstract class BaseCollectionTest<T : MutableCollection<String>> {

    private companion object {
        const val SINGLETON_VALUE = "Lonely text"
        val FILL_VALUES = arrayOf("I'm", "a", "little", "piggy")
        const val ADD_VALUE = "Oink"

        val ARRAY = arrayOf(*FILL_VALUES)
        val LIST = listOf(*FILL_VALUES)
        val SEQUENCE = sequenceOf(*FILL_VALUES)
    }

    abstract fun empty(): T
    abstract fun of(): T
    abstract fun of(value: String): T
    abstract fun of(vararg values: String): T
    abstract fun mutableOf(): T
    abstract fun mutableOf(vararg values: String): T

    @Test fun creating() {
        val empty = empty()
        assertEmpty(empty)
        assertFails { empty += ADD_VALUE }

        val unfilled = of()
        assertEmpty(unfilled)
        assertFails { unfilled += ADD_VALUE }

        val singleton = of(SINGLETON_VALUE)
        assertContains(
            singleton,
            SINGLETON_VALUE
        )
        assertFails { singleton += ADD_VALUE }

        val filled = of(*FILL_VALUES)
        assertContains(
            filled,
            *FILL_VALUES
        )
        assertFails { filled += ADD_VALUE }

        val mutableUnfilled = mutableOf()
        mutableUnfilled += ADD_VALUE
        assertContains(
            mutableUnfilled,
            ADD_VALUE
        )

        val mutableFilled = mutableOf(*FILL_VALUES)
        mutableFilled += ADD_VALUE
        assertContains(
            mutableFilled,
            *FILL_VALUES,
            ADD_VALUE
        )
    }

    abstract fun Array<String>.to(): T
    abstract fun List<String>.to(): T
    abstract fun Sequence<String>.to(): T
    abstract fun Array<String>.toMutable(): T
    abstract fun List<String>.toMutable(): T
    abstract fun Sequence<String>.toMutable(): T

    @Test fun converting() {
        val fromArray = ARRAY.to()
        assertContains(
            fromArray,
            *FILL_VALUES
        )
        assertFails { fromArray += ADD_VALUE }

        val fromList = LIST.to()
        assertContains(
            fromList,
            *FILL_VALUES
        )
        assertFails { fromList += ADD_VALUE }

        val fromSequence = SEQUENCE.to()
        assertContains(
            fromSequence,
            *FILL_VALUES
        )
        assertFails { fromSequence += ADD_VALUE }

        val mutableFromArray = ARRAY.toMutable()
        mutableFromArray += ADD_VALUE
        assertContains(
            mutableFromArray,
            *FILL_VALUES,
            ADD_VALUE
        )

        val mutableFromList = LIST.toMutable()
        mutableFromList += ADD_VALUE
        assertContains(
            mutableFromList,
            *FILL_VALUES,
            ADD_VALUE
        )

        val mutableFromSequence = SEQUENCE.toMutable()
        mutableFromSequence += ADD_VALUE
        assertContains(
            mutableFromSequence,
            *FILL_VALUES,
            ADD_VALUE
        )
    }
}
