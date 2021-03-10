package ktfx.collections

import javafx.collections.ObservableFloatArray
import io.github.hendraanggrian.ktfx.test.BaseArraysTest

class ObservableArraysFloatTest : BaseArraysTest<ObservableFloatArray, FloatArray, Float>() {

    override val typedArray = arrayOf(1f, 2f, 3f)
    override val primitiveArray = floatArrayOf(1f, 2f, 3f)

    override fun of() = observableFloatArrayOf()
    override fun of(values: Array<Float>) = observableFloatArrayOf(*values.toFloatArray())

    override fun FloatArray.to() = toObservableArray()
}
