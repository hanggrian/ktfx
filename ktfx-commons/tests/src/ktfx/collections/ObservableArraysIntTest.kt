package ktfx.collections

import javafx.collections.ObservableIntegerArray
import com.hendraanggrian.ktfx.test.BaseArraysTest

class ObservableArraysIntTest : BaseArraysTest<ObservableIntegerArray, IntArray, Int>() {

    override val typedArray = arrayOf(1, 2, 3)
    override val primitiveArray = intArrayOf(1, 2, 3)

    override fun of() = observableIntArrayOf()
    override fun of(values: Array<Int>) = observableIntArrayOf(*values.toIntArray())

    override fun IntArray.to() = toObservableArray()
}
