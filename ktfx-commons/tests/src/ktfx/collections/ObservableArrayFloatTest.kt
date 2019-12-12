package ktfx.collections

import javafx.collections.ObservableFloatArray

class ObservableArrayFloatTest : BaseArrayTest<ObservableFloatArray, FloatArray, Float>() {

    override val boxedArray = arrayOf(1f, 2f, 3f)
    override val unboxedArray = floatArrayOf(1f, 2f, 3f)

    override fun of() = observableFloatArrayOf()
    override fun of(values: Array<Float>) = observableFloatArrayOf(*values.toFloatArray())

    override fun Array<Float>.to() = toObservableArray()
    override fun FloatArray.to() = toObservableArray()
}