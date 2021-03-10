package ktfx.collections

import javafx.collections.ObservableList
import io.github.hendraanggrian.ktfx.test.BaseCollectionsTest

class ObservableCollectionsListTest : BaseCollectionsTest<ObservableList<String>>() {

    override fun empty() = emptyObservableList<String>()
    override fun of() = observableListOf<String>()
    override fun of(value: String) = observableListOf(value)
    override fun of(vararg values: String) = observableListOf(*values)
    override fun mutableOf() = mutableObservableListOf<String>()
    override fun mutableOf(vararg values: String) = mutableObservableListOf(*values)

    override fun Array<String>.to() = toObservableList()
    override fun List<String>.to() = toObservableList()
    override fun Sequence<String>.to() = toObservableList()
    override fun Array<String>.toMutable() = toMutableObservableList()
    override fun List<String>.toMutable() = toMutableObservableList()
    override fun Sequence<String>.toMutable() = toMutableObservableList()
}
