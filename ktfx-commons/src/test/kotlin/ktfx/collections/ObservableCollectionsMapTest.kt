package ktfx.collections

import com.hanggrian.ktfx.test.MapTest
import javafx.collections.ObservableMap

class ObservableCollectionsMapTest : MapTest<ObservableMap<String, Any?>>() {
    override fun empty(): ObservableMap<String, Any?> = emptyObservableMap()

    override fun of(): ObservableMap<String, Any?> = observableMapOf()

    override fun of(value: String): ObservableMap<String, Any?> = observableMapOf(value to null)

    override fun of(vararg values: String): ObservableMap<String, Any?> =
        observableMapOf(*values.map { it to null }.toTypedArray())

    override fun mutableOf(): ObservableMap<String, Any?> = mutableObservableMapOf()

    override fun mutableOf(vararg values: String): ObservableMap<String, Any?> =
        mutableObservableMapOf(*values.map { it to null }.toTypedArray())

    override fun Map<String, Any?>.to() = toObservableMap()

    override fun Map<String, Any?>.toMutable() = toMutableObservableMap()
}
