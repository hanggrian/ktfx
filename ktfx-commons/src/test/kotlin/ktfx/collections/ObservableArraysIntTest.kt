package ktfx.collections

import com.hendraanggrian.ktfx.test.BaseArraysTest
import javafx.collections.ObservableIntegerArray

class ObservableArraysIntTest : BaseArraysTest<ObservableIntegerArray, IntArray, Int>() {
    override val typedArray = arrayOf(1, 2, 3)
    override val primitiveArray = intArrayOf(1, 2, 3)

    override fun of(): ObservableIntegerArray = observableIntArrayOf()
    override fun of(values: Array<Int>): ObservableIntegerArray =
        observableIntArrayOf(*values.toIntArray())

    override fun IntArray.to() = toObservableArray()
}
