package ktfx.collections

import com.hendraanggrian.ktfx.test.ArrayTest
import javafx.collections.ObservableFloatArray

class ObservableArraysFloatTest : ArrayTest<ObservableFloatArray, FloatArray, Float>() {
    override val typedArray = arrayOf(1f, 2f, 3f)
    override val primitiveArray = floatArrayOf(1f, 2f, 3f)

    override fun of(): ObservableFloatArray = observableFloatArrayOf()

    override fun of(values: Array<Float>): ObservableFloatArray =
        observableFloatArrayOf(*values.toFloatArray())

    override fun FloatArray.to() = toObservableArray()
}
