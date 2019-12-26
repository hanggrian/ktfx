package ktfx.collections

import javafx.collections.ObservableIntegerArray
import ktfx.test.BaseArrayTest

class ObservableArrayIntTest : BaseArrayTest<ObservableIntegerArray, IntArray, Int>() {

    override val boxedArray = arrayOf(1, 2, 3)
    override val unboxedArray = intArrayOf(1, 2, 3)

    override fun of() = observableIntArrayOf()
    override fun of(values: Array<Int>) = observableIntArrayOf(*values.toIntArray())

    override fun Array<Int>.to() = toObservableArray()
    override fun IntArray.to() = toObservableArray()
}
