package ktfx.collections

import javafx.collections.ObservableFloatArray
import ktfx.test.BaseArrayTest

class ObservableArrayFloatTest : BaseArrayTest<ObservableFloatArray, FloatArray, Float>() {

    override val typedArray = arrayOf(1f, 2f, 3f)
    override val primitiveArray = floatArrayOf(1f, 2f, 3f)

    override fun of() = observableFloatArrayOf()
    override fun of(values: Array<Float>) = observableFloatArrayOf(*values.toFloatArray())

    override fun Array<Float>.to() = toObservableArray()
    override fun FloatArray.to() = toObservableArray()
}
