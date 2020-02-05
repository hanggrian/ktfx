package ktfx.collections

import javafx.collections.ObservableMap
import ktfx.test.BaseMapTest

class ObservableCollectionsMapTest : BaseMapTest<ObservableMap<String, Any?>>() {

    override fun empty() = emptyObservableMap<String, Any?>()
    override fun of() = observableMapOf<String, Any?>()
    override fun of(value: String) = observableMapOf<String, Any?>(value to null)
    override fun of(vararg values: String) = observableMapOf<String, Any?>(*values.map { it to null }.toTypedArray())
    override fun mutableOf() = mutableObservableMapOf<String, Any?>()
    override fun mutableOf(vararg values: String) =
        mutableObservableMapOf<String, Any?>(*values.map { it to null }.toTypedArray())

    override fun Map<String, Any?>.to() = toObservableMap()
    override fun Map<String, Any?>.toMutable() = toMutableObservableMap()
}
