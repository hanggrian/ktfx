package ktfx.collections

import com.hendraanggrian.ktfx.test.ArrayTest
import javafx.collections.ObservableIntegerArray

class ObservableArraysIntTest : ArrayTest<ObservableIntegerArray, IntArray, Int>() {
    override val typedArray = arrayOf(1, 2, 3)
    override val primitiveArray = intArrayOf(1, 2, 3)

    override fun of(): ObservableIntegerArray = observableIntArrayOf()

    override fun of(values: Array<Int>): ObservableIntegerArray =
        observableIntArrayOf(*values.toIntArray())

    override fun IntArray.to() = toObservableArray()
}
