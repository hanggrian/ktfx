package ktfx.collections

import javafx.collections.ObservableSet
import ktfx.test.BaseCollectionsTest

class ObservableCollectionsSetTest : BaseCollectionsTest<ObservableSet<String>>() {

    override fun empty() = emptyObservableSet<String>()
    override fun of() = observableSetOf<String>()
    override fun of(value: String) = observableSetOf(value)
    override fun of(vararg values: String) = observableSetOf(*values)
    override fun mutableOf() = mutableObservableSetOf<String>()
    override fun mutableOf(vararg values: String) = mutableObservableSetOf(*values)

    override fun Array<String>.to() = toObservableSet()
    override fun List<String>.to() = toObservableSet()
    override fun Sequence<String>.to() = toObservableSet()
    override fun Array<String>.toMutable() = toMutableObservableSet()
    override fun List<String>.toMutable() = toMutableObservableSet()
    override fun Sequence<String>.toMutable() = toMutableObservableSet()
}
